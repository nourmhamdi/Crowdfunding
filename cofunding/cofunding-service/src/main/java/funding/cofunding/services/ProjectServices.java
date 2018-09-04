package funding.cofunding.services;

import java.sql.Blob;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import funding.cofunding.entities.Projet;
import funding.cofunding.utilities.GenericDAO;

/**
 * Session Bean implementation class ProjectServices
 */
@Stateless 

public class ProjectServices extends GenericDAO<Projet> implements ProjectServicesLocal {

	 private EntityManager em;
      public ProjectServices() {
        super(Projet.class);
    }
      public byte[] loadImage(int id){
          return em.find(Projet.class, id).getPicture();      


      }
      public byte[] loadFile(int id) {
    	  return em.find(Projet.class, id).getFichier();
      }
}
