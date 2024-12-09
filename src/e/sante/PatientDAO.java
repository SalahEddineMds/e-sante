package e.sante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PatientDAO {
    public void saveUser(String nom, String prenom, String role, String nomutilise, String password) {
        String query = "INSERT INTO user (Nom, Prenom, Role, NomUtilise, Password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the values for the prepared statement
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, role);
            stmt.setString(4, nomutilise);
            stmt.setString(5, password);

            // Execute the query
            stmt.executeUpdate();
            System.out.println("Patient saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String[] validateLogin(String username, String password) {
        String[] result = new String[2];
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT ID, Role FROM user WHERE NomUtilise = ? AND Password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result[0] = rs.getString("Role");
                result[1] = rs.getString("ID");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public void savePatientData(int patientId, double poids, double temperature, double tension, double tauxGlycemie) {
        String query = "INSERT INTO donnee_patient (id_patient, poids, temperature, tension, taux_glycemie) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, patientId);
            stmt.setDouble(2, poids);
            stmt.setDouble(3, temperature);
            stmt.setDouble(4, tension);
            stmt.setDouble(5, tauxGlycemie);

            stmt.executeUpdate();
            System.out.println("Patient data saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public boolean isUsernameTaken(String nomutilise) {
    String query = "SELECT COUNT(*) FROM user WHERE NomUtilise = ?";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        
        stmt.setString(1, nomutilise);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

}
