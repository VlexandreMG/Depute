package fonction;

import geographie.District;
import politicien.Resultat;

import java.util.Vector;

public class FiltrageComposant {

    public Vector<String> getRegionsFromFaritany(Vector<Resultat> resultats, String nomFaritany) {
        Vector<String> regions = new Vector<>();
        for (Resultat r : resultats) {
            if (r.getFaritanyVote().equals(nomFaritany) && !regions.contains(r.getRegionVote())) {
                regions.add(r.getRegionVote());
            }
        }
        return regions;
    }

    public Vector<String> getDistrictFromRegion(Vector<Resultat> resultats, String nomDistrict) {
        Vector<String> district = new Vector<>();
        for (Resultat r : resultats) {
            if (r.getRegionVote().equals(nomDistrict) && !district.contains(r.getDistrictVote())) {
                district.add(r.getDistrictVote());
            }
        }
        return district;
    }

    public Vector<String> getBureauFromDistrict(Vector<Resultat> resultats, String nomBureau) {
        Vector<String> bureau = new Vector<>();
        for (Resultat r : resultats) {
            if (r.getDistrictVote().equals(nomBureau) && !bureau.contains(r.getBureauVote())) {
                bureau.add(r.getBureauVote());
            }
        }
        return bureau;
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

    public Vector<Resultat> VectorCandidats(Vector<Resultat> resultats) {
        Vector<Resultat> vector = new Vector<>();
        Vector<String> candidatDejaAjoutes = new Vector<>();

        for (Resultat result : resultats) {
            String candidat = result.getNomcandidat();
            if (!candidatDejaAjoutes.contains(candidat)) {
                vector.add(result);
                candidatDejaAjoutes.add(candidat);
            }
        }
        return vector;
    }
}
