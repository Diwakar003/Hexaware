package Batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerDAO {
    
    private Connection connection;

    // Constructor to initialize the connection
    public TrainerDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to authenticate a trainer
    public Trainer loginTrainer(String username, String password) throws SQLException {
        String query = "SELECT * FROM trainers WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Trainer(username, query);
            }
            return null; // Return null if no match found
        }
    }

    // Method to get the number of candidates enrolled in a batch
    public int getEnrolledCandidatesCount(String batchName) throws SQLException {
        String query = "SELECT COUNT(*) FROM batches WHERE batch_name = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, batchName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            return 0;
        }
    }
}
