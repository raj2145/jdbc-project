package com.jsp.sms.endrecord;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import org.postgresql.Driver;

public class InsertEndRecord {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			FileInputStream fileInputstream = new FileInputStream("dbconfig.properties");
			Properties properties = new Properties();
			properties.load(fileInputstream);
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_program", properties);
			Statement statement = connection.createStatement();
			
			boolean flag=true;
			byte loop =1;
			Scanner myInput = new Scanner(System.in);
			do {
				int id=0;
				String name=null;
				System.out.println("Enter id : ");
				id=myInput.nextInt();
				myInput.nextLine();
				System.out.println("Enter name: ");
				name =myInput.nextLine();
				statement.execute("INSERT INTO student VALUES ("+ id +",'"+ name +"' )");
				System.out.println("Do you want to add more record ? yes : 1 no :0");
				loop=myInput.nextByte();
				if (loop == 0) {
					flag =false;
					System.out.println("your data inserted");
				}
			} while (flag);
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
