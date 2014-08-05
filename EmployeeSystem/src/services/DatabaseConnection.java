package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static DatabaseConnection instance = new DatabaseConnection();
	private static final String url = "jdbc:mysql://localhost:3306/DB2";
	private static final String usr = "admin";
	private static final String pwd = "123456";

	public DatabaseConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Success loading Driver!");
		}

		catch (Exception e) {
			System.out.println("Fail loading Driver!");
			e.printStackTrace();
		}
	}

	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Success connecting server!");
		} catch (SQLException e) {
			System.out
					.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}
		return connection;
	}

	public Connection getConnection() {
		return instance.createConnection();
	}

}
