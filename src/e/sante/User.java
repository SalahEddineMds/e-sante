
package e.sante;

public class User {
    private String nom;
    private String prenom;
    private String role;
    
    public User(String nom, String prenom, String role){
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }
    
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
    public String getRole(){
        return role;
    }
}
