package users;
import enums.*;
import additional.*;

import enums.Gender;

public class GraduateStudent extends Student {
    private static final long serialVersionUID = 123456789L;

    private String thesisTopic;
    private boolean thesisDefended;
    private DiplomaProject diplomaProject;

    public GraduateStudent() {
        this.thesisDefended = false;
    }

    public GraduateStudent(String id, String name, String surname, Gender gender, String email, String login,
            String password, Faculty faculty, StudyDegree degree, Organization organization,
            String thesisTopic, boolean thesisDefended) {
    	super(id, name, surname, gender, email, login, password, faculty, degree, organization);
    	this.thesisTopic = thesisTopic;
    	this.thesisDefended = thesisDefended;
    }

    public String getThesisTopic() {
        return thesisTopic;
    }

    public void setThesisTopic(String thesisTopic) {
        this.thesisTopic = thesisTopic;
    }

    public boolean isThesisDefended() {
        return thesisDefended;
    }

    public void setThesisDefended(boolean thesisDefended) {
        this.thesisDefended = thesisDefended;
    }

    public DiplomaProject getDiplomaProject() {
        return diplomaProject;
    }

    public void setDiplomaProject(DiplomaProject diplomaProject) {
        this.diplomaProject = diplomaProject;
    }

    @Override
    public String toString() {
        return "GraduateStudent [thesisTopic=" + thesisTopic + ", thesisDefended=" + thesisDefended
                + ", " + super.toString() + "]";
    }

    @Override
    public int compareTo(Student other) {
        return super.compareTo(other);
    }

}
