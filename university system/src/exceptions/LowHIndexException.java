package exceptions;

public class LowHIndexException extends Exception{
	private static final long serialVersionUID = 1L;
	public LowHIndexException(){
		
	}
	public LowHIndexException(String message) {
        super(message);
    }
	public  String noAccsesSupervisor() {
		return "Supervisor's h-index is less than 3";
	}

}

