package podaci;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modeli.Proizvod;

public class ProizvodPodaci {

    public static List<Proizvod> ucitajProizvode(String filePath) {
        List<Proizvod> proizvodi = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(","); 

                Proizvod proizvod = new Proizvod(parts[0], line, Double.parseDouble(parts[1]), parts[2], parts[3], parts[4], 0, line, line, line);
                proizvodi.add(proizvod);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return proizvodi;
    }

    public static void sacuvajProizvode(List<Proizvod> proizvodi, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Proizvod proizvod : proizvodi) {
                String line = String.format("%s,%.2f,%s,%s,%s\n",
                        proizvod.getNaziv(),
                        proizvod.getCena(),
                        proizvod.getKategorija(),
                        proizvod.getJedinicaMere(),
                        proizvod.getProizvodjac());

                writer.write(line);
            }
            System.out.println("Proizvodi su uspešno sačuvani u datoteku.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
