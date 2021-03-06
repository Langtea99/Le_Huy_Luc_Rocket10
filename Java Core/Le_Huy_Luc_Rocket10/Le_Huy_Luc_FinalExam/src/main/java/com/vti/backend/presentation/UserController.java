package com.vti.backend.presentation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.bussinesslayer.IUserService;
import com.vti.backend.bussinesslayer.UserService;
import com.vti.entity.Project;
import com.vti.entity.User;

public class UserController {
	private IUserService userService;

	public UserController() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userService = new UserService();
	}

	public List<User> getListManagerOfUsers() throws Exception {

		return userService.getListManagerOfUsers();
	}

	public Project getUserByProjectId(int projectId) throws Exception {
		return userService.getUserByProjectId(projectId);
	}
	
	public boolean isUserExists(String email, String password) throws Exception {
		return userService.isUserExists(email, password);
	}

}
