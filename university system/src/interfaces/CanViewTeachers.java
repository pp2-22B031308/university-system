package interfaces;
import users.*;
import java.util.Vector;

import database.*;

public interface CanViewTeachers {
	
	public static void viewTeachers() {
		@SuppressWarnings("unchecked")
		Vector <Teacher> t = (Vector<Teacher>)DataBase.getUsers().stream().filter(n-> n instanceof Teacher);
		t.forEach(n->System.out.println(n.getId()+" "+n.getFaculty()));
	}


}
