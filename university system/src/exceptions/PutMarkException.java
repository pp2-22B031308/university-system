package exceptions;

public class PutMarkException extends Exception{
	
	public PutMarkException(){
		
	}
	
	public  String noAccsesCourseMessage() {
		return "You cannot put mark to this course!";
	}
	public String NoCourses() {
		return "There are no courses to put mark!";
	}
}
