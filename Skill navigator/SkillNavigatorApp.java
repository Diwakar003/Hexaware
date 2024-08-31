import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SkillNavigatorApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CandidateDAO candidateDAO = new CandidateDAO();
        List<Candidate> candidates = new ArrayList<>();
        String choice;

        System.out.println("Welcome to Skill Navigator!");
        System.out.print("Do you want to Sign Up or Sign In? (signup/signin): ");
        choice = scanner.nextLine();

        Candidate candidate = null;

        if (choice.equalsIgnoreCase("signup")) {
            candidate = signUp(candidateDAO);

            // After successful signup, prompt the user to sign in
            if (candidate != null) {
                System.out.println("Please sign in now.");
                candidate = signIn(candidateDAO);
            }
        } else if (choice.equalsIgnoreCase("signin")) {
            candidate = signIn(candidateDAO);
        } else {
            System.out.println("Invalid choice! Exiting...");
            return;
        }

        if (candidate != null) {
            candidates.add(candidate);
            System.out.println("Candidate signed in successfully!");

            // Display all candidates
            List<Candidate> allCandidates = candidateDAO.getAllCandidates();
            System.out.println("All Candidates:");
            for (Candidate c : allCandidates) {
                System.out.println("Name: " + c.getName() +
                                   ", Email: " + c.getEmail());
            }

            // Batch allocation
            BatchAllocation batchAllocator = new BatchAllocation();
            batchAllocator.allocateBatch(allCandidates); // Allocate batches based on certifications

            // Show available batches and let the user choose
            batchAllocator.showAvailableBatches();  // Display the available batches
            String chosenBatch = batchAllocator.chooseBatch(scanner);  // Allow the user to choose a batch

            System.out.println("You have chosen the " + chosenBatch + "!");
        }
    }

    private static Candidate signUp(CandidateDAO candidateDAO) {
        Candidate candidate = new Candidate();
        System.out.print("Name: ");
        candidate.setName(scanner.nextLine());
        System.out.print("Email: ");
        candidate.setEmail(scanner.nextLine());

        // Check if the email is already registered
        if (candidateDAO.getCandidateByEmail(candidate.getEmail()) != null) {
            System.out.println("Email already registered. Please sign in.");
            return null;
        }

        System.out.print("Password: ");
        candidate.setPassword(scanner.nextLine());
        System.out.print("Degree: ");
        candidate.setDegree(scanner.nextLine());
        System.out.print("Specialization: ");
        candidate.setSpecialization(scanner.nextLine());
        System.out.print("Phone Number: ");
        candidate.setPhoneNumber(scanner.nextLine());
        System.out.print("LinkedIn Profile: ");
        candidate.setLinkedInProfile(scanner.nextLine());
        System.out.print("GitHub Profile: ");
        candidate.setGitHubProfile(scanner.nextLine());

        System.out.print("Enter number of certifications: ");
        int numCertifications = Integer.parseInt(scanner.nextLine());
        List<String> certifications = new ArrayList<>();
        for (int i = 0; i < numCertifications; i++) {
            System.out.print("Certification " + (i + 1) + ": ");
            certifications.add(scanner.nextLine());
        }
        candidate.setCertifications(certifications);

        candidateDAO.addCandidate(candidate);
        System.out.println("Sign up successful!");
        return candidate;
    }

    private static Candidate signIn(CandidateDAO candidateDAO) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        Candidate candidate = candidateDAO.getCandidateByEmail(email);

        if (candidate != null && candidate.getPassword().equals(password)) {
            System.out.println("Sign in successful!");
            return candidate;
        } else {
            System.out.println("Invalid email or password. Please try again.");
            return null;
        }
    }
}