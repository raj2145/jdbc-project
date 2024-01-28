package com.jsp.sms.callstored;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.Driver;

public class CallStoredprocedure {
	private static String url="jdbc:postgresql://localhost:5432/my_first_jdbc_program";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		
try {
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	
	
	FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
	Properties properties = new Properties();
	properties.load(fileInputStream);
	connection=DriverManager.getConnection(url, properties);
	
	CallableStatement callableStatement = connection.prepareCall("CALL insert_student (5,'abc');");
//	callableStatement.setInt(1, 4);
//	callableStatement.setString(2, "jki");
	
	callableStatement.execute();
//	
	System.out.println("data inserted");
	
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

finally {
	if (connection != null) {
		try {
			connection.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}
	}

}
