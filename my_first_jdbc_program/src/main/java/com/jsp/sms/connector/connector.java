package com.jsp.sms.connector;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class connector {
public static void main(String[] args) {
	String url ="jdbc:postgresql://localhost:5432/my_first_jdbc_program";
	System.out.println("enter");
	 Scanner sc = new Scanner(System.in);
	 String a=sc.nextLine();
	
//	String user ="postgres";
//	String password ="root";
//	
	try {
		//step 1: load register driver
		Class.forName("org.postgresql.Driver");
		
		FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		//step 2: Establish connection
//		Connection connection = DriverManager.getConnection(url,user,password);	
	Connection connection = DriverManager.getConnection(url, properties);
		//step3 :creation of statement
		Statement statement = connection.createStatement();
		
		//step4:execution of statement
		statement.execute("INSERT INTO student VALUES (6,'ashish')");
		
		//Step 5:close connection
		connection.close();
		System.out.println("Data Inserted");
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
	}
}
}
