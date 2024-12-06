package e.sante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PatientDAO {
    public void savePatient(String nom, String prenom, String role, String nomutilise, String password) {
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
    
    public String validateLogin(String username, String password) {
        String role = null;
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT Role FROM user WHERE NomUtilise = ? AND Password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                role = rs.getString("Role");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }
    
}
