package fonction;

import politicien.Candidat;
import politicien.Resultat;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpitString {

    public void fonction(BufferedReader reader) throws IOException {
        ArrayList<Resultat> arrayList = new ArrayList<>();
        String string;
        while ((string = reader.readLine()) != null) {
            String[] parts = string.split("--");

            String faritany = parts[0];
            String region = parts[1];
            String district = parts[2];
            String bureau = parts[3];
            String candidat = parts[4];
            String nbvote = parts[5];

            int nombrevote = Integer.parseInt(nbvote);

            Resultat resultat = new Resultat(faritany,region,district,bureau,candidat,nombrevote);
            arrayList.add(resultat);
        }
    }
}
