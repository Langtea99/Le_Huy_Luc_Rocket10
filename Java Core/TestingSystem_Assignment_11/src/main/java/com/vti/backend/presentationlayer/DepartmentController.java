package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.bussinesslayer.DepartmentService;
import com.vti.backend.datalayer.DepartmentRepository;
import com.vti.entity.Department;

public class DepartmentController {
	DepartmentService departmentService = new DepartmentService();
	//accountRepository
	
		public List<Department> getAllDepartments() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException{
			List<Department> listDepartment = departmentService.getAllDepartments();
							
			
			return listDepartment;
		}
}
