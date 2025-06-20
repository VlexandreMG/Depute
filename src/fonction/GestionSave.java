package fonction;

import politicien.Resultat;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GestionSave {
    public static void save(Resultat resultat) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("vote.txt", true))) {
            String ligne = resultat.getFaritanyVote() + "--" +
                    resultat.getRegionVote() + "--" +
                    resultat.getDistrictVote() + "--" +
                    resultat.getBureauVote() + "--" +
                    resultat.getNomcandidat() + "--" +
                    resultat.getNbVote();
            writer.write(ligne);
            writer.newLine();
        }
    }
}