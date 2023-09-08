package podaci;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modeli.KvarljiviProizvod;

public class KvarljiviProizvodPodaci {

    public static List<KvarljiviProizvod> ucitajKvarljiveProizvode(String filePath) {
        List<KvarljiviProizvod> kvarljiviProizvodi = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(","); 

                KvarljiviProizvod proizvod = new KvarljiviProizvod(parts[0], line, Double.parseDouble(parts[1]), parts[2], parts[3], parts[4], 0, parts[5], line, line, null, line);
                kvarljiviProizvodi.add(proizvod);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return kvarljiviProizvodi;
    }

    public static void sacuvajKvarljiveProizvode(List<KvarljiviProizvod> kvarljiviProizvodi, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (KvarljiviProizvod proizvod : kvarljiviProizvodi) {
                String line = String.format("%s,%.2f,%s,%s,%s,%s\n",
                        proizvod.getNaziv(),
                        proizvod.getCena(),
                        proizvod.getKategorija(),
                        proizvod.getJedinicaMere(),
                        proizvod.getProizvodjac(),
                        proizvod.getRokTrajanja());

                writer.write(line);
            }
            System.out.println("Kvarljivi proizvodi su uspešno sačuvani u datoteku.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
