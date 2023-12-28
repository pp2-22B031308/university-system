package users;

import enums.*;
public class Employee extends User {

	private static final long serialVersionUID = 1L;

	public Employee() {
		super();
	}
	
	public Employee(String id, String name, String surname, Gender gender, String email,
			String login, String password) {
		super(id, name, surname, gender, email, login, password);
	}
}
