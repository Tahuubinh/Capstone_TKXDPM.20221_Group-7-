package entity.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DBConnection {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/ecoBike";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "12345678";
	private static Connection connection = getConnection();
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("Successfully!");
		} catch (Exception ex) {
			System.out.println("Failure!");
			System.out.println(ex);
			ex.printStackTrace();
		}
		return connection;
	}

	public static void execute(String command) {
		System.out.println("Executing command: \n" + command);
		try {
			Statement stmt = connection.createStatement();
			stmt.execute(command);
			System.out.println("Successfully execute command: " + command);
		} catch (Exception e) {
			System.out.println("Fail to execute command: \n" + command);
			e.printStackTrace();
		}
	}

	public static ArrayList<ArrayList<String>> query(String command) {
		System.out.println("Executing query: \n" + command);
		try {
			ArrayList<ArrayList<String>> queryResults = new ArrayList<>();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(command);
			int numberOfColumn = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				ArrayList<String> s = new ArrayList<>();
				for (int i = 1; i <= numberOfColumn; ++i)
					s.add(rs.getString(i));
				queryResults.add(s);
			}
			System.out.println("Successfully execute command: " + command);
			return queryResults;
		} catch (Exception e) {
			System.out.println("Successfully execute command: " + command);
			e.printStackTrace();
			return null;
		}
	}
}