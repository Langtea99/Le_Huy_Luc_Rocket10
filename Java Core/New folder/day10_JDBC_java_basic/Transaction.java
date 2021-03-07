package shared.day10;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction {

	private JdbcUtils jdbcUtils;

	public Transaction() throws ClassNotFoundException, IOException, SQLException {
		jdbcUtils = new JdbcUtils();
	}

	// Transaction
	public void deleteDepartmentUsingTransaction(int idDepartment) throws Exception {

		// get connection
		Connection connection = jdbcUtils.connect();

		// turn off auto commit
		connection.setAutoCommit(false);

		// delete employees
		String accountSqlQuery = "	DELETE FROM `Account` WHERE DepartmentID = ?";
		PreparedStatement preparedStatementAccount = connection.prepareStatement(accountSqlQuery);

		// set parameter
		preparedStatementAccount.setInt(1, idDepartment);

		// delete department
		String departmentSqlQuery = "	DELETE FROM Department WHERE DepartmentID = ?";
		PreparedStatement preparedStatementDepartment = connection.prepareStatement(departmentSqlQuery);

		// set parameter
		preparedStatementDepartment.setInt(1, idDepartment);

		// execute query
		try {
			preparedStatementAccount.executeUpdate();
			System.out.println("delete Account success!");

			preparedStatementDepartment.executeUpdate();
			System.out.println("delete Department success!");

			// commit transaction
			connection.commit();
			System.out.println("Transaction Commit!");

		} catch (Exception e) {
			System.out.println(e.getMessage());

			connection.rollback();
			System.out.println("Transaction Rollback!");
		}

		// turn on auto commit
		connection.setAutoCommit(true);

		jdbcUtils.disconnect();
	}
}
