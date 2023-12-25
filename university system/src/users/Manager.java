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

public class Manager extends Employee {
	private static final long serialVersionUID = 1L;
	private ManagerType managerType;
	public Manager() {
		super();
	}
	
	
	public Manager(String id, String name, String surname, LocalDate birthDate, Gender gender, String adress, String email,
			String contactNumber, String login, String password,LocalDate hireDate, ManagerType managerType) {
		super(id, name, surname, birthDate, gender, adress, email, contactNumber, login, password, hireDate);
		this.managerType = managerType;
		// TODO Auto-generated constructor stub
	}
	public ManagerType getManagerType() {
		return managerType;
	}

	public void setManagerType(ManagerType managerType) {
		this.managerType = managerType;
	}
	
	@Override
	public String toString() {
		return "Manager [managerType=" + managerType + ", toString()=" + super.toString() + "]";
	}

	
}
