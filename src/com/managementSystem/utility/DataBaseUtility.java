package com.managementSystem.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.managementSystem.exception.MySqlExceptions;

public class DataBaseUtility {
	
	public static Connection GetConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/managementSystem";
		
		try {
			connection = DriverManager.getConnection(url,"root", "ADMIN");
			System.out.println("Connected to Crime Infomation Mangement System Database");
			
		} catch (SQLException e) {
			
			new MySqlExceptions("DATABASE NOT FOUND");
			e.printStackTrace();
		}
		
		return connection;
		
		
	}
}
