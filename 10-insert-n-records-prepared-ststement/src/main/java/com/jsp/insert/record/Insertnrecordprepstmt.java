package com.jsp.insert.record;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import org.postgresql.Driver;

public class Insertnrecordprepstmt {
	
	public static void main(String[] args) {
		try {
//			1:step register driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
//			2:step establish connection
			FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_program", properties);
//			3:creation of statement
			String query="INSERT INTO student VALUES(?,?);";
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			
			Scanner myInput = new Scanner(System.in);
			boolean flag=true;
			byte loop=1;
			do {
				System.out.println("Enter id : ");
				 int id = myInput.nextInt();
	                prepareStatement.setInt(1, id);
	                myInput.nextLine(); 
	                System.out.print("Enter name: ");
	                String name = myInput.nextLine();
	                prepareStatement.setString(2, name);
	                prepareStatement.execute();

	                System.out.print("Do you want to insert another  record? 1:yes & 0:no ");
	            loop =myInput.nextByte();
	                if (loop==0) {
	                    flag = false;}
			} while (flag);
			
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
