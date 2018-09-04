package funding.cofunding.mBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import funding.cofunding.entities.User;
import funding.cofunding.services.UserServiceLocal;

@ManagedBean
@ViewScoped
public class UserBean {
	private User user;
	private List<User> users;

	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	private void init() {
		user = new User();
		users = UserServiceLocal.findAll();	

	}
	@EJB
	private UserServiceLocal UserServiceLocal;

	public void doAddUser() {
		UserServiceLocal.update(user);

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	

	

	
}
   