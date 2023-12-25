package service;

import java.util.Vector;

import controller.UniversitySystem;
import model.CanViewCourses;
import model.CanViewTeachers;
import model.CanViewTranscript;
import model.Course;
import model.Faculty;
import model.Student;
import model.Teacher;
import repository.DataBase;

public class StudentService implements CanViewCourses, CanViewTranscript, CanViewTeachers{

	public static void viewCourses(Faculty faculty) {};
	public static void RegisterForCourses(Student student, Course course) {
		ManagerService.approveStudentRegistration(student, course);
	}
	public static void viewMarks(Student student) {
		student.getMarks().entrySet().stream().forEach(n->System.out.println(n.getKey().getDescription()+" " + MarkService.printAttestation(n.getValue())));
	}
	
	public static void ViewTranscript(Student student) {

	}
	public static void viewTeachers() {

	}
}
