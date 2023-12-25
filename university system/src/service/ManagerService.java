package service;
import java.util.Vector;

import controller.UniversitySystem;
import model.CanViewStudents;
import model.CanViewTeachers;
import model.Course;
import model.Student;
import model.Teacher;
import repository.DataBase;

public class ManagerService implements CanViewTeachers, CanViewStudents {
	
	public static void approveStudentRegistration(Student student, Course course) {
		if(student.getCreditsTaken() <= student.getCREDITS_LIMIT() && course.getPrerequisite()==null) {
			student.getMarks().put(course, null);
			UniversitySystem.operationMessage("Student registration to" + course.getDescription() + "is added");
			}
		else UniversitySystem.operationMessage("Сredit Limit is Exceeded !");
	}
	public static void addCourseForRegistartion(Course course) {
		DataBase.getCourses().add(course);
		UniversitySystem.operationMessage("New course is added");
	}
	public static void assignCourseForTeacher(Teacher teacher,Course course) {
		teacher.getCourses().add(course);
	}
	
	public static void viewStudentInfo(Student student) {
		
	}
	public static void viewTeachers() {

	}

	
}
