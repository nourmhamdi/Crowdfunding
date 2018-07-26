package funding.cofunding.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import funding.cofunding.entities.Projet;
import funding.cofunding.utilities.GenericDAO;

/**
 * Session Bean implementation class ProjectServices
 */
@Stateless 

public class ProjectServices extends GenericDAO<Projet> implements ProjectServicesLocal {

      public ProjectServices() {
        super(Projet.class);
    }

}
