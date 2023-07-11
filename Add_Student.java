package javaprogram;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Add_Student {
//	public static void main(String []args)
//	{
//		Add_Student.EnterData();
//	}
	public static void EnterData()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = ConnectionProvider.getConnection();
			String st ="insert into student (Name,Age, FatherName,MotherName) values(?,?,?,?)";
			PreparedStatement prd = con.prepareStatement(st);
			BufferedReader B = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\tEnter Student Name : ");
			String name = B.readLine();
			System.out.println("\tEnter Student Age : ");
			int age = Integer.parseInt(B.readLine());
			System.out.println("\tEnter Father Name : ");
			String Father= B.readLine();
			
			System.out.println("\tEnter Mother Name : ");
			String Mother = B.readLine();
			prd.setString(1,name);
			prd.setInt(2, age);
			prd.setString(3,Father);
			prd.setString(4, Mother);
			prd.executeUpdate();
			System.out.println("\tRecord Entered... ");
			con.close();
			
		}catch(Exception e)
		{
			System.out.println("\tOpps Some Mistakes Try Next Time ... ");
			e.printStackTrace();
			
		}
	}
}
//	public static void main(String[] args) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = ConnectionProvider.getConnection();
//			String q ="create table student (id int primary key auto_increment,Name varchar(50) not null,Age int ,FatherName varchar(50) not null,MotherName varchar(50) not null)";
//			java.sql.Statement st = con.createStatement();
//			st.execute(q);
//			System.out.println("Done ... ");
//			con.close();
//		}catch(Exception e)
//		{
//			System.out.println("Error !!!!  ");
//			e.printStackTrace();
//		}
//	}
