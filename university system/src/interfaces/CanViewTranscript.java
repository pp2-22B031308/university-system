package interfaces;

import service.*;
import users.*;

public interface CanViewTranscript {
	public static void ViewTranscript(Student student) {
		student.getMarks().entrySet().stream().forEach(n->System.out.println(n.getKey().getDescription()+" "+MarkService.printTranscaript(n.getValue())));
	}
}
