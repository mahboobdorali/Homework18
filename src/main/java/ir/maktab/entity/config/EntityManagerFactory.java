package ir.maktab.entity.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EntityManagerFactory {
    private static final EntityManagerFactory instance = new EntityManagerFactory();

    private EntityManagerFactory() {
    }

    public static EntityManagerFactory getInstance() {
        return instance;
    }

    public SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        return configuration.buildSessionFactory();

    }
}




