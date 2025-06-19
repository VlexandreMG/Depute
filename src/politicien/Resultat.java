package politicien;

public class Resultat {
    String faritanyVote;
    String regionVote;
    String districtVote;
    String bureauVote;
    String nomcandidat;
    int nbVote;

    public Resultat(String faritanyVote,String regionVote,String districtVote,String bureauVote,String candidatVote,int nbVote) {
        this.faritanyVote = faritanyVote;
        this.regionVote = regionVote;
        this.districtVote = districtVote;
        this.bureauVote = bureauVote;
        this.nomcandidat = candidatVote;
        this.nbVote = nbVote;
    }

    public String getBureauVote() {
        return bureauVote;
    }

    public String getDistrictVote() {
        return districtVote;
    }

    public String getFaritanyVote() {
        return faritanyVote;
    }

    public String getNomcandidat() {
        return nomcandidat;
    }

    public int getNbVote() {
        return nbVote;
    }

    public String getRegionVote() {
        return regionVote;
    }

}
