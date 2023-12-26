package users;

import java.time.LocalDate;

import additional.Organization;
import enums.*;
import exceptions.*;

public class GraduateStudent extends Student {
	//fields
	private static final long serialVersionUID = 1L;
	private StudentType studentType;
	private Researcher supervisor;
	
	//constructors
	public GraduateStudent() {
		super();
	}
	public GraduateStudent(String id, String name, String surname, LocalDate birthDate, Gender gender, String adress,
			String email, String contactNumber, String login, String password, Faculty faculty, StudyDegree degree,
			Organization organization) {
		super(id, name, surname, birthDate, gender, adress, email, contactNumber, login, password, faculty, degree,
				organization);
		// TODO Auto-generated constructor stub
	}
	public GraduateStudent(StudentType studentType, Researcher supervisor) throws LowHIndexException {
		if (supervisor.gethIndex() < 3) {
            throw new LowHIndexException("Supervisor's h-index is less than 3");
        }
		this.studentType = studentType;
		this.supervisor = supervisor;
	}
	
	//getters and setters
	public StudentType getStudentType() {
		return studentType;
	}
	public void setStudentType(StudentType studentType) {
		this.studentType = studentType;
	}
	public Researcher getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Researcher supervisor) {
		this.supervisor = supervisor;
	}
	
	
	
	
	

}
