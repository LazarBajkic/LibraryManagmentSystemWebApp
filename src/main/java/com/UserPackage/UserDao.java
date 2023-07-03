package com.UserPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {
	 
	 String url="jdbc:mysql://localhost:3306/Library";
	 String username = "root";
	 String password = "Ceramida";
	 String query = "Select ID,Name from users where ID=? AND Name=?";
	
	public boolean checkUser(String uname,String ID) throws Exception{
		
			
		Class.forName("com.mysql.jdbc.Driver");
				
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(query);
					
				st.setString(1, uname);
				st.setString(2, ID);
			
			ResultSet rs=st.executeQuery();
			
			if(rs.next()) 
			{
				return true;
			}
			
			else
			{
				return false;
			}
		
	}
	
	
	public Book borrowABook(String bookName,String dateBorrowed,String returnDate) {
		
		Book newbook = new Book();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st = con.createStatement();
			st.executeUpdate("Insert into BorrowedBooks Values('"+bookName+"','"+dateBorrowed+"','"+returnDate+"')");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return newbook;	
	}
	
}
