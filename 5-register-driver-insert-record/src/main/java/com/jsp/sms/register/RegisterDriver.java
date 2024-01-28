package com.jsp.sms.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.Driver;

public class RegisterDriver {

	public static void main(String[] args) {
// register driver
		

		
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_program", "postgres", "root");
			Statement statement = connection.createStatement();
			statement.execute("INSERT INTO student VALUES (5,'ABHISHEK')");
		connection.close();
		System.out.println("data inserted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}
}