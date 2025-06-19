package fonction;

import politicien.Resultat;

import java.util.Vector;

public class FiltrageComposant {

    public Vector<Resultat> VectorFaritany(Vector<Resultat> resultats,String faritany) {
        Vector<Resultat> vector = new Vector<>();
        for (Resultat result : resultats) {
                if (result.getFaritanyVote().equals(faritany)) {
                    vector.add(result);
                }
        }
        return vector;
    }

    public Vector<Resultat> VectorRegion(Vector<Resultat> resultats, String faritany, String region) {
        Vector<Resultat> vectorRegion = new Vector<>();
        for (Resultat resultat : resultats) {
            if (resultat.getFaritanyVote().equals(faritany)
                    && resultat.getRegionVote().equals(region)) {
                vectorRegion.add(resultat);
            }
        }
        return vectorRegion;
    }

    public Vector<Resultat> VectorDistrict(Vector<Resultat> resultats,String faritany,String region,String district) {
        Vector<Resultat> vectorDistrict = new Vector<>();
        for (Resultat resultat : resultats) {
            if (resultat.getFaritanyVote().equals(faritany) &&
            resultat.getRegionVote().equals(region) &&
            resultat.getDistrictVote().equals(district)) {
                vectorDistrict.add(resultat);
            }
        }
        return vectorDistrict;
    }

    public Vector<Resultat> VectorBureau(Vector<Resultat> resultats,String faritany,String region,String district,String bureau) {
        Vector<Resultat> vectorBureau = new Vector<>();
        for (Resultat resultat : resultats) {
            if (resultat.getFaritanyVote().equals(faritany) &&
            resultat.getRegionVote().equals(region) &&
            resultat.getDistrictVote().equals(district) &&
            resultat.getBureauVote().equals(bureau)) {
                vectorBureau.add(resultat);
            }
        }
        return vectorBureau;
    }
    
}
