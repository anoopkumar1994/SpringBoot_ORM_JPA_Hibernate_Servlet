package in.pw.PreparedQueary;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {
	
	public static Connection getJDBCconnection() {
		try {
			FileInputStream  fis = new FileInputStream("DBApplication.properties");
			Properties p = new Properties();
			p.load(fis);
			
			String url = p.getProperty("url");
			String user = p.getProperty("User");
			String password = p.getProperty("Password");
			
			System.out.println(url);
			System.out.println(user);
			System.out.println(password);
			
			Connection connection = DriverManager.getConnection(url, user, password);
			
			System.out.println("Connection successful.....");
			
			return connection;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	public static void closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
//		if(connection != null) {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		if(preparedStatement != null) {
//			try {
//				preparedStatement.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		if(resultSet != null) {
//			try {
//				resultSet.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	
	public static void closeResource(Connection connection, PreparedStatement preparedStatement) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
