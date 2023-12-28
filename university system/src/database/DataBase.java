package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import additional.DiplomaProject;
import users.*;
import course.*;
import research.*;

public final class DataBase implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    private static Vector<User> users;
    private static Vector<Course> courses;
    private static Vector<DiplomaProject> diplomaProjects;
    private static DataBase db = new DataBase();
    private static User currentUser;
	private static Vector <ResearchProject> projects;


    private DataBase() {}

    public static DataBase getDb() {
        return db;
    }

    static {
        readUsers();
        readCourses();
        readDiplomaProjects();
    }

    @SuppressWarnings("unchecked")
    public static void readUsers() {
        try {
            FileInputStream fis = new FileInputStream("users.txt");
            ObjectInputStream oin = new ObjectInputStream(fis);
            users = (Vector<User>) oin.readObject();
            oin.close();
            fis.close();
        } catch (IOException e) {
            users = new Vector<>();
            System.err.println("users.txt: IOException");
        } catch (ClassNotFoundException e) {
            users = new Vector<>();
            System.err.println("users.txt: ClassNotFoundException");
        }
    }

    public static void saveUsers() {
        try {
            FileOutputStream fileOut = new FileOutputStream("users.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(users);
            out.flush();
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.err.println("users.txt: IOException");
        }
    }

    @SuppressWarnings("unchecked")
	public static void readCourses() {
        try {
            FileInputStream fis = new FileInputStream("courses.txt");
            ObjectInputStream oin = new ObjectInputStream(fis);
            courses = (Vector<Course>) oin.readObject();
            oin.close();
            fis.close();
        } catch (IOException e) {
            courses = new Vector<>();
            System.err.println("courses.txt: IOException");
        } catch (ClassNotFoundException e) {
            courses = new Vector<>();
            System.err.println("courses.txt: ClassNotFoundException");
        }
    }

    public static void saveCourses() {
        try {
            FileOutputStream fileOut = new FileOutputStream("courses.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(courses); 
            out.flush();
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.err.println("courses.txt: IOException");
        }
    }
    @SuppressWarnings("unchecked")
    public static void readDiplomaProjects() {
        try {
            FileInputStream fis = new FileInputStream("diplomaProjects.txt");
            ObjectInputStream oin = new ObjectInputStream(fis);
            diplomaProjects = (Vector<DiplomaProject>) oin.readObject();
            oin.close();
            fis.close();
        } catch (IOException e) {
            diplomaProjects = new Vector<>();
            System.err.println("diplomaProjects.txt: IOException");
        } catch (ClassNotFoundException e) {
            diplomaProjects = new Vector<>();
            System.err.println("diplomaProjects.txt: ClassNotFoundException");
        }
    }

    public static void saveDiplomaProjects() {
        try {
            FileOutputStream fileOut = new FileOutputStream("diplomaProjects.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(diplomaProjects);
            out.flush();
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.err.println("diplomaProjects.txt: IOException");
        }
    }
    @SuppressWarnings("unchecked")
	 private static void readProjects() {
			 try {
		            FileInputStream fis = new FileInputStream("projects.txt");
		            ObjectInputStream oin = new ObjectInputStream(fis); 
		            projects = (Vector<ResearchProject>) oin.readObject();
		            oin.close();
		            fis.close();
		        }
		        catch (IOException e) {
		        	projects = new Vector<>();
		            System.err.println("projects.txt: IOException");
		        }
		        catch (ClassNotFoundException e) {
		        	projects = new Vector<>();
		            System.err.println("projects.txt: ClassNotFoundException");
		        }
			
	 }
	 public static void saveProjects() {
	        try {
	            FileOutputStream fileOut = new FileOutputStream("projects.txt");
	            ObjectOutputStream out = new ObjectOutputStream(fileOut);
	            out.writeObject(users);
	            out.flush();
	            out.close();
	            fileOut.close();
	        }
	        catch (IOException e) {
	            System.err.println("courses.txt: IOException");
	        }
	    }

    
    
    
    public static Vector<DiplomaProject> getDiplomaProjects() {
        return diplomaProjects;
    }

    public static void setDiplomaProjects(Vector<DiplomaProject> diplomaProjects) {
        DataBase.diplomaProjects = diplomaProjects;
    }

    public static Vector<User> getUsers() {
        return users;
    }

    public static void setUsers(Vector<User> users) {
        DataBase.users = users;
    }

    public static Vector<Course> getCourses() {
        return courses;
    }

    public static void setCourses(Vector<Course> courses) {
        DataBase.courses = courses;
    }
    public static Vector <ResearchProject> getProjects() {
		return projects;
	}
	public static void setProject(Vector <ResearchProject> projects) {
		DataBase.projects = projects;
	}
	
	public static void setCurrentUser(User user) {
		DataBase.currentUser = user;
	}
	
	public static User getCurrentUser() {
		return currentUser;
	}
}
