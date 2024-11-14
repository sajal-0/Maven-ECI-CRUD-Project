package com.tka.eci.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class Utility {
	
	public static Connection support() {
		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/batch1199";
		String uname = "root";
		String pwd = "Pass@123";
		Connection con = null;
		
		
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return con;
		
	}

}
