package com.jsp.sms.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_program", "postgres", "root");
			
			Statement statement = connection.createStatement();
			
			statement.execute("UPDATE student SET  name='sattu' WHERE id=1");
			
			connection.close();
			System.out.println("record updated");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
