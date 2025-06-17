package fonction;

import java.util.Vector;
import geographie.*;
import politicien.Candidat;

public class DataCreator {

    public static Vector<Faritany> faritany() {
        Vector<Faritany> provinces = new Vector<>();
        provinces.add(new Faritany("Antananarivo", regions1()));
        provinces.add(new Faritany("Toamasina", regions2()));
        return provinces;
    }

    public static Vector<Region> regions1() {
        Vector<Region> regions = new Vector<>();
        regions.add(new Region("Analamanga", districts1()));
        regions.add(new Region("Vakinankaratra", districts2()));
        return regions;
    }

    public static Vector<Region> regions2() {
        Vector<Region> regions = new Vector<>();
        regions.add(new Region("Atsinanana", districts3()));
        return regions;
    }

    public static Vector<District> districts1() {
        Vector<District> districts = new Vector<>();
        districts.add(new District("Antananarivo-Renivohitra", bureaux1()));
        return districts;
    }

    public static Vector<District> districts2() {
        Vector<District> districts = new Vector<>();
        districts.add(new District("Antsirabe I", bureaux2()));
        return districts;
    }

    public static Vector<District> districts3() {
        Vector<District> districts = new Vector<>();
        districts.add(new District("Toamasina I", bureaux3()));
        return districts;
    }

    public static Vector<BureauVote> bureaux1() {
        Vector<BureauVote> bureaux = new Vector<>();
        bureaux.add(new BureauVote("Bureau A", candidats1()));
        bureaux.add(new BureauVote("Bureau B", candidats2()));
        return bureaux;
    }

    public static Vector<BureauVote> bureaux2() {
        Vector<BureauVote> bureaux = new Vector<>();
        bureaux.add(new BureauVote("Bureau C", candidats1()));
        return bureaux;
    }

    public static Vector<BureauVote> bureaux3() {
        Vector<BureauVote> bureaux = new Vector<>();
        bureaux.add(new BureauVote("Bureau D", candidats2()));
        return bureaux;
    }

    public static Vector<Candidat> candidats1() {
        Vector<Candidat> candidats = new Vector<>();
        candidats.add(new Candidat(1,"Rakoto",1234));
        candidats.add(new Candidat(2,"Rabe",4569));
        return candidats;
    }

    public static Vector<Candidat> candidats2() {
        Vector<Candidat> candidats = new Vector<>();
        candidats.add(new Candidat(3,"Balou",4862));
        candidats.add(new Candidat(4,"Bal",4896));
        return candidats;
    }
}
