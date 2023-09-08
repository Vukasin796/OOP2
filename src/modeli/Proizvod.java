package modeli;

public class Proizvod extends OdgovornaOsoba{
	private String naziv;
	private double cena;
	private String kategorija;
	private String jedinicaMere;
	private String proizvodjac;
	
	public Proizvod(String ime, String prezime, double visinaPlate, String zvanje, String stepenObrazovanja, String naziv, double cena, String kategorija, String jedinicaMere, String proizvodjac) {
		super(ime, prezime, visinaPlate, zvanje, stepenObrazovanja);
		this.naziv = naziv;
		this.cena = cena;
		this.kategorija = kategorija;
		this.jedinicaMere = jedinicaMere;
		this.proizvodjac = proizvodjac;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getKategorija() {
		return kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}

	public String getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
	
	
	
	

}
