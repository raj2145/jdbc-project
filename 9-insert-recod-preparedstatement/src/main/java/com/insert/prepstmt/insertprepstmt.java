package com.insert.prepstmt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.Driver;

public class insertprepstmt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			
			FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_program", properties);
//			step3
			String query ="INSERT INTO student VALUES(?,?);";
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			 prepareStatement.setInt(1, 11);
			 prepareStatement.setString(2, "smith");
			 
			 prepareStatement.execute();
			 
			 connection.close();
			 System.out.println("operation performed");
			
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
