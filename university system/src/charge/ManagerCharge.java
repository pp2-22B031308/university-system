package charge;



import users.*;
import enums.*;
import research.ResearchProject;
import additional.*;

import java.util.Vector;

import course.*;
import database.*;
import system.*;

public class ManagerСharge{
	
	public static void approveStudentRegistration(Student student, Course course) {
		if(student.getCreditsTaken() <= student.getCREDITS_LIMIT() && course.getPrerequisite()==null) {
			student.getMarks().put(course, null);
			UniversityWSP.operationMessage("Student registration to" + course.getDescription() + "is added");
			}
		else UniversityWSP.operationMessage("Сredit Limit is Exceeded !");
	}
	
	public static void addCourseForRegistration(Course course) {
	    if (DataBase.getCourses().stream().anyMatch(existingCourse -> existingCourse.getId().equals(course.getId()))) {
	        UniversityWSP.operationMessage("Course with ID " + course.getId() + " already exists. Choose a different ID.");
	        return;
	    }
	    DataBase.getCourses().add(course);
	    UniversityWSP.operationMessage("New course " + course.getName() + " is successfully added");
	}

	public static void assignCourseForTeacher(Teacher teacher, Course course) {
	    if (teacher != null && course != null) {
	        if (teacher.getCourses() == null) {
	            teacher.setCourses(new Vector<>());
	        }
	        teacher.getCourses().add(course);
	        UniversityWSP.operationMessage("Course " + course.getId() + " assigned to teacher " + teacher.getId());
	    } else {
	        UniversityWSP.operationMessage("Invalid Teacher or Course.");
	    }
	}

	
	
	public static void viewStudentInfo(Student student) {
	    if (student != null) {
	        System.out.println("Student Information:");
	        System.out.println("ID: " + student.getId());
	        System.out.println("Name: " + student.getName());
	        System.out.println("Surname: " + student.getSurname());
	        System.out.println("Gender: " + student.getGender());
	        System.out.println("Email: " + student.getEmail());
	        System.out.println("Faculty: " + student.getFaculty());
	        System.out.println("Credits Taken: " + student.getCreditsTaken());
	        System.out.println("Courses Enrolled:");
	        for (Course course : student.getMarks().keySet()) {
	            System.out.println("   " + course.getName() + ": " + student.getMarks().get(course));
	        }
	        System.out.println("-------------------------");
	    } else {
	        System.out.println("Student not found.");
	    }
	}

	
	
	
	public static void viewTeachers() {
	    System.out.println("List of Teachers:");
	    for (User user : DataBase.getUsers()) {
	        if (user instanceof Teacher) {
	            Teacher teacher = (Teacher) user;
	            System.out.println("ID: " + teacher.getId());
	            System.out.println("Name: " + teacher.getName());
	            System.out.println("Surname: " + teacher.getSurname());
	            System.out.println("Faculty: " + teacher.getFaculty());
	            System.out.println("Teacher Type: " + teacher.getTeacherType());
	            System.out.println("Courses Taught: " + teacher.getCourses());
	            System.out.println("-------------------------");
	        }
	    }
	}

	
	public static void viewCourses() {
	    System.out.println("All available courses:");
	    DataBase.getCourses().forEach(course -> System.out.println(course.getId() + ": " + course.getName()));
	}
	
	
	public static void receiveTechSupportRequest(Manager manager, TechSupportSpecialist techSupportSpecialist, Order order) {
        System.out.println("Manager " + manager.getName() + " received a tech support request from " +
                techSupportSpecialist.getName() + ". Order Details: " + order.toString());
        order.setStatus(OrderStatus.PROCESSING);
        System.out.println("Order processing started...");
    }
public static void assignProjectForResearcher(Researcher researcher, ResearchProject project) {}
}
