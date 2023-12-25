package exceptions;

public class ExistUserException extends Exception{
		public  ExistUserException() {
			
		}
	    public ExistUserException(String id) {
	        super("Error! User with id" + id + "does not exist");
	    }
	    
}
