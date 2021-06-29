package com.dell.webapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public Connection connection;
	
	// init connection
	public DBConnection( String url, String username, String password ) throws ClassNotFoundException, SQLException {
		// 1. Register JDBC driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. Create Connection 
		connection  = DriverManager.getConnection(url, username, password);
		
	}

	// get connection
	public Connection getConnection() {
		return connection;
	}

	// close connection
	public void close() throws SQLException {
		if(connection != null) {
			connection.close();
		}
	}
	
}

