import java.util.Scanner;

public class FeedbackCollection {
    private Scanner scanner = new Scanner(System.in);

    public void collectFeedback() {
        System.out.println("Enter your feedback:");
        String feedback = scanner.nextLine();
        System.out.println("Feedback received: " + feedback);
        saveFeedback(feedback);
    }

    private void saveFeedback(String feedback) {
        System.out.println("Feedback saved: " + feedback);
    }
}