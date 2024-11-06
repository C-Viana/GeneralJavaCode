package database.application;

import java.util.List;

import database.DatabaseConnection;
import database.model.dao.DaoFactory;
import database.model.dao.DepartmentDao;
import database.model.entities.Department;

public class Program {

	public static void main(String[] args) {
		DepartmentDao ddao = DaoFactory.createDepartmentDao();
		
		Department dep1 = new Department(null, "Guns");
		ddao.insert(dep1);
		System.out.println("Added new department ID: "+dep1.getId());
		System.out.println();
		
		dep1.setName("Fishery");
		ddao.update(dep1);
		System.out.println("Updated department "+dep1.getId()+" to " + dep1.getName());
		System.out.println();
		
		Department dep2 = ddao.findById(1);
		System.out.println("Department ID 1: "+dep2.getName());
		System.out.println();
		
		ddao.deleteById(dep1.getId());
		System.out.println("Deleted department "+dep1.getId()+"? " + (ddao.findById(dep1.getId()) == null) );
		System.out.println();
		
		List<Department> deps = ddao.findAll();
		for (Department s : deps) { System.out.println(s); }
		
		DatabaseConnection.close();
		
	}

}
