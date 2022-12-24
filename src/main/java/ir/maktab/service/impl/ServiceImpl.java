package ir.maktab.service.impl;

import ir.maktab.entity.Account;
import ir.maktab.entity.CurrentAccount;
import ir.maktab.entity.LongTermAccount;
import ir.maktab.entity.ShortTermAccount;
import ir.maktab.exception.AccountException;
import ir.maktab.repository.AccountRepo;
import ir.maktab.repository.PersonRepository;
import ir.maktab.service.Service;
import ir.maktab.validation.AccountValidation;

import java.util.Date;

public class ServiceImpl implements Service {
   /* private static ServiceImpl instance = new  ServiceImpl();

    private  ServiceImpl() {
    }
    public static  ServiceImpl getInstance() {
        return instance;
    }
//private static Service service= (Service) AccountRepo.getInstance();*/
   AccountRepo accountRepo=new AccountRepo();
    @Override
    public void create(Account account) throws AccountException {
        AccountValidation.validCardNumber(account.getCardNumber());
        accountRepo.create(account);
    }

    @Override
    public Account getAccount(String cardNumber, String accountNumber,
                              Date openingDate, Date expiryDate, double amount,
                              int cvv2,String type) throws AccountException {
        boolean isIssuingCheck= true;
        double annualProfit = 20000;
        double profit = 5000;
        if (amount < 50000) {
            throw new AccountException("you cannot create account");

        } else if (type.equalsIgnoreCase("CurrentAccount") && amount >= 100000) {
            return new CurrentAccount( cardNumber, accountNumber,
                    openingDate, expiryDate, amount,
            cvv2,  isIssuingCheck);

        } else if (type.equalsIgnoreCase("LongTermAccount") && amount >= 100000) {
            return new LongTermAccount(cardNumber, accountNumber,
                    openingDate, expiryDate, amount, cvv2, annualProfit);


        } else if (type.equalsIgnoreCase("ShortTermAccount") && amount >= 50000) {
            return new ShortTermAccount(cardNumber, accountNumber, openingDate,
                    expiryDate, amount, cvv2, profit);
        }
        throw new AccountException("Enter correct type : ");
    }
}
