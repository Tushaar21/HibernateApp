package sr.unasat.hrm.DAO;

import jakarta.persistence.EntityManager;
import sr.unasat.hrm.DTO.WerknemerRolDTO;
import sr.unasat.hrm.config.JPAConfig;
import sr.unasat.hrm.entities.Rol;

import java.util.ArrayList;
import java.util.List;

public class WerknemerRolDAO {
    private final EntityManager entityManager;


    public WerknemerRolDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<WerknemerRolDTO> getAllRollen() {
        List<WerknemerRolDTO> rolDTOs = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            List<Rol> rollen = entityManager.createQuery("SELECT r FROM Rol r", Rol.class).getResultList();
            for (Rol rol : rollen) {
                rolDTOs.add(new WerknemerRolDTO(rol.getId(), rol.getNaam()));
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return rolDTOs;
    }

    public WerknemerRolDTO getRolById(int id) {
        WerknemerRolDTO rolDTO = null;
        try {
            entityManager.getTransaction().begin();
            Rol rol = entityManager.find(Rol.class, id);
            if (rol != null) {
                rolDTO = new WerknemerRolDTO(rol.getId(), rol.getNaam());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return rolDTO;
    }

    public WerknemerRolDTO saveRol(WerknemerRolDTO rolDTO) {
        try {
            entityManager.getTransaction().begin();
            Rol rol = new Rol();
            rol.setNaam(rolDTO.getNaam());
            entityManager.persist(rol);
            entityManager.getTransaction().commit();
            rolDTO.setId(rol.getId());
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return rolDTO;
    }

    public void updateRol(WerknemerRolDTO rolDTO) {
        try {
            entityManager.getTransaction().begin();
            Rol rol = entityManager.find(Rol.class, rolDTO.getId());
            if (rol != null) {
                rol.setNaam(rolDTO.getNaam());
                entityManager.merge(rol);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteRol(int id) {
        try {
            entityManager.getTransaction().begin();
            Rol rol = entityManager.find(Rol.class, id);
            if (rol != null) {
                entityManager.remove(rol);
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
