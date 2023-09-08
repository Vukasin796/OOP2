package modeli;

public class OdgovornaOsoba {
	private String ime;
	private String prezime;
	private double visinaPlate;
	private String zvanje;
	private String stepenObrazovanja;
	
	public OdgovornaOsoba(String ime, String prezime, double visinaPlate, String zvanje, String stepenObrazovanja) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.visinaPlate = visinaPlate;
		this.zvanje = zvanje;
		this.stepenObrazovanja = stepenObrazovanja;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public double getVisinaPlate() {
		return visinaPlate;
	}

	public void setVisinaPlate(double visinaPlate) {
		this.visinaPlate = visinaPlate;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public String getStepenObrazovanja() {
		return stepenObrazovanja;
	}

	public void setStepenObrazovanja(String stepenObrazovanja) {
		this.stepenObrazovanja = stepenObrazovanja;
	}
	
	
	
	
	

}

