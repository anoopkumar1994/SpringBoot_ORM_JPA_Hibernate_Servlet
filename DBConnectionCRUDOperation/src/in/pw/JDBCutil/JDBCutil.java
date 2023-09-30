package in.pw.JDBCutil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCutil {

	// This is (statement) method to connect the jdbc driver 
	public static Connection getJdbcConnection() throws SQLException, IOException {
		
		
			FileInputStream fis = new FileInputStream("DBApplication.properties");
			Properties p = new Properties();
			p.load(fis);
			String url = p.getProperty("url");
			String user = p.getProperty("User");
			String password = p.getProperty("Password");
			
			System.out.println(url);
			System.out.println(user);
			System.out.println(password);
			
			Connection connection = DriverManager.getConnection(url, user, password);
			
			System.out.println("Connection successfull...");
			
			return connection;
	}
	
	public static void closeResource(Connection connection, Statement statement ) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
