package com.vti.fontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.Basic;
import com.vti.ultis.ScannerUtils;

public class BasicProgram {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Basic program = new Basic();

		// Question 1:
		program.connect();

		// Question 2:
		program.readDataPosition();

		// Question 3:
		System.out.println("Input name: ");
		String name = ScannerUtils.inputName();
		program.createPosition(name);

		// Question 4:
		program.updatePositionName();

		// Question 5:
		System.out.println("Input id: ");
		int id = ScannerUtils.inputId();
		program.deleteDepartmentByID(id);

		// Close connection
		program.closeConnection();

	}

}
