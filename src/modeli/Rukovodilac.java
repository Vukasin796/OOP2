package modeli;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rukovodilac extends OdgovornaOsoba{
	private String zaduzenje;
	private List<Zaduzenje> zaduzenja = new ArrayList<>();
	
	public Rukovodilac(String ime, String prezime, double visinaPlate, String zvanje, String stepenObrazovanja, String zaduzenje) {
		super(ime, prezime, visinaPlate, zvanje, stepenObrazovanja);
		this.zaduzenje = zaduzenje;
		
	}

	public String getZaduzenje() {
		return zaduzenje;
	}

	public void setZaduzenje(String zaduzenje) {
		this.zaduzenje = zaduzenje;
	}
	
	public List<Zaduzenje> getZaduzenja(){
		return zaduzenja;
	}
	
	public void dodajZaduzenje(String naziv, LocalDate datum) {
		zaduzenja.add(new Zaduzenje(naziv, datum));
	}
	public List<Zaduzenje> getRealizovanaZaduzenja() {
        List<Zaduzenje> realizovana = new ArrayList<>();
        for (Zaduzenje zaduzenje : zaduzenja) {
            if (zaduzenje.getDatumIzvrsenja() != null) {
                realizovana.add(zaduzenje);
            }
        }
        return realizovana;
    }

    public List<Zaduzenje> getNerealizovanaZaduzenja() {
        List<Zaduzenje> nerealizovana = new ArrayList<>();
        for (Zaduzenje zaduzenje : zaduzenja) {
            if (zaduzenje.getDatumIzvrsenja() == null) {
                nerealizovana.add(zaduzenje);
            }
        }
        return nerealizovana;
    }
	
	
	
	
	
	

}
