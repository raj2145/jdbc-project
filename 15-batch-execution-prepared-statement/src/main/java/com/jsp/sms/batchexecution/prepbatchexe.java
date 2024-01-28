package com.jsp.sms.batchexecution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class prepbatchexe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection =null;
try {
	Class.forName("org.postgresql.Driver");
	
	
	FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
	Properties properties = new Properties();
	properties.load(fileInputStream);
	connection =DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_program", properties);
	
	PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO student VALUES (?,?)");
	prepareStatement.setInt(1, 15);
	prepareStatement.setString(2, "p");
	prepareStatement.addBatch();
	prepareStatement.setInt(1, 16);
	prepareStatement.setString(2, "q");
	prepareStatement.addBatch();
	prepareStatement.setInt(1, 17);
	prepareStatement.setString(2, "r");
	prepareStatement.addBatch();
	
	int[] executeBatch = prepareStatement.executeBatch();
	
	for (int i = 0; i < executeBatch.length; i++) {
		System.out.println("no.of rows geting affected by query no ." + (i+1)+":" + executeBatch[i]);
	}
	
	
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} finally {
	if (connection !=null) {
		try {
			connection.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}
		
	}

}
