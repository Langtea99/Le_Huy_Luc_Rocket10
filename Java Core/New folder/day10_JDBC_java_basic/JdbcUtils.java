package shared.day10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

	private Connection connection;

	private DatabaseProperties databaseproperties;

	/**
	 * Constructor for class JdbcUtils.
	 * 
	 */
	public JdbcUtils() throws IOException {
		databaseproperties = new DatabaseProperties();
	}

	/**
	 * This method is used for connecting to database.
	 * 
	 */
	public void connectForTesting()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, SQLException {

		String url = databaseproperties.getProperty("url");
		String username = databaseproperties.getProperty("username");
		String password = databaseproperties.getProperty("password");

		// Step 1: register the driver class with DriverManager
		Class.forName(databaseproperties.getProperty("driver"));

		// Step 2: get a Database Connection
		connection = DriverManager.getConnection(url, username, password);

		System.out.println("Connect success!");
	}

	/**
	 * This method is used for connecting to database.
	 * 
	 */
	public Connection connect()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, SQLException {

		String url = databaseproperties.getProperty("url");
		String username = databaseproperties.getProperty("username");
		String password = databaseproperties.getProperty("password");

		// Step 1: register the driver class with DriverManager
		Class.forName(databaseproperties.getProperty("driver"));

		// Step 2: get a Database Connection
		connection = DriverManager.getConnection(url, username, password);

		return connection;
	}

	/**
	 * This method is used for closing database.
	 * 
	 */
	public void disconnect() throws SQLException {
		connection.close();
	}
}
