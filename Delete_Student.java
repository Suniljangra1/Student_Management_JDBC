package javaprogram;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Delete_Student {
		public static void DeleteStudent() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = ConnectionProvider.getConnection();
						String st = "delete from student where id =?";
				PreparedStatement prd = con.prepareStatement(st);
				BufferedReader B = new BufferedReader(new InputStreamReader(System.in));
				
				System.out.println("\tEnter Student Id For Delete The Data : ");
				int id = Integer.parseInt(B.readLine());
				prd.setInt(1, id);
				
				prd.executeUpdate();
				System.out.println("\tData Deleted ... ");
				con.close();
			}catch(Exception e)
			{
				System.out.println("\tError Occur !!! ");
				e.printStackTrace();
			}
		}
}
