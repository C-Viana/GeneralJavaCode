package exceptions;


public class InvalidHourException extends RuntimeException {
	
	private static final long serialVersionUID = -3157537966062529940L;

	public InvalidHourException() {
		super("Invalid value for argument HOUR. It has to be a positive number between 0 and 23.");
	}
	
	public InvalidHourException(String msg) {
		super(msg);
	}

}
