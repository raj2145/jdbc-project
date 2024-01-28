package com.jsp.emp.mock;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class mock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
//1.load
		try {
			Class.forName("org.postgresql.Driver");
			
//			step2
			FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mock", properties);
			//step3
			PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO emp VALUES(?,?)");
			prepareStatement.setInt(1, 1);
			prepareStatement.setString(2, "ashish");
			prepareStatement.executeUpdate();
			System.out.println("data inserted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
