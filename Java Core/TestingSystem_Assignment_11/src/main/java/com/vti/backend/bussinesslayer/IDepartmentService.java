package com.vti.backend.bussinesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentService {
	public List<Department> getAllDepartments()
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException ;
	
	public Department getDepartmentById() ;
	
	public void createDepartment() ;
	
	public void updateDepartment() ;
}
