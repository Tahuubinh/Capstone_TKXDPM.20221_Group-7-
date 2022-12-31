package entity.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/ecobike";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "12345678";
    private static Connection connection = getConnection();

    /**
     * Tạo connection với cơ sở dữ liệu
     * @return Connection
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Connect successfully!");
        } catch (Exception ex) {
            System.out.println("Fail to connect!");
            ex.printStackTrace();
        }
        return connection;
    }

    /**
     * Thực thi một lệnh bất kỳ
     * @param command: lệnh thực thi
     */
    public static void execute(String command){
        System.out.println("Executing command: \n" + command);
        try{
            Statement statement = connection.createStatement();
            statement.execute(command);
            System.out.println("Successfully execute command: " + command);
        } catch (Exception e){
            System.err.println("Fail to execute command: \n" + command);
            e.printStackTrace();
        }
    }

}
