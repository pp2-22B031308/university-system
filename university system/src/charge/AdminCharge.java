package charge;

import users.*;


import java.io.IOException;

import database.*;
import exceptions.*;
import system.*;
import additional.*;
public class AdminСharge {

	public static void addUser(int userType) throws IOException {
	    User newUser = UserFactory.getInstance(userType);
	    saveUser(newUser);
	    LogFile.log("User added", newUser.getId());
	}

    public static void saveUser(User u) {
        DataBase.getUsers().add(u);
        UniversityWSP.operationMessage("New user " + u.getName() + " " + u.getSurname() + " is successfully added");
    }

    public static void deleteUser(String id) {
        try {
            DataBase.getUsers().removeIf(user -> (user.getId().equals(id)));
            UniversityWSP.operationMessage("User with " + id + "is removed from the System");
            throw new ExistUserException();
        } catch (ExistUserException e) {
            UniversityWSP.operationMessage("Error");
        }
    }

    public static void viewUsers() {
        DataBase.getUsers().stream().forEach(n -> System.out.println(n.getId() + " " + n.getName() + " " + n.getSurname()));
    }
    
    public static void viewLogs() {
        LogFile.viewLogs();
    }
}
