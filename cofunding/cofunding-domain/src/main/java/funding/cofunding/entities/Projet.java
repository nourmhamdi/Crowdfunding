package funding.cofunding.entities;
import java.io.File;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity 
public class Projet {
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private	int id;
	@Column(name="name")
	private	String name;
	@Column(name="description")
	private	String description ;
	@Column(name="image")
	private String image ;
	@Column(name="fichier")
	private File fichier ;
	@Column(name="montant_a_collecte")
	private Double montant_a_collecte;
	@Column(name="Categorie")
	private String Categorie ;
	@Column(name="sommeCollecte")
	private Double sommeCollecte ;
	@Column(name="DateDeCreation ")
	private Date DateDeCreation  ;
	@ManyToOne
	private User user;
	 
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Projet(String name, String description, String image, File fichier, Double montant_a_collecte,
			String categorie, Double sommeCollecte, Date dateDeCreation) {
		super();
		this.name = name;
		this.description = description;
		this.image = image;
		this.fichier = fichier;
		this.montant_a_collecte = montant_a_collecte;
		Categorie = categorie;
		this.sommeCollecte = sommeCollecte;
		DateDeCreation = dateDeCreation;
	}


	public Date getDateDeCreation() {
		return DateDeCreation;
	}


	public void setDateDeCreation(Date dateDeCreation) {
		DateDeCreation = dateDeCreation;
	}


	public String getCategorie() {
		return Categorie;
	}


	public Double getSommeCollecte() {
		return sommeCollecte;
	}


	public void setSommeCollecte(Double sommeCollecte) {
		this.sommeCollecte = sommeCollecte;
	}


	public void setCategorie(String categorie) {
		Categorie = categorie;
	}


	public File getFichier() {
		return fichier;
	}


	public void setFichier(File fichier) {
		this.fichier = fichier;
	}


	public Projet() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}


	
	public void setImage(String image) {
		this.image = image;
	}

	public Double getMontant_a_collecte() {
		return montant_a_collecte;
	}

	public void setMontant_a_collecte(Double montant_a_collecte) {
		this.montant_a_collecte = montant_a_collecte;
	}

}
