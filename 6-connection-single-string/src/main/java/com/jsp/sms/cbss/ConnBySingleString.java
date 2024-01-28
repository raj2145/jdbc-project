package com.jsp.sms.cbss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnBySingleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Class.forName("org.postgresql.Driver");
	Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_program?user=postgres&password=root");
	Statement statement = connection.createStatement();
	
	statement.execute("INSERT INTO student VALUES(7,'AP')");
	
	connection.close();
	System.out.println("record inserted");
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
