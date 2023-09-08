package podaci;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modeli.TehnickiProizvod;

public class TehnickiProizvodPodaci {

    public static List<TehnickiProizvod> ucitajTehnickeProizvode(String filePath) {
        List<TehnickiProizvod> tehnickiProizvodi = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(","); 

                TehnickiProizvod proizvod = new TehnickiProizvod(parts[0], line, Double.parseDouble(parts[1]), parts[2], parts[3], parts[4], Double.parseDouble(parts[5]), parts[6], parts[7], line, 0, 0, line);
                tehnickiProizvodi.add(proizvod);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tehnickiProizvodi;
    }

    public static void sacuvajTehnickeProizvode(List<TehnickiProizvod> tehnickiProizvodi, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (TehnickiProizvod proizvod : tehnickiProizvodi) {
                String line = String.format("%s,%.2f,%s,%s,%s,%.2f,%s,%s\n",
                        proizvod.getNaziv(),
                        proizvod.getCena(),
                        proizvod.getKategorija(),
                        proizvod.getJedinicaMere(),
                        proizvod.getProizvodjac(),
                        proizvod.getNominalnaSnaga(),
                        proizvod.getRadniNapon(),
                        proizvod.getDimenzije());

                writer.write(line);
            }
            System.out.println("Tehnički proizvodi su uspešno sačuvani u datoteku.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
