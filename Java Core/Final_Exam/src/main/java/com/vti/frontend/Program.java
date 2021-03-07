package com.vti.frontend;

import java.io.IOException;
import java.sql.SQLException;

import com.vti.Utils.JdbcUtils;

public class Program {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		JdbcUtils jdbcUtils = new JdbcUtils();
		jdbcUtils.connectForTesting();
	}

}
