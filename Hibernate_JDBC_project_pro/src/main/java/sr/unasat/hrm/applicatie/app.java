package sr.unasat.hrm.applicatie;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import sr.unasat.hrm.DAO.AfdelingDAO;
import sr.unasat.hrm.DAO.FunctieDAO;
import sr.unasat.hrm.DTO.AfdelingDTO;
import sr.unasat.hrm.DTO.FunctieDTO;
import sr.unasat.hrm.config.JPAConfig;
import sr.unasat.hrm.entities.Afdeling;
import sr.unasat.hrm.entities.Functie;
import sr.unasat.hrm.entities.Werknemer;
import sr.unasat.hrm.entities.WerknemerRol;
import sr.unasat.hrm.repositories.AfdelingRepository;
import sr.unasat.hrm.repositories.FunctieRepository;
import sr.unasat.hrm.repositories.WerknemersRepository;


import java.sql.SQLException;
import java.util.List;

public class app {

    public static void main(String[] args) throws SQLException {

        EntityManagerFactory entityManagerFactory = JPAConfig.getEntityMangerFactory();
        EntityManager entityManager = JPAConfig.getEntityManger();
        EntityTransaction transaction = entityManager.getTransaction();


//-----------------------------------------------------test DAO--------------------------------------------//

//        // Instantiate the DAO
//        FunctieDAO functieDAO = new FunctieDAO();
//
//        // Example 1: Save a new Functie
//        System.out.println("Saving new functie...");
//        FunctieDTO functieSave= new FunctieDTO();
//        functieSave.setNaam("Developer");
//        FunctieDTO savedFunctie = functieDAO.saveFunctie(functieSave);
//        System.out.println("Saved Functie: " + savedFunctie);
//
//        // Example 2: Get all Functies
//        System.out.println("\nFetching all functies...");
//        List<FunctieDTO> allFuncties = functieDAO.getAllFuncties();
//        for (FunctieDTO functie : allFuncties) {
//            System.out.println(functie);
//        }
//
//        // Example 3: Get a Functie by ID
//        System.out.println("\nFetching functie by ID...");
//        int idToFetch = savedFunctie.getId(); // Use the ID of the saved functie
//        FunctieDTO fetchedFunctie = functieDAO.getFunctieById(idToFetch);
//        if (fetchedFunctie != null) {
//            System.out.println("Fetched Functie: " + fetchedFunctie);
//        } else {
//            System.out.println("Functie not found.");
//        }
//
//        // Example 4: Update a Functie
//        System.out.println("\nUpdating functie...");
//        if (fetchedFunctie != null) {
//            fetchedFunctie.setNaam("Senior Developer");
//            functieDAO.updateFunctie(fetchedFunctie);
//            System.out.println("Updated Functie: " + functieDAO.getFunctieById(fetchedFunctie.getId()));
//        }
//
//        // Example 5: Delete a Functie
//        System.out.println("\nDeleting functie...");
//        if (fetchedFunctie != null) {
//            functieDAO.deleteFunctie(fetchedFunctie.getId());
//            System.out.println("Deleted Functie with ID: " + fetchedFunctie.getId());
//        }


//-----------------------------------------------------Afdeling-------------------------------------------------//
        AfdelingDAO afdelingDAO = new AfdelingDAO();
//
//        // Example 1: Save a new Functie
//        System.out.println("Saving new afdeling...");
//        AfdelingDTO afdelingSave = new AfdelingDTO();
//        afdelingSave.setNaam("Developer");
//        AfdelingDTO savedAfdeling = afdelingDAO.saveAfdeling(afdelingSave);
//        System.out.println("Saved Functie: " + savedAfdeling);
//
//        // Example 2: Get all Functies
        System.out.println("\nFetching all afdelingen...");
        List<AfdelingDTO> allAfdelingen = afdelingDAO.getAllAfdelingen();
        for (AfdelingDTO afdeling : allAfdelingen) {
            System.out.println(afdeling);
        }

//        // Example 3: Get a Functie by ID
//        System.out.println("\nFetching afdeling by ID...");
//        int idToFetch = savedAfdeling.getId(); // Use the ID of the saved afdeling
//        AfdelingDTO fetchedAfdeling = afdelingDAO.getAfdelingById(idToFetch);
//        if (fetchedAfdeling != null) {
//            System.out.println("Fetched Afdeling: " + fetchedAfdeling);
//        } else {
//            System.out.println("Afdeling not found.");
//        }
//
//        // Example 4: Update a Functie
//        System.out.println("\nUpdating afdeling...");
//        if (fetchedAfdeling != null) {
//            fetchedAfdeling.setNaam("Senior Developer");
//            afdelingDAO.updateAfdeling(fetchedAfdeling);
//            System.out.println("Updated Afdeling: " + afdelingDAO.getAfdelingById(fetchedAfdeling.getId()));
//        }
//
//        // Example 5: Delete a Functie
//        System.out.println("\nDeleting functie...");
//        if (fetchedAfdeling != null) {
//            afdelingDAO.deleteAfdeling(fetchedAfdeling.getId());
//            System.out.println("Deleted Afdeling with ID: " + fetchedAfdeling.getId());
//        }



    }
}
