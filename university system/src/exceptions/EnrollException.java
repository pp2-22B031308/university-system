package exceptions;

public class ExistUserException extends Exception{

	private static final long serialVersionUID = 1L;
		public  ExistUserException() {
			
		}
	    public ExistUserException(String id) {
	        super("Error! User with id" + id + "does not exist");
	    }
	    
}
