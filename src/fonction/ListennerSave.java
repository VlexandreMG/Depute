package fonction;

import politicien.Resultat;
import java.io.IOException;

public class ListennerSave {
    public void register(String faritany, String region, String district,
                         String bureau, String candidat, String nbvoix)
            throws IOException, NumberFormatException {
        int nombre = Integer.parseInt(nbvoix); // Lève NumberFormatException si invalide
        Resultat resultat = new Resultat(faritany, region, district, bureau, candidat, nombre);
        GestionSave.save(resultat);
    }
}