package geographie;

import java.util.Vector;

public class Region {
    String nom;
    Vector<District> listeDistrict;

    public Region(String nom,Vector<District> listeDistrict) {
        this.nom = nom;
        this.listeDistrict = listeDistrict;
    }

    public String getNom() {
        return nom;
    }

    public Vector<District> getListeDistrict() {
        return listeDistrict;
    }
}

