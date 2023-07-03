package com.UserPackage;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ShowBooksUser {
	
	public List<Book> getUserBooks() throws ClassNotFoundException{
		

		List<Book> books = new ArrayList<Book>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","Ceramida");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select bookName,dateRented,returnDate from BorrowedBooks");
			
			while(rs.next()) {
				Book book = new Book();
				book.setBookName(rs.getString("bookName"));
				book.setDateBorrowed(rs.getString("dateRented"));
				book.setReturnDate(rs.getString("returnDate"));
				
				books.add(book);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
		
	}
	
}
