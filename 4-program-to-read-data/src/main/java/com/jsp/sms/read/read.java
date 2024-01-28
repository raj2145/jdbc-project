  package com.jsp.sms.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class read {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	
//	step 1:load or register driver
			
			Class.forName("org.postgresql.Driver");
//			step 2:establish connection
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_program", "postgres", "root");
//			step 3:creation of statement
			Statement statement = connection.createStatement();
			//step 4:execution of statement
			ResultSet resultset = statement.executeQuery("SELECT* FROM student");
			
			while (resultset.next()) {
				System.out.println("id :"+resultset.getInt(1));
				System.out.println("name :"+resultset.getString(2));
			}
			//step 5:close connection
			connection.close();
			System.out.println("record read");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	}


