package charge;
import database.*;
import additional.*;
import users.GraduateStudent;
import system.UniversityWSP;

public class GraduateStudentСharge {

    public static void submitThesis(GraduateStudent graduateStudent, String thesisTopic) {
        graduateStudent.setThesisTopic(thesisTopic);
        UniversityWSP.operationMessage("Thesis topic submitted for " + graduateStudent.getName() + " " + graduateStudent.getSurname());
    }

    public static void defendThesis(GraduateStudent graduateStudent) {
        if (graduateStudent.getThesisTopic() != null && !graduateStudent.getThesisTopic().isEmpty() && !graduateStudent.isThesisDefended()) {
            UniversityWSP.operationMessage("Thesis defense for topic \"" + graduateStudent.getThesisTopic() + "\" is successful!");
            graduateStudent.setThesisDefended(true);
        } else {
            UniversityWSP.operationMessage("Thesis defense is not possible. Make sure you submitted a thesis topic and haven't defended it already.");
        }
    }
    
    
    
    
    public static void viewDiplomaProjects() {
        System.out.println("Available Diploma Projects:");
        DataBase.getDiplomaProjects().forEach(project ->
                System.out.println("ID: " + project.getId() + ", Title: " + project.getTitle()));
    }

    public static DiplomaProject findDiplomaProjectById(String projectId) {
        return DataBase.getDiplomaProjects().stream()
                .filter(project -> project.getId().equals(projectId))
                .findFirst()
                .orElse(null);
    }

    public static void submitDiplomaProject(GraduateStudent graduateStudent, DiplomaProject diplomaProject) {
        graduateStudent.setDiplomaProject(diplomaProject);
        diplomaProject.setSubmitted(true);
    }

    public static void viewMyDiplomaProject(GraduateStudent graduateStudent) {
        DiplomaProject diplomaProject = graduateStudent.getDiplomaProject();
        if (diplomaProject != null) {
            System.out.println("Your Diploma Project:");
            System.out.println("ID: " + diplomaProject.getId());
            System.out.println("Title: " + diplomaProject.getTitle());
            System.out.println("Submitted: " + diplomaProject.isSubmitted());
        } else {
            System.out.println("You haven't submitted a Diploma Project yet.");
        }
    }
}
