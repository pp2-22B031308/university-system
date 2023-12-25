package users;
import enums.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Vector;

public abstract class User implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private String id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private Gender gender;
    private String adress;
    private String email;
    private String contactNumber;
    private String login;
    private String password; 
  
    public User() {
    	
    }
	public User(String id, String name, String surname, LocalDate birthDate, Gender gender, String adress, String email,String contactNumber, String login, String password) {

		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.gender = gender;
		this.adress = adress;
		this.email = email;
		this.contactNumber = contactNumber;
		this.login = login;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;	
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(adress, birthDate, contactNumber, email, gender, id, login, name, password, surname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(adress, other.adress)
				&& Objects.equals(contactNumber, other.contactNumber) && Objects.equals(email, other.email)
				&& gender == other.gender && Objects.equals(id, other.id) && Objects.equals(login, other.login)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(surname, other.surname);
	}
	@Override
	public String toString() {
		return "User [Id=" + getId() + ", Name=" + getName() + ", Surname=" + getSurname()
				+ ", Age()=" + getBirthDate() + ", Gender()=" + getGender() + ", Adress()=" + getAdress()
				+ ", Email()=" + getEmail() + "ContactNumber()=" + getContactNumber() + ", Login()="
				+ getLogin() + ", Password()=" + getPassword() + "]";
	}
	public Object clone() throws CloneNotSupportedException {
		User u = (User)super.clone();
		return u;
		
	}
	

    
}
