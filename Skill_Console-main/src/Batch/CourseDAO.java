package Batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    public void addCourse(Course course) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Courses (course_name, duration) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, course.getCourseName());
                statement.setInt(2, course.getDuration());
                statement.executeUpdate();
            }
        }
    }

    public List<Course> getAllCourses() throws SQLException {
        List<Course> courses;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Courses";
            try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
                courses = new ArrayList<>();
                while (resultSet.next()) {
                    Course course = new Course();
                    course.setCourseId(resultSet.getInt("course_id"));
                    course.setCourseName(resultSet.getString("course_name"));
                    course.setDuration(resultSet.getInt("duration"));
                    courses.add(course);
                }              }
        }
        return courses;
    }
    public void trackCourseCompletion(int candidateId, int courseId, double score) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Course_Completion (candidate_id, course_id, score) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, candidateId);
                statement.setInt(2, courseId);
                statement.setDouble(3, score);
                statement.executeUpdate();
            }
        }
    }
    

    // Additional methods like updateCourse, deleteCourse, etc., can be added here
}
