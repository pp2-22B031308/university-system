package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Vector;

import model.Course;
import model.Employee;
import model.Mark;
import model.Student;
import model.User;

//import streams.User;

public final class DataBase implements Serializable, Cloneable{
	
	private static Vector <User> users;
	private static Vector <Course> courses;
	private static DataBase db = new DataBase();
	private DataBase() {
	
	}
	public static DataBase getDb() {
		return db;
	}
 	
	static {
		readUsers();
		readCourses();
	}
	 @SuppressWarnings("unchecked")
	    public static void readUsers() {
	        try {
	            FileInputStream fis = new FileInputStream("users.txt");
	            ObjectInputStream oin = new ObjectInputStream(fis); 
	            users = (Vector<User>) oin.readObject();
	            oin.close();
	            fis.close();
	        }
	        catch (IOException e) {
	            users = new Vector<>();
	            System.err.println("users.txt: IOException");
	        }
	        catch (ClassNotFoundException e) {
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
	        }
	        catch (IOException e) {
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
	        }
	        catch (IOException e) {
	            users = new Vector<>();
	            System.err.println("courses.txt: IOException");
	        }
	        catch (ClassNotFoundException e) {
	            users = new Vector<>();
	            System.err.println("courses.txt: ClassNotFoundException");
	        }
	    }

	 public static void saveCourses() {
	        try {
	            FileOutputStream fileOut = new FileOutputStream("courses.txt");
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
		public static Vector<User> getUsers() {
			return users;
		}
		public static void setUsers(Vector <User> users) {
			DataBase.users = users;
		}
		public static Vector <Course> getCourses() {
			return courses;
		}
		public static void setCourses(Vector <Course> courses) {
			DataBase.courses = courses;
		}

}