package com.UserPackage;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckUserCreds
 */
public class CheckUserCreds extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String uID =request.getParameter("uID");
		
		UserDao uDao = new UserDao();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","Ceramida");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select bookName,returnDate,dateRented from BorrowedBooks");
			
			if(uDao.checkUser(uname, uID)) {
				if(rs.next()){
				
					ShowBooksUser SBU = new ShowBooksUser();
					List<Book> bookList = SBU.getUserBooks();
					
				HttpSession sess = request.getSession();
				
				sess.setAttribute("uname", uname);
				sess.setAttribute("uID", uID);
				sess.setAttribute("bookList", bookList);
				
			}
			
			response.sendRedirect("UserPage.jsp");
			
			}
			else
			{
				
			response.sendRedirect("UserLogin.jsp");
			
		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}
		
