package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConnection {
	/**
	 * postgres@localhost:5432
	 * postgres:1234
	 * 
	 * mysql@localhost:3306
	 * root:Root#135
	 * 
	 * ecomtraining
	 */
	
	private static Connection conn = null;
	
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/SQL/db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static Connection get() {
		if(conn == null) {
			Properties props = loadProperties();
			try {
				conn = DriverManager.getConnection(props.getProperty("dburl"), props);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	public static void close() {
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		conn = null;
	}
	
	public static void closeStatement(Statement st) {
		try {
			if(st != null)
				st.close();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	
}
