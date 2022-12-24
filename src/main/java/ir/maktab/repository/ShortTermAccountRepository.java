package ir.maktab.repository;

import ir.maktab.entity.ShortTermAccount;

import javax.persistence.EntityManager;

public class ShortTermAccountRepository extends AccountRepository<ShortTermAccount>{
   /* private static ShortTermAccountRepository instance = new ShortTermAccountRepository();

    private ShortTermAccountRepository() {
    }
    public static ShortTermAccountRepository getInstance() {
        return instance;
    }*/
    @Override
    public void create(ShortTermAccount shortTermAccount) {
        EntityManager entityManager = Config.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(shortTermAccount);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
