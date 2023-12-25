package interfaces;

import database.*;
import enums.*;

public interface CanViewCourses {
	public static void viewCourses(Faculty faculty) {
		DataBase.getCourses().stream().filter(n->n.getFaculty()==faculty).forEach(n->System.out.println(n.getId()+" "+n.getDescription()+" "+n.getName()));
	}
}
