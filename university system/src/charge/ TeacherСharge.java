package charge;

import users.*;
import additional.*;
import course.*;
import database.*;
import enums.*;

public class TeacherСharge {
	
	public static void viewCourses(Faculty faculty) {
	    System.out.println("Available courses for " + faculty + ":");
	    DataBase.getCourses().forEach(course -> System.out.println(course.getId() + ": " + course.getName()));
	}
	
	public static void putMarks(Student student, Course course, Mark mark) {
		student.getMarks().put(course, mark);
	}
	
	public static void viewStudents() {
		DataBase.getUsers().stream().filter(n->(n instanceof Student)).forEach(n->System.out.println(n.getId()+" "+n.getName()+" "+n.getSurname()));
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
	
	public static Complaint sendComplaint(Teacher teacher, Student student, UrgencyLevel urgency, String details) {
        System.out.println("Teacher " + teacher.getName() + " is sending a complaint to student " + student.getName() +
                " with urgency level: " + urgency);

        Complaint newComplaint = new Complaint(teacher, student, urgency, details);
        StudentСharge.receiveComplaint(student, newComplaint);
        return newComplaint;
    }
}
