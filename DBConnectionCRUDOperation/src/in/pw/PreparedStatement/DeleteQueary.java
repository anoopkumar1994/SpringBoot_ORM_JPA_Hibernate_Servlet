package in.pw.PreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import in.pw.PreparedQueary.ConnectionDB;

public class DeleteQueary {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatemnt = null;
		connection = ConnectionDB.getJDBCconnection();
		Scanner s = new Scanner(System.in);
		
		try {
			
			if(connection != null) {
				String deleteQueary = "delete from student where id = ? ";
				preparedStatemnt = connection.prepareStatement(deleteQueary);
				
				if(preparedStatemnt != null) {
					System.out.println("Enter the id which you want to delet");
					preparedStatemnt.setInt(1, s.nextInt());
					
					int rowEffected = preparedStatemnt.executeUpdate();
					
					if(rowEffected == 1) {
						System.out.println("ROW deleted");
					}else {
						System.out.println("ROW not deleted");
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionDB.closeResource(connection, preparedStatemnt);
			s.close();
		}
	}

}
