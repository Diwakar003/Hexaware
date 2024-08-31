import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BatchAllocation {
    private static final String JAVA_CERTIFICATION = "Java";
    private static final String AWS_CERTIFICATION = "AWS";
    private static final String DOTNET_CERTIFICATION = ".NET";
    private static final String AZURE_CERTIFICATION = "Azure";
    private static final String PYTHON_CERTIFICATION = "Python";

    public void allocateBatch(List<Candidate> candidates) {
        List<Candidate> javaBatch = new ArrayList<>();
        List<Candidate> dotnetBatch = new ArrayList<>();
        List<Candidate> dataEngineeringBatch = new ArrayList<>();

        for (Candidate candidate : candidates) {
            if (candidate.getCertifications().contains(AWS_CERTIFICATION) || 
                candidate.getCertifications().contains(JAVA_CERTIFICATION)) {
                javaBatch.add(candidate);
            } else if (candidate.getCertifications().contains(AZURE_CERTIFICATION) || 
                       candidate.getCertifications().contains(DOTNET_CERTIFICATION)) {
                dotnetBatch.add(candidate);
            } else if (candidate.getCertifications().contains(PYTHON_CERTIFICATION)) {
                dataEngineeringBatch.add(candidate);
            }
        }

        printBatch("Java Batch", javaBatch);
        printBatch(".NET Batch", dotnetBatch);
        printBatch("Data Engineering Batch", dataEngineeringBatch);
    }

    private void printBatch(String batchName, List<Candidate> batch) {
        System.out.println("\n" + batchName + ":");
        if (batch.isEmpty()) {
            System.out.println("No candidates in this batch.");
        } else {
            for (Candidate candidate : batch) {
                System.out.println("Candidate Name: " + candidate.getName());
            }
        }
    }

    // Method to show available batches
    public void showAvailableBatches() {
        System.out.println("\nAvailable Batches:");
        System.out.println("1. Java Batch");
        System.out.println("2. .NET Batch");
        System.out.println("3. Data Engineering Batch");
    }

    // Method to choose a batch
    public String chooseBatch(Scanner scanner) {
        System.out.print("Enter the number of the batch you want to join: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                return "Java Batch";
            case 2:
                return ".NET Batch";
            case 3:
                return "Data Engineering Batch";
            default:
                System.out.println("Invalid choice! Defaulting to Java Batch.");
                return "Java Batch";
        }
    }
}
