package Batch;

public class Batch {
    private int batchId;
    private String courseName;
    private int maxCapacity;

    public Batch() {}

    public Batch(String courseName, int maxCapacity) {
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
    }

    // Getters and Setters

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
