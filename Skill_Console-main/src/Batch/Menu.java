package Batch;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void showMainMenu() {
        System.out.println("1. Candidate");
        System.out.println("2. Trainer");
        System.out.println("3. Exit");
    }

    public static void showCandidateMenu() {
        System.out.println("1. Signup");
        System.out.println("2. Signin");
        System.out.println("3. Back to Main Menu");
    }

    public static void showTrainerMenu() {
        System.out.println("1. Signin");
        System.out.println("2. Back to Main Menu");
    }

    public static void showBatchesMenu(List<String> batches) {
        System.out.println("Available Batches:");
        for (int i = 0; i < batches.size(); i++) {
            System.out.println((i + 1) + ". " + batches.get(i));
        }
        System.out.println("Select a batch by entering the corresponding number:");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Connection connection = DatabaseConnection.getConnection();
            UserDAO userDAO = new UserDAO(connection);
            TrainerDAO trainerDAO = new TrainerDAO(connection);

            while (true) {
                showMainMenu();
                System.out.print("Select an option: ");
                int mainChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                try {
                    switch (mainChoice) {
                        case 1 -> { // Candidate
                            while (true) {
                                showCandidateMenu();
                                System.out.print("Select an option: ");
                                int candidateChoice = scanner.nextInt();
                                scanner.nextLine(); // Consume newline

                                switch (candidateChoice) {
                                    case 1 -> { // Signup
                                        System.out.println("Signup:");
                                        System.out.print("Enter your name: ");
                                        String name = scanner.nextLine();
                                        System.out.print("Enter your email: ");
                                        String email = scanner.nextLine();
                                        System.out.print("Enter your phone: ");
                                        String phone = scanner.nextLine();
                                        System.out.print("Enter your degree: ");
                                        String degree = scanner.nextLine();
                                        System.out.print("Enter your specialization: ");
                                        String specialization = scanner.nextLine();
                                        System.out.print("Enter your certifications (Mention only Python, Azure, AWS, Java, .NET in comma-separated): ");
                                        String certifications = scanner.nextLine();
                                        System.out.print("Create a password: ");
                                        String password = scanner.nextLine();

                                        User newUser = new User(name, email, phone, degree, specialization, certifications, password);
                                        userDAO.registerUser(newUser);
                                        System.out.println("User registered successfully.");

                                        // Prompt for sign-in immediately after successful signup
                                        System.out.println("Signin:");
                                        System.out.print("Enter your email: ");
                                        String loginEmail = scanner.nextLine();
                                        System.out.print("Enter your password: ");
                                        String loginPassword = scanner.nextLine();

                                        User loggedInUser = userDAO.loginUser(loginEmail, loginPassword);

                                        if (loggedInUser != null) {
                                            System.out.println("Signin successful. Welcome, " + loggedInUser.getName() + "!");
                                            List<String> eligibleBatches = loggedInUser.getEligibleBatches();
                                            if (eligibleBatches.isEmpty()) {
                                                System.out.println("No eligible batches found for your certifications.");
                                            } else {
                                                System.out.println("You are eligible for the following batches:");
                                                for (int i = 0; i < eligibleBatches.size(); i++) {
                                                    System.out.println((i + 1) + ". " + eligibleBatches.get(i));
                                                }

                                                System.out.print("Select a batch by entering the corresponding number: ");
                                                int batchChoice = scanner.nextInt();
                                                scanner.nextLine(); // Consume newline

                                                if (batchChoice > 0 && batchChoice <= eligibleBatches.size()) {
                                                    String selectedBatch = eligibleBatches.get(batchChoice - 1);
                                                    // Store the selected batch for the user
                                                 // Replace this line
                                                 // userDAO.storeBatchForUser(loginEmail, selectedBatch);

                                                 // With this line
                                                 userDAO.storeBatch(selectedBatch, loggedInUser.getName(), loginEmail);

                                                    System.out.println("You have selected: " + selectedBatch);
                                                } else {
                                                    System.out.println("Invalid selection. Please try again.");
                                                }
                                            }
                                        } else {
                                            System.out.println("Invalid email or password. Please try again.");
                                        }
                                    }
                                    case 2 -> { // Signin
                                        System.out.println("Signin:");
                                        System.out.print("Enter your email: ");
                                        String loginEmail = scanner.nextLine();
                                        System.out.print("Enter your password: ");
                                        String loginPassword = scanner.nextLine();

                                        User loggedInUser = userDAO.loginUser(loginEmail, loginPassword);

                                        if (loggedInUser != null) {
                                            System.out.println("Signin successful. Welcome, " + loggedInUser.getName() + "!");
                                            List<String> eligibleBatches = loggedInUser.getEligibleBatches();
                                            if (eligibleBatches.isEmpty()) {
                                                System.out.println("No eligible batches found for your certifications.");
                                            } else {
                                                System.out.println("You are eligible for the following batches:");
                                                for (int i = 0; i < eligibleBatches.size(); i++) {
                                                    System.out.println((i + 1) + ". " + eligibleBatches.get(i));
                                                }

                                                System.out.print("Select a batch by entering the corresponding number: ");
                                                int batchChoice = scanner.nextInt();
                                                scanner.nextLine(); // Consume newline

                                                if (batchChoice > 0 && batchChoice <= eligibleBatches.size()) {
                                                    String selectedBatch = eligibleBatches.get(batchChoice - 1);
                                                    // Store the selected batch for the user
                                                 // Replace this line
                                                 // userDAO.storeBatchForUser(loginEmail, selectedBatch);

                                                 // With this line
                                                 userDAO.storeBatch(selectedBatch, loggedInUser.getName(), loginEmail);

                                                    System.out.println("You have selected: " + selectedBatch);
                                                } else {
                                                    System.out.println("Invalid selection. Please try again.");
                                                }
                                            }
                                        } else {
                                            System.out.println("Invalid email or password. Please try again.");
                                        }
                                    }
                                    case 3 -> {
                                        // Go back to main menu
                                        break;
                                    }
                                    default -> System.out.println("Invalid option. Try again.");
                                }

                                if (candidateChoice == 3) break; // Exit the candidate menu loop if option 3 is selected
                            }
                        }

                        case 2 -> { // Trainer
                            while (true) {
                                showTrainerMenu();
                                System.out.print("Select an option: ");
                                int trainerChoice = scanner.nextInt();
                                scanner.nextLine(); // Consume newline

                                switch (trainerChoice) {
                                    case 1 -> { // Signin
                                        System.out.println("Welcome trainer!");

                                        System.out.print("Enter your username: ");
                                        String username = scanner.nextLine();
                                        System.out.print("Enter your password: ");
                                        String password = scanner.nextLine();

                                        Trainer trainer = trainerDAO.loginTrainer(username, password);

                                        if (trainer != null) {
                                            System.out.println("Trainer signin successful. Welcome, " + username + "!");

                                            // Get available batches for trainer
                                            List<String> batches = List.of("Java Batch", ".NET Batch", "Data Engineering Batch");
                                            showBatchesMenu(batches);

                                            int batchChoice = scanner.nextInt();
                                            scanner.nextLine(); // Consume newline

                                            if (batchChoice > 0 && batchChoice <= batches.size()) {
                                                String selectedBatch = batches.get(batchChoice - 1);
                                                int count = trainerDAO.getEnrolledCandidatesCount(selectedBatch);
                                                System.out.println("Number of candidates enrolled in " + selectedBatch + ": " + count);
                                            } else {
                                                System.out.println("Invalid selection. Please try again.");
                                            }
                                        } else {
                                            System.out.println("Invalid username or password. Please try again.");
                                        }
                                    }
                                    case 2 -> {
                                        // Go back to main menu
                                        break;
                                    }
                                    default -> System.out.println("Invalid option. Try again.");
                                }

                                if (trainerChoice == 2) break; // Exit the trainer menu loop if option 2 is selected
                            }
                        }

                        case 3 -> {
                            System.out.println("Exiting the application.");
                            return;
                        }

                        default -> System.out.println("Invalid option. Try again.");
                    }
                } catch (SQLException e) {
                    System.err.println("SQL Exception occurred: " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }
}
