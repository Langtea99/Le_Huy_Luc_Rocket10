package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Project;
import com.vti.entity.User;

public interface IUserRepository {
	List<User> getListManagerOfUsers() throws Exception;

	Project getUserByProjectId(int projectId) throws Exception;
	
	public boolean isUserExists(String email, String password) throws Exception ;
}
