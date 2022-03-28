package com.mypack.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnection {

	
	private MyConnection() {
		
	}
	private static Connection conn;

	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		if(conn==null)
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sagar", "root", "root");
			System.out.println("Load driver");
		}
		return conn;
		
	}
}
