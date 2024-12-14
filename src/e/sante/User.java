
package e.sante;

public class User {
    private String nom;
    private String prenom;
    private String role;
    private int Id;
    
    public User(int Id, String nom, String prenom, String role){
        this.Id = Id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }
    
    public int getId() {
        return Id;
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
