package e.sante;

public class Patient {
    private String nom;
    private String prenom;

    public Patient(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
