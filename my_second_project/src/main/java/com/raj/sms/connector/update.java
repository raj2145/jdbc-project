package com.raj.sms.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//    load or register driver
		try {
			Class.forName("org.postgresql.Driver");
			
			// establish connection
			try {
				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_second_project", "postgres", "root");
				
				//creation of statement
				Statement statement = connection.createStatement();
				
			//execution of statement
				statement.execute("UPDATE employee SET name='shivam' WHERE id=2");
				
				//close connetcion
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
