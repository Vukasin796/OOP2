package modeli;

public class TehnickiProizvod extends Proizvod {
	private double nominalnaSnaga;
	private double radniNapon;
	private String dimenzije;
	
	public TehnickiProizvod(String ime, String prezime, double visinaPlate, String zvanje, String stepenObrazovanja,
			String naziv, double cena, String kategorija, String jedinicaMere, String proizvodjac, double nominalnaSnaga, double radniNapon, String dimenzije) {
		super(ime, prezime, visinaPlate, zvanje, stepenObrazovanja, naziv, cena, kategorija, jedinicaMere, proizvodjac);
		this.nominalnaSnaga = nominalnaSnaga;
		this.radniNapon = radniNapon;
		this.dimenzije = dimenzije;
	}

	public double getNominalnaSnaga() {
		return nominalnaSnaga;
	}

	public void setNominalnaSnaga(double nominalnaSnaga) {
		this.nominalnaSnaga = nominalnaSnaga;
	}

	public double getRadniNapon() {
		return radniNapon;
	}

	public void setRadniNapon(double radniNapon) {
		this.radniNapon = radniNapon;
	}

	public String getDimenzije() {
		return dimenzije;
	}

	public void setDimenzije(String dimenzije) {
		this.dimenzije = dimenzije;
	}
	
	
	

}
