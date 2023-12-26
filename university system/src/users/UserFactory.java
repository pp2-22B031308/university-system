package users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import additional.*;
import enums.*;

public class UserFactory {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static User getInstance(int type) throws IOException {
        System.out.println("ID:");
        String id = br.readLine();
        
        System.out.println("Name:");
        String name = br.readLine();
        
        System.out.println("Surname:");
        String surname = br.readLine();
       
        System.out.println("Gender:\n1.Male\n2.Female");
        Gender gender = Gender.convertGen(Integer.parseInt(br.readLine()));
        
        System.out.println("Email:");
        String email = br.readLine();
        
        System.out.println("Login:");
        String login = br.readLine();
        
        System.out.println("Temp password:");
        String password = br.readLine();

        switch (type) {
            case 1:
                return createStudent(id, name, surname, gender, email, login, password);
            case 2:
                return createTeacher(id, name, surname, gender, email, login, password);
            case 3:
                return createManager(id, name, surname, gender, email, login, password);
            case 4:
                return createGraduateStudent(id, name, surname, gender, email, login, password);
            case 5:
                return createTechSupportSpecialist(id, name, surname, gender, email, login, password);
  
        }
        return null;
    }

    private static Student createStudent(String id, String name, String surname, Gender gender, String email, String login, String password) throws IOException {
        System.out.println("Faculty:\n1.ISE\n2.SBS\n3.SEPI\n4.SGGE\n5.SITE\n6.SNSS");
        Faculty faculty = Faculty.convertToFac(Integer.parseInt(br.readLine()));
        
        System.out.println("Study Degree:\n1.PHD\n2.MASTER\n3.BACHELOR");
        StudyDegree degree = StudyDegree.convertStudyDegree(Integer.parseInt(br.readLine()));
        
        System.out.println("Organization:\nName:\n1.OSIT\n2.BCL\n3.CRYSTALS\n4.FACES");
        OrganizationName orgName = OrganizationName.convertOrganizationName(Integer.parseInt(br.readLine()));
        
        System.out.println("Role in organization:\n1.Head\n2.Member");
        OrganizationRole role = OrganizationRole.convertRole(Integer.parseInt(br.readLine()));
        
        Organization organization = new Organization(orgName, role);
        
        return new Student(id, name, surname, gender, email, login, password, faculty, degree, organization);
    }

    private static Teacher createTeacher(String id, String name, String surname, Gender gender, String email, String login, String password) throws IOException {
        System.out.println("Faculty:\n1.ISE\n2.SBS\n3.SEPI\n4.SGGE\n5.SITE\n6.SNSS");
        Faculty faculty = Faculty.convertToFac(Integer.parseInt(br.readLine()));
        
        System.out.println("Teacher Type:\n1.Professor\n2.Senior Lecturer\n3.Tutor");
        TeacherType teacherType = TeacherType.convertTeacherType(Integer.parseInt(br.readLine()));
        
        return new Teacher(id, name, surname, gender, email, login, password, faculty, teacherType);
    }

    private static Manager createManager(String id, String name, String surname, Gender gender, String email, String login, String password) throws IOException {
        System.out.println("Manager Type:\n1.Office Registration\n2.Departament");
        ManagerType managerType = ManagerType.convertManagerType(Integer.parseInt(br.readLine()));
        
        return new Manager(id, name, surname, gender, email, login, password, managerType);
    }
    
    private static GraduateStudent createGraduateStudent(String id, String name, String surname, Gender gender, String email, String login, String password) throws IOException {
        System.out.println("Faculty:\n1.ISE\n2.SBS\n3.SEPI\n4.SGGE\n5.SITE\n6.SNSS");
        Faculty faculty = Faculty.convertToFac(Integer.parseInt(br.readLine()));

        System.out.println("Study Degree:\n1.PHD\n2.MASTER\n3.BACHELOR");
        StudyDegree degree = StudyDegree.convertStudyDegree(Integer.parseInt(br.readLine()));

        System.out.println("Organization:\nName:\n1.OSIT\n2.BCL\n3.CRYSTALS\n4.FACES");
        OrganizationName orgName = OrganizationName.convertOrganizationName(Integer.parseInt(br.readLine()));

        System.out.println("Role in organization:\n1.Head\n2.Member");
        OrganizationRole role = OrganizationRole.convertRole(Integer.parseInt(br.readLine()));

        Organization organization = new Organization(orgName, role);

        System.out.println("Thesis Topic:");
        String thesisTopic = br.readLine();

        return new GraduateStudent(id, name, surname, gender, email, login, password, faculty, degree, organization, thesisTopic, false);
    }
    private static TechSupportSpecialist createTechSupportSpecialist(String id, String name, String surname, Gender gender, String email, String login, String password) {
        return new TechSupportSpecialist(id, name, surname, gender, email, login, password);
    }

}
