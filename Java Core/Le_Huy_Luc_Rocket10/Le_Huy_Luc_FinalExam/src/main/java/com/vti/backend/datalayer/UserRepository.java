package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.Utils.JdbcUtils;
import com.vti.entity.Position;
import com.vti.entity.Project;
import com.vti.entity.User;

public class UserRepository implements IUserRepository {

	private JdbcUtils jdbcUtils;
	private Connection connection;
	private int projectID ;
	private int idManager ;
	private int idEmployees ;

	public UserRepository() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		jdbcUtils = new JdbcUtils();
	}

	@Override
	public List<User> getListManagerOfUsers() throws Exception {
		List<User> users = new ArrayList<>();

		try {
			// get connect
			connection = jdbcUtils.connect();

			// Step 3: Create a statment object
			Statement statement = connection.createStatement();

			// Step 4: Execute query
			String listUser = "SELECT * FROM usermanager.user where `Position` = Manager";
			ResultSet resultSet = statement.executeQuery(listUser);

			// Step 5: Handling result set
			while (resultSet.next()) {
				int userId = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				String email = resultSet.getString("Email");
				String password = resultSet.getString("Password");
				Position position = Position.valueOf(resultSet.getString("Position"));

				User user = new User(userId, fullName, email, password, position);
				users.add(user);

			}
			return users;
		} finally {
			// Step 6: Close connection
			connection.close();
		}
	}

	@Override
	public Project getUserByProjectId(int projectId) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		try {
			// Step 2: get connect
			connection = jdbcUtils.connect();
			// Step 3: Create a statement object
			String sql = " SELECT * " + " FROM `Project` " + " WHERE ProjectID = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, projectId);

			// Step 4: Execute SQL query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result set
			while (resultSet.next()) {
				 projectID = resultSet.getInt("ProjectID");
				 idManager = resultSet.getInt("IdManager");
				 idEmployees = resultSet.getInt("IdEmployees");
				 Project project = new Project(projectID,idManager, idEmployees);

					return project;
			}
			return null;

		} finally {
			connection.close();
		}
	}

	@Override
	public boolean isUserExists(String email, String password) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, SQLException {
		connection = jdbcUtils.connect();
		String query = "Select * From `User` where Email = '?' and `Password` = '?'";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1,email);
		preparedStatement.setString(2,password);
		
		boolean check = false;
		ResultSet set = preparedStatement.executeQuery();
		
		if(set.next())
			check = true;

		//jdbcUtils.disconnect();
		return check;
	}

}
