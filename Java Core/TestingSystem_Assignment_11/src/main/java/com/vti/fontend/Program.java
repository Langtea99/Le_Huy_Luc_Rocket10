package com.vti.fontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.DepartmentController;
import com.vti.entity.Department;

public class Program {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		DepartmentController depart = new DepartmentController();
        List<Department> listDepartment = depart.getAllDepartments();
        for (Department department : listDepartment) {
			System.out.println(department);
		}
	}

}
