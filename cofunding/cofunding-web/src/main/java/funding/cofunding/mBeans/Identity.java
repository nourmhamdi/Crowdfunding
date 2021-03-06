package funding.cofunding.mBeans;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import funding.cofunding.entities.User;
import funding.cofunding.services.UserServiceLocal;

@ManagedBean
@SessionScoped
public class Identity {
	private boolean isLogged = false;
	protected static User user  = new User(null,null); 
	


	@EJB
	private UserServiceLocal userServiceLocal;

	public String logout() {
		isLogged = false;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = userServiceLocal.login(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			isLogged = true;
			user = userLoggedIn;
			navigateTo = "/home?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Login Failed! The username and/or password was incorrect. Please try again. ", ""));
		return "helloBootstrap/?faces-redirect=true";

		}
		return navigateTo;

}

	public User getUser() {
	return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public Boolean getIsLogged() {
		return isLogged;
	}

	public void setIsLogged(Boolean isLogged) {
		this.isLogged = isLogged;
	}

}
