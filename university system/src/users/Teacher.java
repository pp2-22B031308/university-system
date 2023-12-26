package users;

import java.util.Objects;
import java.util.Vector;
import course.*;
import enums.*;
import additional.*;

public class Teacher extends Employee {
    private static final long serialVersionUID = 1L;
    private Faculty faculty;
    private TeacherType teacherType;
    private Vector<Course> courses;

    public Teacher() {
        super();
    }

    public Teacher(String id, String name, String surname, Gender gender, String email,
                   String login, String password, Faculty faculty, TeacherType teacherType) {
        super(id, name, surname, gender, email, login, password);
        this.faculty = faculty;
        this.teacherType = teacherType;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public TeacherType getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(TeacherType teacherType) {
        this.teacherType = teacherType;
    }

    public Vector<Course> getCourses() {
        return courses;
    }

    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, teacherType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Teacher other = (Teacher) obj;
        return Objects.equals(faculty, other.faculty) && teacherType == other.teacherType;
    }

    @Override
    public String toString() {
        return "Teacher [faculty=" + faculty + ", teacherType=" + teacherType + ", toString()=" + super.toString() + "]";
    }
    
    public Complaint sendComplaint(Student student, UrgencyLevel urgency, String details) {
	    System.out.println("Teacher " + this.getName() + " is sending a complaint to student " + student.getName() +
	            " with urgency level: " + urgency);

	    Complaint newComplaint = new Complaint(this, student, urgency, details);
	    student.receiveComplaint(newComplaint);
	    return newComplaint;
	}
}
