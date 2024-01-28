package com.jsp.sms.closeconnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.Driver;

public class connectionclose {
public static void main(String[] args) {
	
	Connection connection = null;
	try {
		Driver driver = new Driver();
		DriverManager.registerDriver(null);
		
		
	FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
	Properties properties = new Properties();
		connection =DriverManager.getConnection("jdbc:postgres://localhost:3542/", properties);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		if (connection!=null) {
			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
}
