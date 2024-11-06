import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DatabaseConnection;
import database.DbException;
import database.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
//		new Program().setDiscount();
		String path = System.getProperty("user.dir")+"\\src\\gui\\MainView.fxml";
		path.replaceAll("^\\", "/");
		System.out.println(path);
		System.out.println(System.getProperty("user.dir"));
		System.out.println(new File("/JavaFXproject/src/gui/MainView.fxml").getPath());
	}
	
	public void getProducts() {
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM product ";
			st = DatabaseConnection.get().createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getInt(5) + "\t" + rs.getDouble(6));
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DatabaseConnection.closeResultSet(rs);
			DatabaseConnection.closeStatement(st);
			DatabaseConnection.close();
		}
	}
	
	public void saveProduct() {
		PreparedStatement ps = null;
		try {
			String query = "INSERT INTO product (name, brand, description, quantity, price) VALUES (?, ?, ?, ?, ?)";
			ps = DatabaseConnection.get().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, "GeForce RTX 4080");
			ps.setString(2, "NVIDIA");
			ps.setString(3, "Arquitetura NVIDIA Ada Lovelace.");
			ps.setInt(4, 10);
			ps.setDouble(5, 9899.99);
			
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				while(rs.next()) {
					System.out.println("Done! Product "+rs.getInt(2)+" saved with ID " + rs.getInt(1));
				}
			}
			else {
				System.out.println("No rows affected");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DatabaseConnection.closeStatement(ps);
			DatabaseConnection.close();
		}
	}
	
	public void updateProductName(String newName, int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "UPDATE product SET name=? WHERE id=?";
			ps = DatabaseConnection.get().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, newName);
			ps.setInt(2, id);
			
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected > 0) {
				System.out.println(rowsAffected + " rows updated.");
			}
			else {
				System.out.println("No rows affected");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DatabaseConnection.closeResultSet(rs);
			DatabaseConnection.closeStatement(ps);
			DatabaseConnection.close();
		}
	}
	
	public void deleteProduct(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "DELETE FROM product WHERE id=?";
			ps = DatabaseConnection.get().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, id);
			
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected > 0) {
				System.out.println(rowsAffected + " rows deleted.");
			}
			else {
				System.out.println("No rows affected");
			}
			
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DatabaseConnection.closeResultSet(rs);
			DatabaseConnection.closeStatement(ps);
			DatabaseConnection.close();
		}
	}
	
	public void setDiscount() {
		Statement st = null;
		ResultSet rs = null;
		try {
			DatabaseConnection.get().setAutoCommit(false);
			
			String query1 = "UPDATE product SET price=price-(price * (5/100)) WHERE id=1";
			String query2 = "UPDATE product SET price=price-(price * (8/100)) WHERE id=2";
			
			st = DatabaseConnection.get().createStatement();
			st.executeUpdate(query1);
			st.executeUpdate(query2);
			
			DatabaseConnection.get().commit();
			
		} catch (SQLException e) {
			try {
				DatabaseConnection.get().rollback();
				throw new DbException("Transaction rolled back!\nCaused by: "+e.getMessage());
			} catch (SQLException e1) {
				System.out.println("Error trying to rollback!\nCaused by: "+e1.getMessage());
			}
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DatabaseConnection.closeResultSet(rs);
			DatabaseConnection.closeStatement(st);
			DatabaseConnection.close();
		}
	}

}
