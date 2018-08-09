package funding.cofunding.mBeans;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import funding.cofunding.entities.User;

@RequestScoped
public abstract class AbstractBacking {

    @ManagedProperty(value="#{facesContext}")
    private FacesContext facesContext;

    @ManagedProperty(value="#{requestScope}")
    private Map<String, Object> requestMap;

    @ManagedProperty(value="#{sessionScope}")
    private Map<String, Object> sessionMap;

    public User getCurrentUser() {
        return (User) getSessionMap().get("currentUser");
    }

    public void setCurrentUser(User currentUser) {
        getSessionMap().remove("currentUser");
        if (null != currentUser) {
            getSessionMap().put("currentUser", currentUser);
        }
    }

    public boolean isUserLoggedIn() {
        return getSessionMap().containsKey("currentUser");
    }

    // The compiler can optimizes calls such as this into plain field accesses.
    // Therefore, there is no performance penalty for always using the
    // accessor.
    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext context) {
        this.facesContext = context;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public Map<String, Object> getRequestMap() {
        return requestMap;
    }

    public void setRequestMap(Map<String, Object> requestMap) {
        this.requestMap = requestMap;
    }

    public Flash getFlash() {
        return getFacesContext().getExternalContext().getFlash();
    }

}