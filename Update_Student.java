package javaprogram;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Update_Student {
	public static void Update_Data() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = ConnectionProvider.getConnection();
			String q="update student set name =? , age = ?, FatherName =? ,MotherName=? where id =?";
			PreparedStatement prd = con.prepareStatement(q);
			BufferedReader B = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\tEnter Id Of The Student : ");
			int id = Integer.parseInt(B.readLine());
			
			System.out.println("\tEnter New Student Name : ");
			String  name = B.readLine();
			
			System.out.println("\tEnter New Age : ");
			int age = Integer.parseInt(B.readLine());
			
			System.out.println("\tEnter Father Name : ");
			String Father = B.readLine();
			
			System.out.println("\tEnter Mother Name : ");
			String Mother = B.readLine();
			
			prd.setString(1,name);
			prd.setInt(2, age);
			prd.setString(3,Father);
			prd.setString(4,Mother);
			prd.setInt(5,id);
			prd.executeUpdate();
			
			System.out.println("\tRecord Update Done ... ");
			con.close();
			
		}catch(Exception e)
		{
			System.out.println("\tOpps Something is Wrong !!! ");
			e.printStackTrace();
		}
	}
}
