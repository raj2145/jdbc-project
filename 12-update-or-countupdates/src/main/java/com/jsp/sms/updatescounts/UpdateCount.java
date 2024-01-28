package com.jsp.sms.updatescounts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.postgresql.Driver;

public class UpdateCount {
public static void main(String[] args) {
	try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
//	step2
		FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_program",properties );
		
//		step3
		Statement statement = connection.createStatement();
		
		//step 4
		int count =0;
		while (true) {
            int Execute = statement.executeUpdate("UPDATE student SET name='aniket' WHERE id=1");
            if (Execute> 0) {
                count += Execute;
                System.out.println( count);
                break;
            }
        }

		//step5
		connection.close();
		System.out.println("record updated");
		
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
