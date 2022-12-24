package ir.maktab.repository;

import ir.maktab.entity.LongTermAccount;

import javax.persistence.EntityManager;

public class LongTermAccountRepository extends AccountRepository<LongTermAccount>{
  /*  private static LongTermAccountRepository instance = new LongTermAccountRepository();

    private LongTermAccountRepository() {
    }
    public static LongTermAccountRepository getInstance() {
        return instance;
    }*/
    @Override
    public void create(LongTermAccount longTermAccount) {
        EntityManager entityManager = Config.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(longTermAccount);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
