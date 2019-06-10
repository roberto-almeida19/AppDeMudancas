package com.appdemudancas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static ConnectionManager instance;
	private Connection connection;

	private String databaseUrl;
	private String user;
	private String password;

	public ConnectionManager() {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		databaseUrl = "jdbc:maridb://localhost:3306/appdemudancas";

		user = "root";

		password = "1234";

	}

	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {

		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(databaseUrl, user, password);
		}

		return connection;
	}

}