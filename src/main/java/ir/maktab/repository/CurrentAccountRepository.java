package ir.maktab.repository;

import ir.maktab.entity.CurrentAccount;

import javax.persistence.EntityManager;

public class CurrentAccountRepository extends AccountRepository<CurrentAccount>{
  /*  private static CurrentAccountRepository instance = new CurrentAccountRepository();

    private CurrentAccountRepository() {
    }
    public static CurrentAccountRepository getInstance() {
        return instance;
    }*/

    @Override
    public void create(CurrentAccount currentAccount) {
        EntityManager entityManager = Config.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(currentAccount);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
