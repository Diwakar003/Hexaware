import java.util.List;

public class Candidate {
    private String name;
    private String email;
    private String degree;
    private String specialization;
    private String phoneNumber;
    private List<String> certifications;
    private List<String> internshipDetails;
    private List<String> coursesCompleted;
    private String linkedInProfile;
    private String gitHubProfile;
    private List<String> programmingLanguagesKnown;
    private List<String> eCertificates;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public List<String> getCertifications() { return certifications; }
    public void setCertifications(List<String> certifications) { this.certifications = certifications; }

    public List<String> getInternshipDetails() { return internshipDetails; }
    public void setInternshipDetails(List<String> internshipDetails) { this.internshipDetails = internshipDetails; }

    public List<String> getCoursesCompleted() { return coursesCompleted; }
    public void setCoursesCompleted(List<String> coursesCompleted) { this.coursesCompleted = coursesCompleted; }

    public String getLinkedInProfile() { return linkedInProfile; }
    public void setLinkedInProfile(String linkedInProfile) { this.linkedInProfile = linkedInProfile; }

    public String getGitHubProfile() { return gitHubProfile; }
    public void setGitHubProfile(String gitHubProfile) { this.gitHubProfile = gitHubProfile; }

    public List<String> getProgrammingLanguagesKnown() { return programmingLanguagesKnown; }
    public void setProgrammingLanguagesKnown(List<String> programmingLanguagesKnown) { this.programmingLanguagesKnown = programmingLanguagesKnown; }

    public List<String> geteCertificates() { return eCertificates; }
    public void seteCertificates(List<String> eCertificates) { this.eCertificates = eCertificates; }
}
