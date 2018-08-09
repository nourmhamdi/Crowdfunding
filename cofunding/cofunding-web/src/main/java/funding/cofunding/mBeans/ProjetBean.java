package funding.cofunding.mBeans;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.StreamedContent;

import funding.cofunding.entities.Projet;
import funding.cofunding.services.ProjectServicesLocal;

@ManagedBean
@ViewScoped
public class ProjetBean {
	private StreamedContent file;
	private Projet projet;
	private List<Projet> projets;
	
	 private Part uploadedFile;

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

	public void addproj() throws IOException {

		InputStream input = uploadedFile.getInputStream();
		byte[] bytes = IOUtils.toByteArray(input);
		projet.setPicture(bytes);
		projectServicesLocal.save(projet);

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

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

}
