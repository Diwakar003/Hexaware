import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {
    private List<Candidate> candidateList = new ArrayList<>();

    public void addCandidate(Candidate candidate) {
        candidateList.add(candidate);
    }

    public List<Candidate> getAllCandidates() {
        return candidateList;
    }

    public Candidate getCandidateByEmail(String email) {
        for (Candidate candidate : candidateList) {
            if (candidate.getEmail().equalsIgnoreCase(email)) {
                return candidate;
            }
        }
        return null;
    }
}
// public void printCandidateProfiles(Candidate candidate) {
//     System.out.println("LinkedIn Profile: " + candidate.getLinkedInProfile());
//     System.out.println("GitHub Profile: " + candidate.getGitHubProfile());
// }
// }

    // Example method where getLinkedInProfile and getGitHubProfile are used