package modeli;

import java.time.LocalDate;

public class KvarljiviProizvod extends Proizvod{
	private LocalDate rokTrajanja;
	private String uputstvoZaSkladistenje;
	
	public KvarljiviProizvod(String ime, String prezime, double visinaPlate, String zvanje, String stepenObrazovanja,
			String naziv, double cena, String kategorija, String jedinicaMere, String proizvodjac, LocalDate rokTrajanja, String uputstvoZaSkladistenje) {
		super(ime, prezime, visinaPlate, zvanje, stepenObrazovanja, naziv, cena, kategorija, jedinicaMere, proizvodjac);
		this.rokTrajanja = rokTrajanja;
		this.uputstvoZaSkladistenje = uputstvoZaSkladistenje;
	}

	public LocalDate getRokTrajanja() {
		return rokTrajanja;
	}

	public void setRokTrajanja(LocalDate rokTrajanja) {
		this.rokTrajanja = rokTrajanja;
	}

	public String getUputstvoZaSkladistenje() {
		return uputstvoZaSkladistenje;
	}

	public void setUputstvoZaSkladistenje(String uputstvoZaSkladistenje) {
		this.uputstvoZaSkladistenje = uputstvoZaSkladistenje;
	}
	
	
	
	

}
