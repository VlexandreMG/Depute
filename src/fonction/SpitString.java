package fonction;

import politicien.Resultat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SpitString {

    public Vector<Resultat> fonction() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/fonction/test.txt"));
        Vector<Resultat> arrayList = new Vector<>();
        String ligne;
        while ((ligne = bufferedReader.readLine()) != null) {
            String[] parts = ligne.split("--");

            if (parts.length == 6) {
                String faritany = parts[0];
                String region = parts[1];
                String district = parts[2];
                String bureau = parts[3];
                String candidat = parts[4];
                String nbvote = parts[5];

                int nombrevote = Integer.parseInt(nbvote);

                Resultat resultat = new Resultat(faritany, region, district, bureau, candidat, nombrevote);
                arrayList.add(resultat);
            }
        }
        return arrayList;
    }
}
