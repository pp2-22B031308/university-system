package service;

import users.*;

import database.*;
import exceptions.*;
import system.*;
import java.io.IOException;


public class AdminService {

	
	public static void addUser(int userType) throws IOException {
		saveUser(UserFactory.getInstance(userType));
	}
	
	public static void saveUser(User u) {
	    DataBase.getUsers().add(u);
	    UniversitySystem.operationMessage("New user "+u.getName()+" "+u.getSurname()+" is succssefully added");
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
