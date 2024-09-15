package Batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchDAO {
    public void addBatch(Batch batch) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Batches (course_name, max_capacity) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, batch.getCourseName());
                statement.setInt(2, batch.getMaxCapacity());
                statement.executeUpdate();
            }
        }
    }

    public List<Batch> getAllBatches() throws SQLException {
        List<Batch> batches;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Batches";
            try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
                batches = new ArrayList<>();
                while (resultSet.next()) {
                    Batch batch = new Batch();
                    batch.setBatchId(resultSet.getInt("batch_id"));
                    batch.setCourseName(resultSet.getString("course_name"));
                    batch.setMaxCapacity(resultSet.getInt("max_capacity"));
                    batches.add(batch);
                }              }
        }
        return batches;
    }

    // Additional methods like updateBatch, deleteBatch, etc., can be added here
}
