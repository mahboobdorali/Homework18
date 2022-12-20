package ir.maktab.service.serviceImpl;

import ir.maktab.entity.Account;
import ir.maktab.entity.CurrentAccount;
import ir.maktab.entity.LongTermAccount;
import ir.maktab.entity.ShortTermAccount;
import ir.maktab.exception.AccountException;
import ir.maktab.repository.Repository;
import ir.maktab.repository.repositoryImpl.RepositoryImpl;
import ir.maktab.service.Service;
import ir.maktab.validation.AccountValidation;

public class ServiceImpl<T extends Account> implements Service<T> {
    Repository<T> accountRepository = new RepositoryImpl<>();

    @Override
    public void createNewAccount(T account) throws AccountException {
        AccountValidation.validCardNumber(account.getCardNumber());
        accountRepository.creat(account);
    }

    @Override
    public void withdraw(T account, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("مقدار منفی نمیتوانیدبرداشت کنید");
        }
        if (amount > account.getAmount()) {
            throw new RuntimeException("موجودی کافی نیست");
        }
        account.setAmount(account.getAmount() - amount);
        accountRepository.update(account.getId(), account.getAmount());
    }

    @Override
    public void deposit(T account, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Sorry, you can not deposit a negative amount");
        }
        account.setAmount(account.getAmount() + amount);
        accountRepository.update(account.getId(), account.getAmount());
    }

    public static Account getAccount(String type) {
        if (type == null) {
            return null;
        } else if (type.equalsIgnoreCase("CurrentAccount")) {
            return new CurrentAccount();
        } else if (type.equalsIgnoreCase("LongTermAccount")) {
            return new LongTermAccount();
        } else if (type.equalsIgnoreCase("ShortTermAccount")) {
            return new ShortTermAccount();
        }
        return null;

    }
}
