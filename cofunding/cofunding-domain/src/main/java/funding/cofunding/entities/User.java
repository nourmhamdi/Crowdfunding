package funding.cofunding.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity 
@Table(name="User")
public class User  {
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int idUser;
	@NotNull(message="please enter your name!")
	@Column(name="name")
	private String name;
	@NotNull(message="please enter your last name ")
	@Column(name="Lastname")
	private String Lastname;
	@Column(name="mail")
	private String mail;
	@NotNull(message="please enter your login")
	@Column(name="login")
	private String login;
	@NotNull(message="please enter your password")
	@Column(name="password")
	private String password;
	@Column(name="adresse")
	private String adresse;
	@Column(name="ZipCode")
	private String ZipCode;
	@Column(name="Country")
	private String Country;
	
	@OneToMany(mappedBy="user")
	private List<Projet> projets;
	


	public User(String name, String lastname, String mail) {
		super();
		this.name = name;
		this.Lastname = lastname;
		this.mail = mail;
	}
	

	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
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

	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getZipCode() {
		return ZipCode;
	}


	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}


	public String getCountry() {
		return Country;
	}


	public void setCountry(String country) {
		Country = country;
	}


	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", Lastname=" + Lastname + ", mail=" + mail + ", login="
				+ login + ", password=" + password + ", adresse=" + adresse+ ", projets=" + projets + "]";
	}

	
}
