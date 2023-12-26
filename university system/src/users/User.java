package users;

import enums.*;

import java.io.Serializable;
import java.util.Objects;

public abstract class User implements Serializable, Cloneable, CanBecomeResearcher{

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String surname;
    private Gender gender;
    private String email;
    private String login;
    private String password;
    private Researcher<User> researcher;


    public User() {}

    public User(String id, String name, String surname, Gender gender, String email, String login, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.email = email;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
  //researcher
    public void becomeResearcher() {
        this.researcher = new Researcher<>();
    }

    public boolean isResearcher() {
        return this.researcher != null;
    }

    public Researcher<User> getResearcher() {
        return this.researcher;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, gender, id, login, name, password, surname);
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
        return Objects.equals(email, other.email)
                && gender == other.gender && Objects.equals(id, other.id) && Objects.equals(login, other.login)
                && Objects.equals(name, other.name) && Objects.equals(password, other.password)
                && Objects.equals(surname, other.surname);
    }

    @Override
    public String toString() {
        return "User [Id=" + getId() + ", Name=" + getName() + ", Surname=" + getSurname()
                + ", Gender=" + getGender() + ", Email=" + getEmail() + ", Login=" + getLogin() +
                ", Password=" + getPassword() + "]";
    }

    public Object clone() throws CloneNotSupportedException {
        User u = (User) super.clone();
        return u;
    }
}
