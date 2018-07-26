package funding.cofunding.services;

import javax.ejb.Local;

import funding.cofunding.entities.User;
import funding.cofunding.utilities.IGenericDAO;

@Local
public interface UserServiceLocal extends IGenericDAO<User> {

	User login(String login, String password);

}
