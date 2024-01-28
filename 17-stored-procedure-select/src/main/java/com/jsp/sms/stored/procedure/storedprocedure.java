package com.jsp.sms.stored.procedure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import org.postgresql.Driver;

public class storedprocedure {
	//while creating procrdure in input

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
try {
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	
	
	FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
	Properties properties = new Properties();
	properties.load(fileInputStream);
	connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_program",properties );
	
	CallableStatement callableStatement = connection.prepareCall("CALL fetch_student(?,?,?);");
	callableStatement.setInt(1, 5);
	callableStatement.registerOutParameter(2, Types.NUMERIC);
	callableStatement.registerOutParameter(3, Types.VARCHAR);
	callableStatement.execute();
	
	System.out.println("id :"+callableStatement.getBigDecimal(2));
	System.out.println("name :"+ callableStatement.getString(3));
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally {
	if (connection !=null ) {
		try {
			connection.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}
	}

}
