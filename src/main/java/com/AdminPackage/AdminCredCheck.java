package com.AdminPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.UserPackage.Book;
import com.UserPackage.ShowBooksUser;

/**
 * Servlet implementation class AdminCredCheck
 */
public class AdminCredCheck extends HttpServlet {
	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminUsername = request.getParameter("aUname");
		String adminID = request.getParameter("aID");
		
		AdminDao aDao = new AdminDao();
		
		try 
		{
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","Ceramida");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select bookName,returnDate,dateRented from BorrowedBooks");
			
			if(aDao.checkAdminCreds(adminID, adminUsername)) {
				if(rs.next()) {
					
					ShowBooksUser SBU = new ShowBooksUser();
					List<Book> bookList = SBU.getUserBooks();
				
					HttpSession sess = request.getSession();
					sess.setAttribute("adminUsername", adminUsername);
					sess.setAttribute("adminID", adminID);
					sess.setAttribute("bookList", bookList);
				
				}response.sendRedirect("AdminPage.jsp");
			}else {
				response.sendRedirect("AdminLogin.jsp");

				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
