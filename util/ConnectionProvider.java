package com.healthcare.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ConnectionProvider {
	
	private static Connection connection;
	public static Connection getconnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","gayathri@0312");
			System.out.println("MYSQL connect successfully"+connection);
		} catch (Exception e) {
			
		}
		return connection;
		
	}
}
