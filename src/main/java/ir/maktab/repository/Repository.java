package ir.maktab.repository;

import ir.maktab.entity.Account;

public interface Repository<T extends Account> {
    void creat(T account);

    void update(int id, double credit);
}
