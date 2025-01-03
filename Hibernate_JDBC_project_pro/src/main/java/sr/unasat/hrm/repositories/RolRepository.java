package sr.unasat.hrm.repositories;

import jakarta.persistence.EntityManager;
import sr.unasat.hrm.config.JPAConfig;
import sr.unasat.hrm.entities.Rol;
import sr.unasat.hrm.service.Operations;

import java.util.List;

public class RolRepository implements Operations<Rol> {

    EntityManager entityManager = JPAConfig.getEntityManger();

    @Override
    public void findAll() {
        List<Rol> rollen = entityManager.createQuery("SELECT r FROM Rol r", Rol.class).getResultList();

        if (rollen.isEmpty()) {
            System.out.println("NO DATA FOUND");
        } else {
            rollen.forEach(System.out::println);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void findById(int id) {
        Rol rol = entityManager.find(Rol.class, id);

        if (rol != null) {
            System.out.println(rol);
        } else {
            System.out.println("ID NOT FOUND");
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void save(Rol rol) {
        entityManager.getTransaction().begin();
        entityManager.persist(rol);
        entityManager.getTransaction().commit();
        System.out.println("Saved: " + rol);
    }

    @Override
    public void delete(Rol rol) {
        Rol managedRol = entityManager.find(Rol.class, rol.getId());
        if (managedRol != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(managedRol);
            entityManager.getTransaction().commit();
            System.out.println("Deleted: " + managedRol);
        } else {
            System.out.println("Rol not found for deletion: " + rol);
        }
    }

    @Override
    public void update(Rol rol) {
        Rol managedRol = entityManager.find(Rol.class, rol.getId());
        if (managedRol != null) {
            entityManager.getTransaction().begin();
            managedRol.setNaam(rol.getNaam());
            entityManager.merge(managedRol);
            entityManager.getTransaction().commit();
            System.out.println("Updated: " + managedRol);
        } else {
            System.out.println("Rol not found for update: " + rol);
        }
    }
}
