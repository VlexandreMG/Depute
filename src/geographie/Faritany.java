package geographie;

import java.util.Vector;

public class Faritany {
    String nom;
    Vector<Region> listeRegion;

    public Faritany(String nom,Vector<Region> listeRegion) {
        this.nom = nom;
        this.listeRegion = listeRegion;
    }

    public String getNom() {
        return nom;
    }

    public Vector<Region> getListeRegion() {
        return listeRegion;
    }
}
