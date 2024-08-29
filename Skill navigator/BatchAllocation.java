import java.util.ArrayList;
import java.util.List;

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
        
    }
}
