package ir.maktab.repository.repositoryImpl;

import ir.maktab.entity.Account;
import ir.maktab.entity.config.EntityManagerFactory;
import ir.maktab.repository.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class RepositoryImpl<T extends Account> implements Repository<T> {
    private static RepositoryImpl instance = new RepositoryImpl();

    public RepositoryImpl() {
    }
    public static RepositoryImpl getInstance() {
        return instance;
    }

    public static SessionFactory sessionFactory = EntityManagerFactory.getInstance().getSessionFactory();


    @Override
    public void creat(T account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(int id, double credit) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T account = (T) session.get(Account.class, id);
        account.setAmount(credit);
        session.update(account);
        transaction.commit();
        session.close();
    }
}
