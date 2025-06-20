package fonction;

import politicien.Resultat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;

public class SpitString {

    MisyTsymisy tsymisy = new MisyTsymisy();

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

    public String[][] gagnant(String selectfar, String selectreg, String selectdis, String selectbu) throws IOException {

        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("src/fonction/test.txt"))) {
            while (br.readLine() != null) {
                count++;
            }
        }


        String[][] tableau = new String[count][2];
        int index = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("src/fonction/test.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("--");

                if (parts.length == 6) {
                    String faritany = parts[0];
                    String region = parts[1];
                    String district = parts[2];
                    String bureau = parts[3];
                    String candidat = parts[4];
                    String nbvoix = parts[5];

                    if (tsymisy.fonction(faritany, region, district, bureau,
                            selectfar, selectreg, selectdis, selectbu)) {
                        tableau[index][0] = candidat;  // Stocke le candidat
                        tableau[index][1] = nbvoix;    // Stocke le nombre de voix
                        index++;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return tableau;
    }

    public String[][] trouverElusParDistrict(String[][] donnees) {
        // Étape 1: Compter le nombre de districts uniques
        Set<String> districts = new HashSet<>();
        for (String[] ligne : donnees) {
            districts.add(ligne[0]); // ligne[0] = district
        }

        // Étape 2: Créer le tableau de résultats
        String[][] elus = new String[districts.size()][3]; // [district, candidat, voix]
        int index = 0;

        // Étape 3: Pour chaque district, trouver le candidat élu
        for (String district : districts) {
            String candidatElu = "";
            int maxVoix = -1;

            // Parcourir toutes les lignes pour ce district
            for (String[] ligne : donnees) {
                if (ligne != null && ligne.length >= 3
                        && Objects.equals(ligne[0], district)) {  // Null-safe
                    try {
                        int voix = Integer.parseInt(ligne[2]);
                        if (voix > maxVoix) {
                            maxVoix = voix;
                            candidatElu = ligne[1];
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Nombre de voix invalide: " + ligne[2]);
                    }
                }
            }

            // Stocker le résultat
            elus[index][0] = district;
            elus[index][1] = candidatElu;
            elus[index][2] = String.valueOf(maxVoix);
            index++;
        }

        return elus;
    }

}