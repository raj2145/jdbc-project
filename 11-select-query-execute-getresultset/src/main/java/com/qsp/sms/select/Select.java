package com.qsp.sms.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Class.forName("org.postgresql.Driver");
	
	Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_program", "postgres", "root");
	Statement statement = connection.createStatement();
	
	boolean execute =statement.execute("SELECT * FROM student");
	if (execute) {
		ResultSet resultSet = statement.getResultSet();
		while (resultSet.next()) {
			System.out.println("Id :"+resultSet.getInt(1));
			System.out.println("Name : "+resultSet.getString(2));
		}
		System.out.println("Records exists");
	}else {
		System.out.println("Record does not exist");
	}
	connection.close();
	
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
