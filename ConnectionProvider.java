package javaprogram;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	private static Connection co;
	public static Connection  getConnection() {
		try {
			if(co == null)
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/jdbc";
				String name = "root";
				String pass = "sunil@123";
				co = DriverManager.getConnection(url,name,pass);
				
			}
		
		}catch(Exception e)
		{
			System.out.println("Error !!!!  ");
			e.printStackTrace();
		}
		return co;
	}
}
