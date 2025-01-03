package sr.unasat.hrm.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JPAConfig {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static EntityManagerFactory getEntityMangerFactory(){
        if (entityManagerFactory == null ) {
            entityManagerFactory = Persistence.createEntityManagerFactory("HibernatePU");
        }
        return entityManagerFactory;
    }

    public static EntityManager getEntityManger(){
        if (entityManager == null ) {
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

}
