package modeli;

public class Prodavac extends OdgovornaOsoba {
	private String radnoMesto;
	private String primedbe;
	
	public Prodavac(String ime, String prezime, double visinaPlate, String zvanje, String stepenObrazovanja, String radnoMesto, String primedbe) {
		super(ime, prezime, visinaPlate, zvanje, stepenObrazovanja);
		this.primedbe = primedbe;
		this.radnoMesto = radnoMesto;
	}

	public String getRadnoMesto() {
		return radnoMesto;
	}

	public void setRadnoMesto(String radnoMesto) {
		this.radnoMesto = radnoMesto;
	}

	public String getPrimedbe() {
		return primedbe;
	}

	public void setPrimedbe(String primedbe) {
		this.primedbe = primedbe;
	}
	
	
	

}
