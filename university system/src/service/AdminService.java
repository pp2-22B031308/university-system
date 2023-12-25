package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Optional;
import java.util.StringTokenizer;

import controller.EnrollException;
import controller.ExistUserException;
import controller.UniversitySystem;
import model.Faculty;
import model.Gender;
import model.Manager;
import model.ManagerType;
import model.Organization;
import model.OrganizationName;
import model.Role;
import model.Student;
import model.StudyDegree;
import model.SuperAdmin;
import model.Teacher;
import model.TeacherType;
import model.TuitionType;
import model.User;
import repository.DataBase;

public class AdminService {

	
	public static void addUser(int userType) throws IOException {
		saveUser(UserFactory.getInstance(userType));
	}
	
	public static void saveUser(User u) {
	    DataBase.getUsers().add(u);
	    UniversitySystem.operationMessage("New user "+u.getName()+" "+u.getSurname()+" is succssefully added");
	}
	public static String updateUser(String id) throws NumberFormatException, IOException {
			return UserFactory.createUpdatedUser(DataBase.getUsers().stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null));
		}
		
	public static void deleteUser(String id) {
		try {
			DataBase.getUsers().removeIf(user -> (user.getId().equals(id))); 
			UniversitySystem.operationMessage("User with " + id + "is removed from the System");
		    throw new ExistUserException(); 
		}
		catch(ExistUserException e) {
			UniversitySystem.operationMessage("Error");
		}
	}
	public static void viewUsers() {
		 DataBase.getUsers().stream().forEach(n->System.out.println(n.getId()+ " " +n.getName()+" "+n.getSurname()));
	}
}
;