package com.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLUtil {
	private static Connection con;
	
	public static Connection getConnection() throws Exception{
		if(con == null){
			Class.forName("com.mysql.jdbc.Driver");
			String url =  "jdbc:mysql://localhost:3306/bookstore";
			String user = "root";
			String password = "123456";
			con = DriverManager.getConnection(url,user,password);
		}
		return con;
	}
}
