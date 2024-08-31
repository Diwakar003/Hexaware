import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainingProgressTracking {
    private Map<Candidate, Integer> courseCompletion = new HashMap<>();
    private Map<Candidate, Integer> mcqScores = new HashMap<>();
    private Map<Candidate, Integer> projectScores = new HashMap<>();

    public void trackProgress(Candidate candidate, int completionPercentage, int mcqScore, int projectScore) {
        courseCompletion.put(candidate, completionPercentage);
        mcqScores.put(candidate, mcqScore);
        projectScores.put(candidate, projectScore);
        System.out.println("Progress tracked for candidate: " + candidate.getName());
    }

    public void generateIndividualReport(Candidate candidate) {
        System.out.println("Generating report for: " + candidate.getName());
        System.out.println("Course Completion: " + courseCompletion.get(candidate) + "%");
        System.out.println("MCQ Score: " + mcqScores.get(candidate));
        System.out.println("Project Score: " + projectScores.get(candidate));
    }

    public void generateTrainersFeedbackReport(List<Candidate> candidates) {
        System.out.println("Generating trainer's feedback report...");
        for (Candidate candidate : candidates) {
            System.out.println("Candidate: " + candidate.getName() + " - Feedback collected.");
        }
    }
}
