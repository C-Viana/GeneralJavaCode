package exceptions;

public class InvalidYearException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidYearException() {
        super("Invalid value for argument YEAR. It has to be higher than ZERO.");
    }
	
	public InvalidYearException(String errorMessage) {
        super(errorMessage);
    }
	
	
}
