package service;

import course.Course;
import enums.Faculty;
import interfaces.*;
import users.Student;

public class GraduateStudentService implements CanViewCourses, CanViewTranscript, CanViewTeachers{
	
	public static void viewCourses(Faculty faculty) {
		
	}
	public static void RegisterForCourses(Student student, Course course) {
		ManagerService.approveStudentRegistration(student, course);
	}
	public static void viewMarks(Student student) {
		student.getMarks().entrySet().stream().forEach(n->System.out.println(n.getKey().getDescription()+
				" " + MarkService.printAttestation(n.getValue())));
	}
	public static void ViewTranscript(Student student) {

	}
	public static void viewTeachers() {

	}
	
//	public static void 

}
