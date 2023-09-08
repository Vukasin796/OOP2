package podaci;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modeli.Rukovodilac;

public class RukovodiociPodaci {

    public static List<Rukovodilac> ucitajRukovodioce(String filePath) {
        List<Rukovodilac> rukovodioci = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(","); 

                
                Rukovodilac rukovodilac = new Rukovodilac(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3], parts[4], parts[5]);
                rukovodioci.add(rukovodilac);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rukovodioci;
    }

    public static void sacuvajRukovodioce(List<Rukovodilac> rukovodioci, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Rukovodilac rukovodilac : rukovodioci) {
                String line = String.format("%s,%s,%.2f,%s,%s,%s,%s\n",
                        rukovodilac.getIme(),
                        rukovodilac.getPrezime(),
                        rukovodilac.getVisinaPlate(),
                        rukovodilac.getZvanje(),
                        rukovodilac.getStepenObrazovanja(),
                        rukovodilac.getZaduzenje());
                        

                writer.write(line);
            }
            System.out.println("Rukovodioci su uspešno sačuvani u datoteku.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}