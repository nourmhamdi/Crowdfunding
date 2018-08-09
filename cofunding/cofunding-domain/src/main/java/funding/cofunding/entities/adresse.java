package funding.cofunding.entities;

import javax.persistence.Embeddable;

@Embeddable
public class adresse {
			private String adress ;
		
		private String country ;
	
		
		private String ZIPcode ; 
	public adresse() {
		// TODO Auto-generated constructor stub
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZIPcode() {
		return ZIPcode;
	}
	public void setZIPcode(String zIPcode) {
		ZIPcode = zIPcode;
	}
	public adresse(String adress, String country, String zIPcode) {
		super();
		this.adress = adress;
		this.country = country;
		ZIPcode = zIPcode;
	}

}
