package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.ultis.properties.MessageProperties;

import vti.com.ultis.JdbcUtils;

public class DepartmentRepository implements IDepartmentRepositiry{

	public List<Department> getDepartments()
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		JdbcUtils jdbcUtils  = new JdbcUtils();
		List<Department> departments = new ArrayList<>();

		// Step 2: get connection
		Connection connection = jdbcUtils.connect();

		// Step 3: Create a statement object
		Statement statement = connection.createStatement();

		// Step 4: execute query
		String sql = "SELECT * FROM Department ORDER BY DepartmentID";
		ResultSet resultSet = statement.executeQuery(sql);

		// Step 5: handling result set
		while (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt("DepartmentId"));
			department.setName(resultSet.getString("DepartmentName"));

			departments.add(department);
		}

		// disconnect
		jdbcUtils.disconnect();

		return departments;
	}

	@Override
	public List<Department> getAllDepartments()
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
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
