package exceptions;

public class InvalidDayException extends RuntimeException {
	
	private static final long serialVersionUID = 1506962073934193502L;
	
	public InvalidDayException() {
        super("Invalid value for argument DAY. It has to be a positive number between 1 and 31.");
    }
	
	public InvalidDayException(String errorMessage) {
        super(errorMessage);
    }
	
}
