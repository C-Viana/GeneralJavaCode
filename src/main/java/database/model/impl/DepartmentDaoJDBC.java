package database.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import database.DbException;
import database.model.dao.DepartmentDao;
import database.model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
	
	private Connection con = null;
	
	public DepartmentDaoJDBC(Connection con) {
		this.con = con;
	}
	
	@Override
	public void insert(Department dep) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "INSERT INTO department (Name) VALUES (?)";
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dep.getName());
			
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected > 0) {
				rs = ps.getGeneratedKeys();
				if(rs.next()) {
					dep.setId(rs.getInt(1));
				}
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DatabaseConnection.closeResultSet(rs);
			DatabaseConnection.closeStatement(ps);
		}
	}
	
	@Override
	public void update(Department dep) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "UPDATE department SET Name=? WHERE Id = ?";
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dep.getName());
			ps.setInt(2, dep.getId());
			
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected > 0) {
				rs = ps.getGeneratedKeys();
				if(rs.next()) {
					dep.setId(rs.getInt(1));
				}
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DatabaseConnection.closeResultSet(rs);
			DatabaseConnection.closeStatement(ps);
		}
	}
	
	@Override
	public void deleteById(Integer id) {
		PreparedStatement ps = null;
		try {
			String query = "DELETE FROM department WHERE Id = ?";
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DatabaseConnection.closeStatement(ps);
		}
	}
	
	@Override
	public Department findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM department WHERE Id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return instantiateDepartment(rs);
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DatabaseConnection.closeResultSet(rs);
			DatabaseConnection.closeStatement(ps);
		}
	}
	
	@Override
	public List<Department> findAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Department> deps = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM department ORDER BY Name";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				deps.add( instantiateDepartment(rs) );
			}
			return deps;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DatabaseConnection.closeResultSet(rs);
			DatabaseConnection.closeStatement(ps);
		}
	}
	
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		return new Department(rs.getInt("Id"), rs.getString("Name"));
	}
	
}
