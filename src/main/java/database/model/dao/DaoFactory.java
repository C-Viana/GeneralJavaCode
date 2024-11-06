package database.model.dao;

import database.DatabaseConnection;
import database.model.impl.DepartmentDaoJDBC;
import database.model.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DatabaseConnection.get());
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DatabaseConnection.get());
	}
}
