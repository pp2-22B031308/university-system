package service;

import java.io.BufferedReader;



import users.*;
import additional.*;
import comporators.*;
import course.*;
import database.*;
import enums.*;
import exceptions.*;
import service.*;
import system.*;
import interfaces.*;

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
