package users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import users.*;
import additional.*;
import comporators.*;
import course.*;
import database.*;
import enums.*;
import exceptions.*;
import service.*;
import system.*;

public class UserFactory {
	public static User getInstance(int type) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("ID(must include 'BD' if student, 'T' if teacher, 'M' if Manager):");
	    String id = br.readLine();
	    System.out.println("Name:");
	    String name = br.readLine();
	    System.out.println("Surname:");
	    String surname = br.readLine();
	    System.out.println("Enter a Birthday\nYear(like 2017):");
	    int y = Integer.parseInt(br.readLine());
	    System.out.println("Month (1-12):");
	    int m = Integer.parseInt(br.readLine());
	    System.out.println("Day(1-31):");
	    int d  = Integer.parseInt(br.readLine());
	    LocalDate birthDate = LocalDate.of(y,m,d);
	    System.out.println("Gender:\n1.Male\n2.Female\n3.Undefined");
	    Gender gender = Gender.convertGen(Integer.parseInt(br.readLine()));
	    System.out.println("Adress:");
	    String adress = br.readLine();
	    System.out.println("Email:");
	    String email = br.readLine();
	    System.out.println("Contact Number:");
	    String number = br.readLine();
	    System.out.println("Login:");
	    String login = br.readLine();
	    System.out.println("Temp password:");
	    String password = br.readLine();
		switch(type) {
		case 1:
		    System.out.println("Faculty:\n1.ISE\n2.SBS\n3.SEPI\n4.SGGE\n5.SITE\n6.SNSS");
		    Faculty faculty = Faculty.convertToFac(Integer.parseInt(br.readLine()));
		    System.out.println("Study Degree:\n1.PHD\n2.MASTER\n3.BACHELOR");
		    StudyDegree degree = StudyDegree.convertStudyDegree(Integer.parseInt(br.readLine()));
		    System.out.println("Tuition Type:\n1.Grant\n2.Paid");
			TuitionType tuitionType = TuitionType.convertTuitionType(Integer.parseInt(br.readLine()));
			System.out.println("Organization:\nName:\n1.OSIT\n2.BCL\n3.CRYSTALS\n4.MONTAIN KINGS");
		    OrganizationName orgName = OrganizationName.convertOrganizationName(Integer.parseInt(br.readLine()));
		    System.out.println("Role in organization:\n1.Head\n2.Member");
		    Role role = Role.convertRole(Integer.parseInt(br.readLine()));
			Organization org = new Organization(orgName, role );
		    return new Student(id, name, surname, birthDate, gender, adress, email, number, login, password, faculty, degree, tuitionType, org);
		case 2:
		    System.out.println("Enter a hiredate\nYear(like 2017):");
		    y = Integer.parseInt(br.readLine());
		    System.out.println("Month (1-12):");
		    m = Integer.parseInt(br.readLine());
		    System.out.println("Day(1-31):");
		    d  = Integer.parseInt(br.readLine());
		    LocalDate hireDate = LocalDate.of(y,m,d);
		    System.out.println("Faculty:\n1.ISE\n2.SBS\n3.SEPI\n4.SGGE\n5.SITE\n6.SNSS");
		    faculty = Faculty.convertToFac(Integer.parseInt(br.readLine()));
		    System.out.println("Teacher Type:\n1.Professor\n2.Assosiate Professor\n3.Senior Lecturer\n4.Lecturer\n5.Teaching Assistent\n6.Tutor\n7.Assistent Professor");
			TeacherType teacherType = TeacherType.convertTeacherType(Integer.parseInt(br.readLine()));
			return new Teacher(id, name, surname, birthDate, gender, adress, email, number, login, password,hireDate, faculty, teacherType);
		case 3:
		    System.out.println("Enter a hiredate\nYear(like 2017):");
		    y = Integer.parseInt(br.readLine());
		    System.out.println("Month (1-12):");
		    m = Integer.parseInt(br.readLine());
		    System.out.println("Day(1-31):");
		    d  = Integer.parseInt(br.readLine());
		    hireDate = LocalDate.of(y,m,d);
		    System.out.println("Manager Type:\n1.Office Registration\n2.Departament");
		    ManagerType managerType = ManagerType.convertManagerType(Integer.parseInt(br.readLine()));
		   return new Manager(id, name, surname, birthDate, gender, adress, email, number, login, password,hireDate, managerType);
		}
		return null;
	}
	
	public static String createUpdatedUser(User u) throws NumberFormatException, IOException {
		System.out.println("UserFactory");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Update:\n1.Name\n2.Surname\n3.Password\n4.Email\n5.Number\n6.Adress\n7.Login");
		System.out.println("Enter:");
		switch(Integer.parseInt(br.readLine())) {
		case 1:
			u.setName(br.readLine());
			return "Name of user with " + u.getId() +" is updated to"+u.getName();
		case 2:
			u.setSurname(br.readLine());
			return "Surname of user with " + u.getId() +" is updated to"+u.getSurname();
		case 3:
			u.setPassword(br.readLine());
			return "Password of user with " + u.getId() +" is updated to"+u.getPassword();
		case 4:
			u.setEmail(br.readLine());
			return "Email of user with " + u.getId() +" is updated to"+u.getEmail();
		case 5:
			u.setContactNumber(br.readLine());
			return "Number of user with " + u.getId() +" is updated to"+u.getContactNumber();
		case 6:
			u.setAdress(br.readLine());
			return "Adress of user with " + u.getId() +" is updated to"+u.getAdress();
		}
		u.setLogin(br.readLine());
		return "Login of user with " + u.getId() +" is updated to"+u.getLogin();
	}
}
