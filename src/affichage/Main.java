package affichage;

import fonction.FiltrageComposant;
import fonction.SpitString;
import politicien.Resultat;

import java.io.IOException;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException {
        SpitString string = new SpitString();
        Vector<Resultat> valiny = string.fonction();

        //for (Resultat val : valiny) {
           // System.out.println(val.getNbVote());
        //}

        FiltrageComposant filtrageComposant = new FiltrageComposant();

        //Vector<Resultat> resultatVector = filtrageComposant.VectorFaritany(valiny);

        //for (Resultat resultat : resultatVector) {
            //System.out.println(resultat.getFaritanyVote());
        //}

        //Vector<Resultat> resultatVec = filtrageComposant.VectorRegion(valiny);
        //for (Resultat resultat : resultatVec) {
        //System.out.println(resultat.getRegionVote());
        //}

        //Vector<Resultat> resultatVect = filtrageComposant.VectorDistrict(valiny);
        //for (Resultat resultat : resultatVect) {
            //System.out.println(resultat.getDistrictVote());
        //}

        //Vector<Resultat> resultatVecto = filtrageComposant.VectorBureau(valiny);
        //for (Resultat resultat : resultatVecto) {
            //System.out.println(resultat.getBureauVote());
        //}

        //Vector<String> filtrageComposant1= filtrageComposant.trouverCandidatsGagnants(valiny);
        //System.out.println(filtrageComposant1);

        new MainFrame(valiny);
    }
}
