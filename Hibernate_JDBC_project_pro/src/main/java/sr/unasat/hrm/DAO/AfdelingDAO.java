package sr.unasat.hrm.DAO;


import jakarta.persistence.EntityManager;
import sr.unasat.hrm.config.JPAConfig;
import sr.unasat.hrm.DTO.AfdelingDTO;
import sr.unasat.hrm.entities.Afdeling;

import java.util.ArrayList;
import java.util.List;

public class AfdelingDAO {
    private final EntityManager entityManager;

    public AfdelingDAO() {
        this.entityManager = JPAConfig.getEntityManger();
    }

    public List<AfdelingDTO> getAllAfdelingen() {
        List<AfdelingDTO> afdelingDTOs = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            List<Afdeling> afdelingen = entityManager.createQuery("SELECT a FROM Afdeling a", Afdeling.class).getResultList();
            for (Afdeling afdeling : afdelingen) {
                afdelingDTOs.add(new AfdelingDTO(afdeling.getId(), afdeling.getNaam()));
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return afdelingDTOs;
    }

    public AfdelingDTO getAfdelingById(int id) {
        AfdelingDTO afdelingDTO = null;
        try {
            entityManager.getTransaction().begin();
            Afdeling afdeling = entityManager.find(Afdeling.class, id);
            if (afdeling != null) {
                afdelingDTO = new AfdelingDTO(afdeling.getId(), afdeling.getNaam());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return afdelingDTO;
    }

    public AfdelingDTO saveAfdeling(AfdelingDTO afdelingDTO) {
        try {
            entityManager.getTransaction().begin();
            Afdeling afdeling = new Afdeling(afdelingDTO.getNaam());
            entityManager.persist(afdeling);
            entityManager.getTransaction().commit();
            afdelingDTO.setId(afdeling.getId());
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return afdelingDTO;
    }

    public void updateAfdeling(AfdelingDTO afdelingDTO) {
        try {
            entityManager.getTransaction().begin();
            Afdeling afdeling = entityManager.find(Afdeling.class, afdelingDTO.getId());
            if (afdeling != null) {
                afdeling.setNaam(afdelingDTO.getNaam());
                entityManager.merge(afdeling);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteAfdeling(int id) {
        try {
            entityManager.getTransaction().begin();
            Afdeling afdeling = entityManager.find(Afdeling.class, id);
            if (afdeling != null) {
                entityManager.remove(afdeling);
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
