package ir.maktab.service;

import ir.maktab.entity.Account;
import ir.maktab.exception.AccountException;

public interface Service <T extends Account>{
    void createNewAccount(T account) throws AccountException;

    void withdraw(T account, double amount);

    void deposit(T account, double amount);

}
