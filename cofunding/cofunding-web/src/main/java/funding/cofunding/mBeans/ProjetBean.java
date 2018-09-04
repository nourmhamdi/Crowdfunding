package funding.cofunding.mBeans;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import funding.cofunding.entities.Projet;
import funding.cofunding.services.ProjectServicesLocal;

@ManagedBean
@ViewScoped
public class ProjetBean {
	private Projet projet;
	private List<Projet> projets;
	private Part  file;
	private Part file1;
   // private Part file2;
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
	
	
	
	public Part getFile1() {
		return file1;
	}

	public void setFile1(Part file1) {
		this.file1 = file1;
	}
	 

	public void listAllProjects() {
		projets.clear();
		projets.addAll(projectServicesLocal.findAll());
	}
	
	
	
	
	
	
	
//	public String upload() {
//		return "success";
//	}
	

	
 
    // getters and setters for file1 and file2
 
    public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public void upload() throws IOException {
         InputStream inputStream = file1.getInputStream();        
        FileOutputStream outputStream = new FileOutputStream(getFilename(file1));
         
        byte[] buffer = new byte[4096];        
        int bytesRead = 0;
        while(true) {                        
            bytesRead = inputStream.read(buffer);
            if(bytesRead > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }else {
                break;
            }                       
        }
        outputStream.close();
        inputStream.close();
        
        
    }
 
    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
    
}

