package com.mads.Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
	
	private static Connection connection;
	public static Connection getConnection() 
	{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_springbootojt", "root","root");
		System.out.println("DB connection done");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return connection;
	}
}
