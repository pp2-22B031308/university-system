package users;

import users.*;
import additional.*;
import comporators.*;
import course.*;
import database.*;
import enums.*;
import exceptions.*;
import service.*;
import system.*;
import java.time.LocalDate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.stream.Collectors;

public class Student extends User implements Comparable<Student>{

	private static final long serialVersionUID = 1L;
	private Faculty faculty;
	private StudyDegree degree;
	private Organization organization;
	private double gpa;
	private HashMap<Course, Mark > marks;
	private int creditsTaken;
	private final int CREDITS_LIMIT = 23;

	
	public Student() {
		gpa = 0.0;
	}

	public Student(String id, String name, String surname, LocalDate birthDate, Gender gender, String adress, String email,
			String contactNumber, String login, String password,Faculty faculty,  StudyDegree degree,
		Organization organization) {
		super(id, name, surname, birthDate, gender, adress, email, contactNumber, login, password);
		this.faculty = faculty;
		this.degree = degree;
		this.organization = organization;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public StudyDegree getDegree() {
		return degree;
	}
	public void setDegree(StudyDegree degree) {
		this.degree = degree;
	}

	public int getCreditsTaken() {
		return creditsTaken;
	}
	public void setCreditsTaken(int creditsTaken) {
		this.creditsTaken = creditsTaken;
	}

	public int getCREDITS_LIMIT() {
		return CREDITS_LIMIT;
	}
	public HashMap<Course, Mark > getMarks() {
		return marks;
	}

	public void setMarks(HashMap<Course, Mark > marks) {
		this.marks = marks;
	}
//
//	public Vector<GradeBook> getTranscript() {
//		return transcript;
//	}
//
//	public void setTranscript(Vector<GradeBook> transcript) {
//		this.transcript = transcript;
//	}
	@Override
	public int hashCode() {
		super.hashCode();
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash( degree, faculty, gpa, organization);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		super.equals(obj);
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return degree == other.degree && faculty == other.faculty
				&& Double.doubleToLongBits(gpa) == Double.doubleToLongBits(other.gpa)
				&& organization == other.organization;
	}
	@Override
	public String toString() {
		return "Student [faculty=" + faculty + ", organization=" + organization + ", gpa=" + gpa + ", degree=" + degree + "," +
	super.toString()+ "]";
	}
	
	@Override
	public int compareTo(Student other) {
		return getId().compareTo(other.getId());
	}

//	public void registerForCourse(String cou) {
//		
//		Vector<Course> courses= new Vector<Course>();
//		
//		System.out.println(courses);
//		
//		System.out.println("register for the coureses");
//		
//		StringTokenizer co= new StringTokenizer(cou, ",");
//		String id= co.nextToken();
//		String name= co.nextToken();
//		
//		int sumCredit=0;
//		for(int i=0; i<studentCourses.size(); i++) {
//			sumCredit+= courses.get(i).getNumOfCredit();
//		}
//		
//		
//		for(int i=0; i<courses.size(); i++) {
//			if(id.equals(courses.get(i).getId())&& name.equals(courses.get(i).getName())) {
//				if(courses.get(i).getPrerequisite()== null) {
//					if(sumCredit<21) {
//				studentCourses.add(courses.get(i));
//				}else {
//					System.out.println("you can only take 21 credit per semester");
//				}
//				}
//				else if(courses.get(i).getPrerequisite()==studentCourses.get(i)) {
//					studentCourses.add(courses.get(i));
//					
//				}
//				else if(courses.get(i).getId()==studentCourses.get(i).getId()) {
//					System.out.println("you already took this course");
//					
//				}
//				else {
//					System.out.println("you cannot take this course");
//				}
//				
//			}
//
//			System.out.println(studentCourses);
//					
//			}
//		
//	}
//	public void viewCourses(Course cou) {
//	Vector<Course> Studentcourses= new Vector<Course>();
//	Vector<Course> viewCourses= Studentcourses.stream()
//			.collect(Collectors.toCollection(Vector::new));
//	
//	viewCourses.forEach(System.out::println);
//		
//	}
//	
//	public void viewMarks() {
//		
//		GradeBook grade= new GradeBook();
//			Vector<Course> courses= new Vector<Course>();
//			
//			HashMap<GradeBook, Mark> mark= new HashMap<GradeBook, Mark>();
//			
//			
//			
//			for(int i=0; i<studentCourses.size(); i++) {
//				try {
//					if(grade.getStudent()== this) {
//						System.out.println(mark);	
//					}
//					else {
//						System.out.println("you don't have this course");
//					}
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}

	
}
