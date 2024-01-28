package com.qsp.sms.batchexecution;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.postgresql.Driver;

public class batchexecution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	
	
	FileInputStream filestream = new FileInputStream("dbconfig.properties");
	Properties properties = new Properties();
	properties.load(filestream);
	Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_program",properties);
	
	 Statement statement = connection.createStatement();
	 
	 statement.addBatch("INSERT INTO student VALUES(1,'a');INSERT INTO student VALUES(1,'a');");
	 statement.addBatch("INSERT INTO student VALUES(2,'b')");
	 statement.addBatch("INSERT INTO student VALUES(3,'c')");
	 statement.addBatch("INSERT INTO student VALUES(4,'d')");
	
	 int[] executeBatch = statement.executeBatch();
	 
	 for (int i = 0; i < executeBatch.length; i++) {
		System.out.println("NUMBER OF ROW AFFACTED" + executeBatch[i]);
	}
	 connection.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
