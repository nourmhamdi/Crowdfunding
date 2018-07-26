package funding.cofunding.services;

import javax.ejb.Local;

import funding.cofunding.entities.Projet;
import funding.cofunding.utilities.IGenericDAO;

@Local
public interface ProjectServicesLocal extends IGenericDAO<Projet>{
	

}
