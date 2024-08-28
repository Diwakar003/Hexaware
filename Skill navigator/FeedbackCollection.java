import java.util.Scanner;

public class FeedbackCollection {
    private Scanner scanner = new Scanner(System.in);

    public void collectFeedback(Candidate candidate) {
        System.out.println("Collecting feedback for " + candidate.getName());
    }

    public void analyzeFeedback() {
        System.out.println("Analyzing feedback...");
    }
}
