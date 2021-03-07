package com.vti.backend.bussinesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.DepartmentRepository;
import com.vti.entity.Department;

public class DepartmentService implements IDepartmentService{
	DepartmentRepository departmentRepository = new DepartmentRepository();
	//accountRepository
	
		public List<Department> getAllDepartments() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException{
			List<Department> listDepartment = departmentRepository.getDepartments();
							
			
			return listDepartment;
		}

		@Override
		public Department getDepartmentById() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void createDepartment() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateDepartment() {
			// TODO Auto-generated method stub
			
		}
}
