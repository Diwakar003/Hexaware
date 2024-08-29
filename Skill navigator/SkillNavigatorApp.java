import java.util.ArrayList;  // Importing ArrayList
import java.util.List;  // Importing List
import java.util.Scanner;

public class SkillNavigatorApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CandidateDAO candidateDAO = new CandidateDAO();
        List<Candidate> candidates = new ArrayList<>();
        String moreCandidates;

        do {
            System.out.println("Enter candidate details:");
            Candidate candidate = new Candidate();
            System.out.print("Name: ");
            candidate.setName(scanner.nextLine());
            System.out.print("Email: ");
            candidate.setEmail(scanner.nextLine());
            System.out.print("Degree: ");
            candidate.setDegree(scanner.nextLine());
            System.out.print("Specialization: ");
            candidate.setSpecialization(scanner.nextLine());
            System.out.print("Phone Number: ");
            candidate.setPhoneNumber(scanner.nextLine());

            System.out.print("Enter number of certifications: ");
            int numCertifications = Integer.parseInt(scanner.nextLine());
            List<String> certifications = new ArrayList<>();
            for (int i = 0; i < numCertifications; i++) {
                System.out.print("Certification " + (i + 1) + ": ");
                certifications.add(scanner.nextLine());
            }
            candidate.setCertifications(certifications);

            // Save candidate to the database
            candidateDAO.addCandidate(candidate);
            candidates.add(candidate);

            System.out.println("Candidate added successfully!");

            System.out.print("Do you want to add another candidate? (yes/no): ");
            moreCandidates = scanner.nextLine();
        } while (moreCandidates.equalsIgnoreCase("yes"));

        // Display all candidates
        List<Candidate> allCandidates = candidateDAO.getAllCandidates();
        System.out.println("All Candidates:");
        for (Candidate c : allCandidates) {
            System.out.println("Name: " + c.getName() + ", Email: " + c.getEmail());
        }

        // Batch allocation
        BatchAllocation batchAllocator = new BatchAllocation();
        batchAllocator.allocateBatch(allCandidates);

        System.out.println("Batch allocation completed successfully!");
    }
}
