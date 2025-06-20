package fonction;

import politicien.Resultat;

import java.util.Vector;

public class FiltrageComposant {

    public Vector<Resultat> VectorFaritany(Vector<Resultat> resultats) {
        Vector<Resultat> vector = new Vector<>();
        Vector<String> faritanyDejaAjoutees = new Vector<>(); // Pour éviter les doublons

        for (Resultat result : resultats) {
            String nomFaritany = result.getFaritanyVote();
            if (!faritanyDejaAjoutees.contains(nomFaritany)) {
                vector.add(result); // Ajoute le premier résultat trouvé pour cette Faritany
                faritanyDejaAjoutees.add(nomFaritany);
            }
        }
        return vector;
    }

    public Vector<Resultat> VectorRegion(Vector<Resultat> resultats) {
        Vector<Resultat> vector = new Vector<>();
        Vector<String> regionsDejaAjoutees = new Vector<>();

        for (Resultat result : resultats) {
            String nomRegion = result.getRegionVote();
            if (!regionsDejaAjoutees.contains(nomRegion)) {
                vector.add(result); // Ajoute un résultat par région unique
                regionsDejaAjoutees.add(nomRegion);
            }
        }
        return vector;
    }

    public Vector<Resultat> VectorDistrict(Vector<Resultat> resultats) {
        Vector<Resultat> vector = new Vector<>();
        Vector<String> districtsDejaAjoutes = new Vector<>();

        for (Resultat result : resultats) {
            String nomDistrict = result.getDistrictVote();
            if (!districtsDejaAjoutes.contains(nomDistrict)) {
                vector.add(result);
                districtsDejaAjoutes.add(nomDistrict);
            }
        }
        return vector;
    }

    public Vector<Resultat> VectorBureau(Vector<Resultat> resultats) {
        Vector<Resultat> vector = new Vector<>();
        Vector<String> bureauxDejaAjoutes = new Vector<>();

        for (Resultat result : resultats) {
            String nomBureau = result.getBureauVote();
            if (!bureauxDejaAjoutes.contains(nomBureau)) {
                vector.add(result);
                bureauxDejaAjoutes.add(nomBureau);
            }
        }
        return vector;
    }

}
