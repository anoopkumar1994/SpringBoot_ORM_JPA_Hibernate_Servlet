package in.pw.PreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.pw.PreparedQueary.ConnectionDB;

public class InsertQureay {
	
	public static void main(String args[]) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = ConnectionDB.getJDBCconnection();
		Scanner s = new Scanner(System.in);
		
		try {
			if(connection != null) {
				String mySQLQueary = "insert INTO student(rollno, name, result) values(?, ?, ?)";
				preparedStatement =connection.prepareStatement(mySQLQueary);
				
				if(preparedStatement != null) {
					
				
					preparedStatement.setInt(1, 123);
					preparedStatement.setString(2, "Shyam Sundar");
					preparedStatement.setString(3, "Pass");
					
					//user input
//					System.out.println("Enter rollNo");
//					preparedStatement.setInt(1, s.nextInt());
//					System.out.println("Enter name");
//					preparedStatement.setString(2, s.nextLine());
//					System.out.println("Enter result");
//					preparedStatement.setString(3, s.next());
					
					int rowEffected = preparedStatement.executeUpdate();
					
					if(rowEffected == 1) {
						System.out.println("ROW inserted");
					}else {
						System.out.println("ROW not inserted");
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionDB.closeResource(connection, preparedStatement);
		}
	}

}
