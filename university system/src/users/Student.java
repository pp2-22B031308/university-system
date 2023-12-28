package users;

import additional.*;
import course.*;
import enums.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Student extends User implements Comparable<Student> {

    private static final long serialVersionUID = 1L;
    private Faculty faculty;
    private StudyDegree degree;
    private Organization organization;
    private double gpa;
    private HashMap<Course, Mark> marks;
    private int creditsTaken;
    private final int CREDITS_LIMIT = 23;
	private List<Complaint> complaints;

	

    public Student() {
        gpa = 0.0;
        marks = new HashMap<>();
        complaints = new ArrayList<>();
    }

    public Student(String id, String name, String surname, Gender gender, String email, String login,
                   String password, Faculty faculty, StudyDegree degree, Organization organization) {
        super(id, name, surname, gender, email, login, password);
        this.faculty = faculty;
        this.degree = degree;
        this.organization = organization;
        this.complaints = new ArrayList<>();
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

    public HashMap<Course, Mark> getMarks() {
        return marks;
    }

    public void setMarks(HashMap<Course, Mark> marks) {
        this.marks = marks;
    }
    public List<Complaint> getComplaints() {
	    return complaints;
	}
    
    @Override
    public int hashCode() {
        return Objects.hash(degree, faculty, gpa, organization);
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
        return "Student [faculty=" + faculty + ", organization=" + organization + ", gpa=" + gpa + ", degree=" + degree + ","
                + super.toString() + "]";
    }

    @Override
    public int compareTo(Student other) {
        return getId().compareTo(other.getId());
    }
    
    public void addComplaint(Complaint complaint) {
        complaints.add(complaint);
    }
	
	public void receiveComplaint(Complaint newComplaint) {
	    System.out.println("Student " + this.getName() + " received a complaint from teacher " +
	            newComplaint.getTeacher().getName() + " with urgency level: " + newComplaint.getUrgency());

	    
	    addComplaint(newComplaint);
	}
    
}
