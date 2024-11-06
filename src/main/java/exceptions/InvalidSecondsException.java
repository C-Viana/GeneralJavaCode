package exceptions;

public class InvalidSecondsException extends RuntimeException {
	
	private static final long serialVersionUID = 3586344824979746980L;
	
	public InvalidSecondsException() {
		super("Invalid value for argument SECONDS. It has to be a positive number between 0 and 59.");
	}
	
	public InvalidSecondsException(String msg) {
		super(msg);
	}
	
}
