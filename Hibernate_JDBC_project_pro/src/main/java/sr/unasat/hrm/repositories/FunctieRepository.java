package sr.unasat.hrm.repositories;



import jakarta.persistence.EntityManager;
import sr.unasat.hrm.config.JPAConfig;
import sr.unasat.hrm.entities.Functie;
import sr.unasat.hrm.service.Operations;

import java.util.List;

public class FunctieRepository implements Operations<Functie> {

    EntityManager entityManager = JPAConfig.getEntityManger();

    @Override
    public void findAll() {
            // Perform database operation
            List<Functie> functies = entityManager.createQuery("SELECT f FROM Functie f", Functie.class).getResultList();

            if (functies.isEmpty()){
                System.out.println("NO DATA FOUND");
            }else {
                functies.forEach(System.out::println);
            }

            // Commit transaction
            entityManager.getTransaction().commit();
    }

    @Override
    public void findById(int id) {
        // Find entity
        Functie functie = entityManager.find(Functie.class, id);

        // Print result
        if (functie != null) {
            System.out.println(functie);
        } else {
            System.out.println("ID NOT FOUND");
        }
        // Commit transaction
        entityManager.getTransaction().commit();
    }

    @Override
    public void save(Functie functie) {
        // Save entity
        entityManager.persist(functie);

        // Commit transaction
        entityManager.getTransaction().commit();
        System.out.println("Saved: " + functie);

    }

    @Override
    public void delete(Functie functie) {
        // Attach entity to context and delete
        Functie managedFunctie = entityManager.find(Functie.class, functie.getId());
        if (managedFunctie != null) {
            entityManager.remove(managedFunctie);
            System.out.println("Deleted: " + managedFunctie);
        } else {
            System.out.println("Functie not found for deletion: " + functie);
        }
        // Commit transaction
        entityManager.getTransaction().commit();
    }
    @Override
    public void update(Functie functie) {
        // Update entity
        Functie managedFunctie = entityManager.find(Functie.class, functie.getId());
        if (managedFunctie != null) {
            managedFunctie.setNaam(functie.getNaam());
            entityManager.merge(managedFunctie);
            System.out.println("Updated: " + managedFunctie);
        } else {
            System.out.println("Functie not found for update: " + functie);
        }
        // Commit transaction
        entityManager.getTransaction().commit();
    }


}
