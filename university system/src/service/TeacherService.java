package service;

import java.io.BufferedReader;

import controller.UniversitySystem;
import model.CanViewCourses;
import model.CanViewStudents;
import model.Course;
import model.CourseFile;
import model.Faculty;
import model.Mark;
import model.Student;
import model.User;
import repository.DataBase;

public class TeacherService implements CanViewCourses, CanViewStudents {
	
	public static void viewCourses(Faculty faculty) {
		
	};
	
	public static void putMarks(Student student, Course course, Mark mark) {
		student.getMarks().put(course, mark);
	}
	public static void viewStudents() {
		DataBase.getUsers().stream().filter(n->(n instanceof Student)).forEach(n->System.out.println(n.getId()+" "+n.getName()+" "+n.getSurname()));
	}
	public void viewStudentInfo(Student student) {
		
	}
}
