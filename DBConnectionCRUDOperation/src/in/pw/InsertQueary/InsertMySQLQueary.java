package in.pw.InsertQueary;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import in.pw.JDBCutil.JDBCutil;

public class InsertMySQLQueary {
	
	public static void main(String args[]) throws SQLException, IOException {
		Connection connection = null;
		Statement statement = null;
		connection = JDBCutil.getJdbcConnection();
		if(connection != null) {
			try {
				
				statement = connection.createStatement();
				String mySQLQueary = "insert INTO student (rollno, name,result) values(2,'Shyam', 'pass')";
				int rowEffected = statement.executeUpdate(mySQLQueary);
				
				if(rowEffected == 1) {
					System.out.println("ROW inserted");
				}else {
					System.out.println("ROW not inserted");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCutil.closeResource(connection, statement);
			}
		}
		
	}
}
