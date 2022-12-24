package ir.maktab.repository;

import ir.maktab.entity.Person;
import ir.maktab.service.PersonService;

import javax.persistence.EntityManager;

public class PersonRepository extends AccountRepository<Person>{
    /*private static PersonRepository instance = new PersonRepository();

    private PersonRepository() {
    }
    public static PersonRepository getInstance() {
        return instance;
    }*/
    @Override
    public void create(Person person) {
        EntityManager entityManager = Config.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
