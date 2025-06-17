package politicien;

public class Candidat {
    int numero;
    String nom;
    int nbVote;

    public Candidat(int numero,String nom,int nbVote) {
        this.nom = nom;
        this.numero = numero;
        this.nbVote = nbVote;
    }
    public String getNom() {
        return nom;
    }

    public int getNumero() {
        return numero;
    }

    public int getNbVote() {
        return nbVote;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNbVote(int nbVote) {
        this.nbVote = nbVote;
    }
}
