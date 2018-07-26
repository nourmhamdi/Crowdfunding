package funding.cofunding.entities;



public class adresse {
			private String adresse ;
		
		private String country ;
	
		
		private String ZIPcode ; 
	public adresse() {
		// TODO Auto-generated constructor stub
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	public adresse(String adresse, String country, String zIPcode) {
		super();
		this.adresse = adresse;
		this.country = country;
		ZIPcode = zIPcode;
	}

}
