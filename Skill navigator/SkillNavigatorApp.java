import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SkillNavigatorApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Candidate> candidates = new ArrayList<>();
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

        String chosenCourse = chooseCourse();

        System.out.println("Candidate " + candidate.getName() + " has chosen the " + chosenCourse + " course.");

        candidates.add(candidate);

        BatchAllocation batchAllocator = new BatchAllocation();
        batchAllocator.allocateBatch(candidates);

        TrainingProgressTracking progressTracker = new TrainingProgressTracking();
        System.out.print("Enter course completion percentage: ");
        int completionPercentage = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter MCQ score: ");
        int mcqScore = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter project score: ");
        int projectScore = Integer.parseInt(scanner.nextLine());
        progressTracker.trackProgress(candidate, completionPercentage, mcqScore, projectScore);
        progressTracker.generateIndividualReport(candidate);

        FeedbackCollection feedbackCollector = new FeedbackCollection();
        feedbackCollector.collectFeedback(candidate);
        feedbackCollector.analyzeFeedback();

        progressTracker.generateTrainersFeedbackReport(candidates);

        System.out.println("Skill Navigator Application finished.");
    }

    private static String chooseCourse() {
        System.out.println("Available courses:");
        System.out.println("1. Java Batch");
        System.out.println("2. .NET Batch");
        System.out.println("3. Data Engineering Batch");
        System.out.print("Select a course by entering the corresponding number: ");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                return "Java Batch";
            case 2:
                return ".NET Batch";
            case 3:
                return "Data Engineering Batch";
            default:
                System.out.println("Invalid choice. Defaulting to Java Batch.");
                return "Java Batch";
        }
    }
}
