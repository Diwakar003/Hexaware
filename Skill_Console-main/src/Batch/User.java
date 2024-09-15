package Batch;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId; // Optional field for tracking user IDs
    private String name;
    private String email;
    private String phone;
    private String degree;
    private String specialization;
    private String certifications; // Comma-separated certifications
    private String password;
    private String selectedBatch; // Field for storing the selected batch

    // Default constructor
    public User() {
    }

    // Constructor with all fields
    public User(String name, String email, String phone, String degree, String specialization, String certifications, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.degree = degree;
        this.specialization = specialization;
        this.certifications = certifications;
        this.password = password;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSelectedBatch() {
        return selectedBatch;
    }

    public void setSelectedBatch(String selectedBatch) {
        this.selectedBatch = selectedBatch;
    }

    // Method to get eligible batches based on certifications
    public List<String> getEligibleBatches() {
        List<String> eligibleBatches = new ArrayList<>();
        String[] userCertifications = certifications.toLowerCase().split(",");

        for (String cert : userCertifications) {
            cert = cert.trim();
            if (cert.contains("aws") || cert.contains("java")) {
                if (!eligibleBatches.contains("Java Batch")) {
                    eligibleBatches.add("Java Batch");
                }
            }
            if (cert.contains("azure") || cert.contains(".net")) {
                if (!eligibleBatches.contains(".NET Batch")) {
                    eligibleBatches.add(".NET Batch");
                }
            }
            if (cert.contains("python")) {
                if (!eligibleBatches.contains("Data Engineering Batch")) {
                    eligibleBatches.add("Data Engineering Batch");
                }
            }
        }

        return eligibleBatches;
    }
}
