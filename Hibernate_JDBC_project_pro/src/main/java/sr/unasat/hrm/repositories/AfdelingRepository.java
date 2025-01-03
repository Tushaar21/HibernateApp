package sr.unasat.hrm.repositories;


import jakarta.persistence.EntityManager;
import sr.unasat.hrm.config.JPAConfig;
import sr.unasat.hrm.entities.Afdeling;
import sr.unasat.hrm.service.Operations;

import java.util.List;

public class AfdelingRepository implements Operations<Afdeling> {

    EntityManager entityManager = JPAConfig.getEntityManger();


    @Override
    public void save(Afdeling afdeling) {
        entityManager.persist(afdeling);

        entityManager.getTransaction().commit();
        System.out.println("Saved: " + afdeling);
    }

    @Override
    public void findAll() {
        List<Afdeling> afdelings = entityManager.createQuery("SELECT a FROM Afdeling a", Afdeling.class).getResultList();

        if (afdelings.isEmpty()){
            System.out.println("No afdelings found");
        } else {
            afdelings.forEach(System.out::println);
        }

        entityManager.getTransaction().commit();
    }

    @Override
    public void findById(int id) {

        Afdeling afdeling = entityManager.find(Afdeling.class, id);

        if (afdeling != null){
            System.out.println(afdeling);
        } else {
            System.out.println("No afdeling found");
        }

        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Afdeling afdeling) {

        Afdeling updateAfdeling = entityManager.find(Afdeling.class, afdeling.getId());
        if (updateAfdeling != null){
            updateAfdeling.setNaam(afdeling.getNaam());
            entityManager.merge(updateAfdeling);
            System.out.println("Updated: " + updateAfdeling);
        } else {
            System.out.println("Afdeling not found for update " + afdeling);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Afdeling entity) {

        Afdeling deleteAfdeling = entityManager.find(Afdeling.class, entity.getId());
        if (deleteAfdeling != null){
            entityManager.remove(deleteAfdeling);
            System.out.println("Deleted: " + deleteAfdeling);
        } else {
            System.out.println("Afdeling not found for delete " + entity);
        }

        entityManager.getTransaction().commit();
    }
}
