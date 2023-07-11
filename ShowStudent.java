package javaprogram;

import java.sql.Connection;
import java.sql.ResultSet;

public class ShowStudent {
	public static void Print_Student() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = ConnectionProvider.getConnection();
			String q ="select * from student ";
			java.sql.Statement st = con.createStatement();
			ResultSet rt = st.executeQuery(q);
			if(rt.getFetchSize()==0)
			{
				System.out.println("\tOpps Table is Empty Please Enter Some Data Then Come Again !!!!  \n\n");
				return;
			}
			
			while(rt.next())
			{
				int id = rt.getInt(1);
				String name = rt.getString(2);
				int age = rt.getInt(3);
				String Father = rt.getString(4);
				String Mother = rt.getString(5);
				System.out.println("___________________________________________________________________________________________________________");
				System.out.println("     "+"Id = "+id +"  "+"Name = "+name+" "+"Age = "+age+" "+" Father_Name = "+Father+" "+" Mother_Name "+Mother);
				System.out.print("___________________________________________________________________________________________________________\n");
			}
			
			System.out.println("\tDone... \n\n");
			con.close();
		}catch(Exception e)
		{
			System.out.println("\tError To Show Data  !!!! \n");
			e.printStackTrace();
			
		}
	}
}
