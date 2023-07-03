package com.AdminPackage;

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
 * Servlet implementation class AddNewUser
 */
public class AddNewUser extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newUserID = request.getParameter("newUserID");
		String newUserName = request.getParameter("newUserName");
		String Issued = request.getParameter("Issued");
		String ValidUntil = request.getParameter("validUntil");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","Ceramida");
			PreparedStatement st = con.prepareStatement("Insert into users Values (?,?,?,?)");
			st.setString(1, newUserID);
			st.setString(2, newUserName);
			st.setString(3, Issued);
			st.setString(4, ValidUntil);
			int execute = st.executeUpdate();
			
			RequestDispatcher rd = request.getRequestDispatcher("AdminPage.jsp");
			rd.forward(request, response);
			
		}catch(Exception e) {
			
		}
		
	}

}
