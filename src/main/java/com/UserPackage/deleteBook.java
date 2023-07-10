package com.UserPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteBook
 */
public class deleteBook extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookToRemove = request.getParameter("bookRemove");
		
		try {
			
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","Ceramida");
			 PreparedStatement st = con.prepareStatement("Delete from BorrowedBooks where bookName=?");
			 
			 	st.setString(1, bookToRemove);
			 	int i= st.executeUpdate();
			 
			 RequestDispatcher rd = request.getRequestDispatcher("UserPage.jsp");
			 rd.forward(request, response);
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
