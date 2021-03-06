package com.vti.backend.bussinesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Project;
import com.vti.entity.User;

public interface IUserService {
	List<User> getListManagerOfUsers() throws Exception;

	Project getUserByProjectId(int projectId) throws Exception;
	
	boolean isUserExists(String email, String password) throws Exception ;
}
