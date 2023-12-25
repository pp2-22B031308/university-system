package users;
import java.time.LocalDate;

public class Employee extends User {

	private LocalDate hireDate;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String id, String name, String surname, LocalDate birthDate, Gender gender, String adress, String email,
			String contactNumber, String login, String password, LocalDate hireDate) {
		super(id, name, surname, birthDate, gender, adress, email, contactNumber, login, password);
		this.hireDate = hireDate;
		// TODO Auto-generated constructor stub
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	

}
