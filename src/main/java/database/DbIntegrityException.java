package database;

public class DbIntegrityException extends RuntimeException {
	
	private static final long serialVersionUID = -6860603633298156859L;
	
	public DbIntegrityException(String msg) {
		super(msg);
	}

}
