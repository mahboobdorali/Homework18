package ir.maktab.service;

import ir.maktab.entity.Account;
import ir.maktab.exception.AccountException;

import java.util.Date;

public interface Service {
    void create(Account account)  throws AccountException;
    Account getAccount(String cardNumber, String accountNumber,
                       Date openingDate, Date expiryDate, double amount, int cvv2,String type) throws AccountException;
}
