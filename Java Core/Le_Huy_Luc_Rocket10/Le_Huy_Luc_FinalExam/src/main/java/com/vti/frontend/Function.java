package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.Utils.ScannerUtils;
import com.vti.backend.presentation.UserController;
import com.vti.entity.User;

public class Function {

	private UserController userController;

	public Function() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userController = new UserController();
	}

	public void getListManagerOfUsers() throws Exception {
		List<User> users = userController.getListManagerOfUsers();
		System.out.printf("%-15s %-25s %-25s %-25s\n", "ID", "Email", "Fullname", "Password");
		for (User user : users) {
			System.out.printf("%-15s %-25s %-25s %-25s\n", user.getId(), user.getEmail(), user.getFullName(),
					"*********");
		}
	}

	public void getUserByProjectId() throws Exception {
		while (true) {
			System.out.print("Mời bạn nhập vào id: ");
			int projectId = ScannerUtils.inputInt("Bạn phải nhập vào số nguyên dương! Mời nhập lại");

			if (userController.getUserByProjectId(projectId) != null) {
				System.out.println(userController.getUserByProjectId(projectId));
				return;
			} else {
				System.err.println("id khong ton tai! Vui long nhap lai! ");
			}
		}
	}

}
