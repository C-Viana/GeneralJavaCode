package database;

public class DbException extends RuntimeException {

	private static final long serialVersionUID = -5492110431988383948L;
	
	public DbException(String msg) {
		super(msg);
	}

}
