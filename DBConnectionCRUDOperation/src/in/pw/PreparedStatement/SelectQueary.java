package in.pw.PreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import in.pw.PreparedQueary.ConnectionDB;

public class SelectQueary {
	public static void main(String args[]) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = ConnectionDB.getJDBCconnection();
		Scanner s = new Scanner(System.in);
		
		try {
			
			if(connection != null) {
				String selectQueary = "select * from student where id =?";
				preparedStatement = connection.prepareStatement(selectQueary);
				
				if(preparedStatement != null) {
					System.out.println("Enter the id witch you want to get from database of MYSQL");
					preparedStatement.setInt(1, s.nextInt());
					
					resultSet = preparedStatement.executeQuery();
					
					if(resultSet != null) {
						if(resultSet.next()) {
							System.out.println("id\trollno\tname\tresult");
							System.out.println(resultSet.getInt(1) + "\t" + resultSet.getInt(2) + "\t" + resultSet.getString(3) +"\t" + resultSet.getString(4));
							
						}
					}
				}
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionDB.closeResource(connection, preparedStatement, resultSet);
			s.close();
		}
		
	}

}
