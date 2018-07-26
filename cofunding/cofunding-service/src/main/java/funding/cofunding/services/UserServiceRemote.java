package funding.cofunding.services;

import javax.ejb.Remote;

import funding.cofunding.entities.User;
import funding.cofunding.utilities.IGenericDAO;

@Remote
public interface UserServiceRemote extends IGenericDAO<User> {

}
