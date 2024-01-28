package com.raj.sms.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connector {

	public static void main(String[] args) {
		String url ="jdbc:postgresql://localhost:5432/my_second_project";
		String user="postgres";
		String password="root";
		
		
//		step 1:load and register driver
try {
	Class.forName("org.postgresql.Driver");
	//step2:establish connection
	try {
		Connection connection = DriverManager.getConnection(url, user, password);
		
		//step3:creation of statement
		Statement statement = connection.createStatement();
		//step4:execution of statement
		statement.execute("INSERT INTO employee VALUES (3,'SHIVAM',200000)");
		 //STEP5:CONNECTION CLOSE
		connection.close();
		
		System.out.println("Data inserted");
		
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
