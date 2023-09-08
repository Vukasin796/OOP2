package podaci;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modeli.OdgovornaOsoba; 

public class OdgovorneOsobePodaci {

    public static List<OdgovornaOsoba> ucitajOdgovorneOsobe(String filePath) {
        List<OdgovornaOsoba> odgovorneOsobe = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(","); 

                
                OdgovornaOsoba osoba = new OdgovornaOsoba(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3], parts[4]);
                odgovorneOsobe.add(osoba);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return odgovorneOsobe;
    }

    public static void sacuvajOdgovorneOsobe(List<OdgovornaOsoba> odgovorneOsobe, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (OdgovornaOsoba osoba : odgovorneOsobe) {
                String line = String.format("%s,%s,%.2f,%s,%s\n",
                        osoba.getIme(),
                        osoba.getPrezime(),
                        osoba.getVisinaPlate(),
                        osoba.getZvanje(),
                        osoba.getStepenObrazovanja());

                writer.write(line);
            }
            System.out.println("Odgovorne osobe su uspešno sačuvane u datoteku.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
