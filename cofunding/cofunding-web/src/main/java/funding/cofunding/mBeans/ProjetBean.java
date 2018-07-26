package funding.cofunding.mBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.print.PrintServiceLookup;

import funding.cofunding.entities.Projet;
import funding.cofunding.services.ProjectServicesLocal;

@ManagedBean
@ViewScoped
public class ProjetBean {

	private Projet projet;
	private List<Projet> projets;

	public ProjetBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	private void init() {
		projet = new Projet();
		projets = projectServicesLocal.findAll();

	}

	@EJB
	private ProjectServicesLocal projectServicesLocal;

	public void doAddProjet() {
		projectServicesLocal.update(projet);

	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}
	

}
