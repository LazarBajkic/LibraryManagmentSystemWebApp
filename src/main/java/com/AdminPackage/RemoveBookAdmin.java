package com.AdminPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveBookAdmin
 */
public class RemoveBookAdmin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookToRemove = request.getParameter("bookAdminRemove");
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","Ceramida");
			PreparedStatement st = con.prepareStatement("Delete from BorrowedBooks where bookName=?");
			
				st.setString(1, bookToRemove);
				int i = st.executeUpdate();
			
			 RequestDispatcher rd = request.getRequestDispatcher("AdminPage.jsp");
			 rd.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
