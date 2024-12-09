
package e.sante;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/e-sante";
            String user = "root"; // Replace with your MySQL username
            String password = ""; // Replace with your MySQL password
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
