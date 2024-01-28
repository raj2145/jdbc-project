package com.jsp.shop.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.postgresql.Driver;

import com.jsp.shop.model.product;

public class ShopController {
public int addProduct(int id,String name,int price,int quantity,boolean availablity) {
	Connection connection =null;
	int rowsAffected =0;
	try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		connection =DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop_jdbc", properties);
		
		PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO product VALUES(?,?,?,?,?)");
		prepareStatement.setInt(1, id);
		prepareStatement.setString(2, name);
		prepareStatement.setInt(3, price);
		prepareStatement.setInt(4, quantity);
		prepareStatement.setBoolean(5, availablity);
		 rowsAffected=prepareStatement.executeUpdate();
		
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
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	return rowsAffected;
}
public void addMultipleProducts(ArrayList<product> products) {
	Connection connection=null;
	try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop_jdbc", properties);
		
		PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO product VALUES(?,?,?,?,?)");
		for (product product : products) {
			prepareStatement.setInt(1, product.getP_id());
			prepareStatement .setString(2, product.getP_name());
			prepareStatement .setInt(3,product.getP_price());
			prepareStatement.setInt(4, product.getP_quantity());
			prepareStatement.setBoolean(5, product.isP_availablity());
			prepareStatement.addBatch();
			
		}
		prepareStatement.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
public ResultSet fetchProduct(int id) {
	Connection connection = null;
	ResultSet resultSet = null;
	try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop_jdbc", properties);
		PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM product WHERE p_id=?");
		prepareStatement.setInt(1, id);
	    resultSet = prepareStatement.executeQuery();
		
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}finally {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	return resultSet;
}

public int  removeProduct(int id) {
	int idDeleted = 0;
	Connection connection = null;
	
	try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop_jdbc", properties);
		PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM product WHERE p_id=?");
		prepareStatement.setInt(1, id);
		idDeleted = prepareStatement.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}finally {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	return idDeleted;
}

public  int updateProduct(int id , String name) {
	Connection connection = null;
	int updateVerify=0;
	try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		connection =DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop_jdbc", properties);
		PreparedStatement prepareStatement = connection.prepareStatement("UPDATE product SET p_name = ? WHERE p_id = ?");
		prepareStatement.setString(2, name);
		prepareStatement.setInt(1, id);
		
		updateVerify =prepareStatement.executeUpdate();
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
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	return updateVerify;
}
}


