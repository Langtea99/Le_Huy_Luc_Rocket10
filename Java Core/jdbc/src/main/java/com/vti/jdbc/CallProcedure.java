package com.vti.jdbc;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CallProcedure {

	private JdbcUtils jdbcUtils;

	public CallProcedure() throws ClassNotFoundException, IOException, SQLException {
		jdbcUtils = new JdbcUtils();
	}

	// Call Procedure
	public void deleteDepartmentUsingProcedure(int id) throws Exception {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "{CALL sp_delete_department(?)}";
		CallableStatement callabeStatement = connection.prepareCall(sql);

		// set parameter
		callabeStatement.setInt(1, id);

		// execute query
		callabeStatement.executeUpdate();

		// disconnect
		jdbcUtils.disconnect();
	}
}
