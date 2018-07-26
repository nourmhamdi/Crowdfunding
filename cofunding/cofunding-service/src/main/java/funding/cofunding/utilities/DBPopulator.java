package funding.cofunding.utilities;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import funding.cofunding.entities.User;
import funding.cofunding.services.UserServiceLocal;

@Singleton
@Startup
public class DBPopulator {
	@EJB
	private UserServiceLocal userServiceLocal;

	public DBPopulator() {
	}

	@PostConstruct
	public void init() {
		//User user = new User("user", "u", "u", "user@bitbox.tn");

		//userServiceLocal.update(user);
	}
}
