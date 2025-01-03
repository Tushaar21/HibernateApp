package sr.unasat.hrm.applicatie;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import sr.unasat.hrm.config.JPAConfig;
import sr.unasat.hrm.entities.Functie;
import sr.unasat.hrm.entities.Rol;
import sr.unasat.hrm.repositories.FunctieRepository;
import sr.unasat.hrm.repositories.RolRepository;

public class AppRepoTest {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = JPAConfig.getEntityMangerFactory();
        EntityManager entityManager = JPAConfig.getEntityManger();
        EntityTransaction transaction = entityManager.getTransaction();

        //------------------------------------perform database operation-----------------------------------//

//-------------------------------------------------Functie------------------------------------------------//

//begin transaction
//        entityManager.getTransaction().begin();
//        try {
//            // Perform database operation
//            FunctieRepository functieRepository = new FunctieRepository();
//            functieRepository.findAll();
//
//            Functie functieSave= new Functie();
//            functieSave.setNaam("Tester");
//            functieRepository.save(functieSave);
//
//            Functie functieUpdate = new Functie();
//            functieUpdate.setId(4);
//            functieUpdate.setNaam("Manager");
//            functieRepository.update(functieUpdate);
//
//            Functie functieDelete = new Functie();
//            functieDelete.setId(5);
//            functieRepository.delete(functieDelete);
//
//        } catch (Exception e) {
//            // Rollback transaction in case of error
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            // Close EntityManager
//            entityManager.close();
//        }

//-------------------------------------------------Werknemers------------------------------------------------//

//        try {
//            // Perform database operation
//            WerknemersRepository werknemersRepository = new WerknemersRepository();
//            werknemersRepository.findAll();

//            Werknemer werknemer = new Werknemer();
//            werknemer.setVoornaam("Okaru");
//            werknemer.setAchternaam("Kun");
//            werknemer.setTelefoon("12345678");
//
//            Functie functie = new Functie();
//            functie.setId(1);
//            functie.setNaam("Software Engineer");
//            werknemer.setFunctie(functie);





//        } catch (Exception e) {
//            // Rollback transaction in case of error
//            if (entityManager.getTransaction().isActive()) {
//                entityManager.getTransaction().rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            // Close EntityManager
//            entityManager.close();
//        }


//-----------------------------------------------------Afdeling-------------------------------------------------//

//        try {
//            // Perform database operation
//            AfdelingRepository afdelingRepository = new AfdelingRepository();
//            afdelingRepository.findAll();
//
//
//
//        } catch (Exception e) {
//            // Rollback transaction in case of error
//            if (entityManager.getTransaction().isActive()) {
//                entityManager.getTransaction().rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            // Close EntityManager
//            entityManager.close();
//        }

//-----------------------------------------------------WerknemerRol-------------------------------------------------//

//        try {
//            // Create an instance of RolRepository
//            RolRepository rolRepository = new RolRepository();
//
//            // Find all roles
//            rolRepository.findAll();
//
//            // Save a new role
//            Rol rolSave = new Rol();
//            rolSave.setNaam("Developer");
//            rolRepository.save(rolSave);
//
//            // Update an existing role
//            Rol rolUpdate = new Rol();
//            rolUpdate.setId(3); // Assuming role with ID 3 exists
//            rolUpdate.setNaam("Lead Developer");
//            rolRepository.update(rolUpdate);
//
//            // Delete a role
//            Rol rolDelete = new Rol();
//            rolDelete.setId(4); // Assuming role with ID 4 exists
//            rolRepository.delete(rolDelete);
//
//            // Commit transaction if all operations succeed
//            transaction.commit();
//        } catch (Exception e) {
//            // Rollback transaction in case of error
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            // Close EntityManager
//            entityManager.close();
//        }


    }
}
