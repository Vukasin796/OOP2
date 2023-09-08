package modeli;

import java.time.LocalDate;

public class Zaduzenje {
	protected String naziv;
	protected  LocalDate datumIzvrsenja;
	
	public Zaduzenje(String naziv, LocalDate datumIzvrsenja) {
		super();
		this.naziv = naziv;
		this.datumIzvrsenja = datumIzvrsenja;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public LocalDate getDatumIzvrsenja() {
		return datumIzvrsenja;
	}

	public void setDatumIzvrsenja(LocalDate datumIzvrsenja) {
		this.datumIzvrsenja = datumIzvrsenja;
	}
	
	
	
	

}
