package javaprogram;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;

public class Student_ManagementSystem {
	@SuppressWarnings("unused")
	public static void main(String []args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  // load the driver in Memory  
			Connection con = ConnectionProvider.getConnection();   // this function give us Connection object  
			BufferedReader B = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\t\t\t Welcome To Student Management System : \n\n");
			while(true)
			{
				System.out.println("\tPress 1 For Add Student  : ");
				System.out.println("\tPress 2 For Delete Student :");
				System.out.println("\tPress 3 For Display Data : ");
				System.out.println("\tPress 4 For Update Data : ");
				System.out.println("\tPress 5 For Exit : \n\n");
				
				System.out.print("\tEnter a Number : ");
				int us= Integer.parseInt(B.readLine());
				
				switch(us)
				{
					case 1 : 
					{
						Add_Student.EnterData();
						break;
					}
					case 2: {
						Delete_Student.DeleteStudent();
						break;
					}
					case 3: {
						ShowStudent.Print_Student();
						break;
					}
					case 4: {
						Update_Student.Update_Data();
						break;
					}
					case 5 : {
						System.exit(0);
					}
					deafult :{
						System.out.println("Please Enter a Valid Number !!! ");
						System.exit(0);
					}
				}
				
			}
		}catch(Exception e)
		{
			System.out.println("Error !!!! ");
			e.printStackTrace();
			
		}
	}
}
