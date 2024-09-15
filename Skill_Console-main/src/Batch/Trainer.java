package Batch;

public class Trainer {
    private String username;
    private String name;

    // Constructor
    public Trainer(String username, String name) {
        this.username = username;
        this.name = name;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }
}
