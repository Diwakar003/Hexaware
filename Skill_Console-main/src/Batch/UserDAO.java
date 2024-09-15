package Batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private Connection connection;

    // Constructor to initialize the connection
    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to register a new user
    public void registerUser(User user) throws SQLException {
        String query = "INSERT INTO users (name, email, phone, degree, specialization, certifications, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhone());
            statement.setString(4, user.getDegree());
            statement.setString(5, user.getSpecialization());
            statement.setString(6, user.getCertifications());
            statement.setString(7, user.getPassword());
            statement.executeUpdate();
        }
    }

    // Method to login a user
    public User loginUser(String email, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new User(resultSet.getString("name"), email, resultSet.getString("phone"),
                        resultSet.getString("degree"), resultSet.getString("specialization"),
                        resultSet.getString("certifications"), password);
            }
            return null; // Return null if no match found
        }
    }

    public void storeBatch(String batchName, String candidateName, String candidateEmail) throws SQLException {
        String query = "INSERT INTO batches (batch_name, candidate_name, candidate_email) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, batchName);
            statement.setString(2, candidateName);
            statement.setString(3, candidateEmail);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Failed to store batch selection.");
            }
        }
    }

    
    public void getCandidatesInBatch(String batchName) throws SQLException {
        String query = "SELECT users.name, users.email FROM users " +
                       "JOIN batches ON users.email = batches.candidate_email " +
                       "WHERE batches.batch_name = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, batchName);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("Candidates enrolled in " + batchName + ":");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("Name: " + name + ", Email: " + email);
            }
        }
    }
}
