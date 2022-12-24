package ir.maktab.repository;

import ir.maktab.entity.Account;

import javax.persistence.EntityManager;

public class AccountRepo extends AccountRepository<Account>{
  /*  private static  AccountRepo instance = new  AccountRepo();

    private  AccountRepo() {
    }
    public static  AccountRepo getInstance() {
        return instance;
    }*/
    @Override
    public void create(Account account) {
        EntityManager entityManager = Config.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

