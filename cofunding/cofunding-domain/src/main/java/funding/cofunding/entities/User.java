package funding.cofunding.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity 
@Table(name="User")
public class User  {
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int idUser;
	@Column(name="name")
	private String name;
	@Column(name="Lastname")
	private String Lastname;
	@Column(name="mail")
	private String mail;
	@Column(name="adresse")
	@Embedded //composant 
	private adresse adresse;
	@OneToMany(mappedBy="user")
	private List<Projet> projets;
	

	public User(String name, String lastname, String mail) {
		super();
		this.name = name;
		Lastname = lastname;
		this.mail = mail;
	}
	

	public List<Projet> getProjets() {
		return projets;
	}


	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}


	public User() {
		super();
	}


	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	public adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(adresse adresse) {
	this.adresse = adresse;
	}
	

}
