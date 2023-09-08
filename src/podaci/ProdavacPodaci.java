package podaci;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modeli.Prodavac; 

public class ProdavacPodaci {

    public static List<Prodavac> ucitajProdavce(String filePath) {
        List<Prodavac> prodavci = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(","); 

                
                Prodavac prodavac = new Prodavac(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3], parts[4], parts[5], line);
                prodavci.add(prodavac);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prodavci;
    }

    public static void sacuvajProdavce(List<Prodavac> prodavci, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Prodavac prodavac : prodavci) {
                String line = String.format("%s,%s,%.2f,%s,%s,%s\n",
                        prodavac.getIme(),
                        prodavac.getPrezime(),
                        prodavac.getVisinaPlate(),
                        prodavac.getZvanje(),
                        prodavac.getStepenObrazovanja(),
                        prodavac.getRadnoMesto());

                writer.write(line);
            }
            System.out.println("Prodavci su uspešno sačuvani u datoteku.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
