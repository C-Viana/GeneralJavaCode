package exceptions;

public class InvalidMinutesException extends RuntimeException {
	
	private static final long serialVersionUID = -7811743697903753961L;
	
	public InvalidMinutesException() {
		super("Invalid value for argument MINUTES. It has to be a positive number between 0 and 59.");
	}
	
	public InvalidMinutesException(String msg) {
		super(msg);
	}
	
}
