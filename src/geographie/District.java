package geographie;

import java.util.Vector;

public class District {
    String nom;
    Vector<BureauVote> listeBureau;

    public District(String nom,Vector<BureauVote> listeBureau) {
        this.nom = nom;
        this.listeBureau = listeBureau;
    }

    public String getNom() {
        return nom;
    }

    public Vector<BureauVote> getListeBureau() {
        return listeBureau;
    }
}
