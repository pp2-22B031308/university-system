package service;

import users.*;

import additional.*;
import comporators.*;
import course.*;
import database.*;
import enums.*;
import exceptions.*;
import service.*;
import system.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Optional;
import java.util.StringTokenizer;


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
