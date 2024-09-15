package Batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/skill_navigator?useSSL=false";
            String user = "root"; // Update with your database username
            String password = ""; // Update with your database password
    
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            // Handle error if the driver class is not found
            System.err.println("MySQL JDBC Driver not found. Include the driver in your library path.");
            throw new SQLException("MySQL JDBC Driver not found", e);
        }      
    }
}

