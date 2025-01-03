package sr.unasat.hrm.DAO;

import jakarta.persistence.EntityManager;
import sr.unasat.hrm.config.JPAConfig;
import sr.unasat.hrm.DTO.FunctieDTO;
import sr.unasat.hrm.entities.Functie;

import java.util.ArrayList;
import java.util.List;

public class FunctieDAO {
    private final EntityManager entityManager;

    public FunctieDAO() {
        this.entityManager = JPAConfig.getEntityManger();
    }

    public List<FunctieDTO> getAllFuncties() {
        List<FunctieDTO> functieDTOs = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            List<Functie> functies = entityManager.createQuery("SELECT f FROM Functie f", Functie.class).getResultList();
            for (Functie functie : functies) {
                functieDTOs.add(new FunctieDTO(functie.getId(), functie.getNaam()));
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return functieDTOs;
    }

    public FunctieDTO getFunctieById(int id) {
        FunctieDTO functieDTO = null;
        try {
            entityManager.getTransaction().begin();
            Functie functie = entityManager.find(Functie.class, id);
            if (functie != null) {
                functieDTO = new FunctieDTO(functie.getId(), functie.getNaam());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return functieDTO;
    }

    public FunctieDTO saveFunctie(FunctieDTO functieDTO) {
        try {
            entityManager.getTransaction().begin();
            Functie functie = new Functie(functieDTO.getNaam());
            entityManager.persist(functie);
            entityManager.getTransaction().commit();
            functieDTO.setId(functie.getId());
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return functieDTO;
    }

    public void updateFunctie(FunctieDTO functieDTO) {
        try {
            entityManager.getTransaction().begin();
            Functie functie = entityManager.find(Functie.class, functieDTO.getId());
            if (functie != null) {
                functie.setNaam(functieDTO.getNaam());
                entityManager.merge(functie);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteFunctie(int id) {
        try {
            entityManager.getTransaction().begin();
            Functie functie = entityManager.find(Functie.class, id);
            if (functie != null) {
                entityManager.remove(functie);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }
}
