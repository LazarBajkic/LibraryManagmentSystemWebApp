package com.UserPackage;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowUpdateBooks
 */
public class ShowUpdateBooks extends HttpServlet {
	
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
				
				HttpSession sess = request.getSession();
				sess.setAttribute("bookList", books);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserPage.jsp");
		rd.forward(request,response);
		
	}

}
