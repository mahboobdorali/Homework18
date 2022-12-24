package ir.maktab.repository;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Config {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
}



