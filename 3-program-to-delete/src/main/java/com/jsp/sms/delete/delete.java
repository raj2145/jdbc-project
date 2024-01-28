package com.jsp.sms.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
			
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_program", "postgres", "root");
			
			Statement statement = connection.createStatement();
			boolean flag=true;
			byte loop=1;
			Scanner myInput = new Scanner(System.in);
			do {     
				System.out.println("Enter id no : ");
				int id = myInput.nextInt();
				myInput.nextLine();
				
				statement.execute("DELETE FROM student WHERE s_id ="+id+"");
				System.out.println("Do you want to delete ? 1:yes 0:no");
				loop =myInput.nextByte();
				if (loop==0) {
					flag=false;
				}
			} while (flag);
			
			connection.close();
			System.out.println("record deleted");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

}
