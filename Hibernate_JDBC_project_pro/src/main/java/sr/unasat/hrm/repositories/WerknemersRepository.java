package sr.unasat.hrm.repositories;


import jakarta.persistence.EntityManager;
import sr.unasat.hrm.config.JPAConfig;
import sr.unasat.hrm.entities.Werknemer;
import sr.unasat.hrm.service.Operations;

import java.util.List;

public class WerknemersRepository implements Operations<Werknemer> {

    private final EntityManager entityManager = JPAConfig.getEntityManger();

    @Override
    public void findAll () {
        // Query to fetch all Werknemer records
        List<Werknemer> werknemers = entityManager.createQuery("SELECT w FROM Werknemer w", Werknemer.class).getResultList();

        // Print results
        if (werknemers.isEmpty()) {
            System.out.println("NO DATA FOUND");
        } else {
            werknemers.forEach(System.out::println);
        }

        // Commit transaction
        entityManager.getTransaction().commit();

    }

    @Override
    public void findById ( int id){
        // Find Werknemer by ID
        Werknemer werknemer = entityManager.find(Werknemer.class, id);

        // Print result
        if (werknemer != null) {
            System.out.println(werknemer);
        } else {
            System.out.println("ID NOT FOUND");
        }

        // Commit transaction
        entityManager.getTransaction().commit();

    }

    @Override
    public void save (Werknemer werknemer){
        // Persist the Werknemer entity
        entityManager.persist(werknemer);

        // Commit transaction
        entityManager.getTransaction().commit();
        System.out.println("Saved: " + werknemer);

    }

    @Override
    public void delete (Werknemer werknemer){
        // Attach and delete the Werknemer entity
        sr.unasat.hrm.entities.Werknemer managedWerknemer = entityManager.find(sr.unasat.hrm.entities.Werknemer.class, werknemer.getId());
        if (managedWerknemer != null) {
            entityManager.remove(managedWerknemer);
            System.out.println("Deleted: " + managedWerknemer);
        } else {
            System.out.println("Werknemer not found for deletion: " + werknemer);
        }

        // Commit transaction
        entityManager.getTransaction().commit();

    }

    @Override
    public void update (Werknemer werknemer){
        // Update the Werknemer entity
        sr.unasat.hrm.entities.Werknemer managedWerknemer = entityManager.find(sr.unasat.hrm.entities.Werknemer.class, werknemer.getId());
        if (managedWerknemer != null) {
            managedWerknemer.setVoornaam(werknemer.getVoornaam());
            managedWerknemer.setAchternaam(werknemer.getAchternaam());
            managedWerknemer.setTelefoon(werknemer.getTelefoon());
            managedWerknemer.setFunctie(werknemer.getFunctie());
            managedWerknemer.setAfdeling(werknemer.getAfdeling());
            entityManager.merge(managedWerknemer);
            System.out.println("Updated: " + managedWerknemer);
        } else {
            System.out.println("Werknemer not found for update: " + werknemer);
        }

        // Commit transaction
        entityManager.getTransaction().commit();
    }

}
