package geographie;

import politicien.Candidat;

import java.util.Vector;

public class BureauVote {
    String nom;
    Vector<Candidat> listeCandidat;

    public BureauVote(String nom,Vector<Candidat> listeCandidat) {
        this.nom = nom;
        this.listeCandidat = listeCandidat;
    }

    public String getNom() {
        return nom;
    }

    public Vector<Candidat> getListeCandidat() {
        return listeCandidat;
    }
}
