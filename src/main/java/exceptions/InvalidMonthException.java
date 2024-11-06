package exceptions;

public class InvalidMonthException extends RuntimeException {
	
	private static final long serialVersionUID = -990315353460049624L;
	
	public InvalidMonthException() {
        super("Invalid value for argument MONTH. It has to be a positive number between 1 and 12.");
    }
	
	public InvalidMonthException(String errorMessage) {
        super(errorMessage);
    }
	
}
