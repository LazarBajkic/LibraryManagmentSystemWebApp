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
 * Servlet implementation class AddNewAdmin
 */
public class AddNewAdmin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminID = request.getParameter("newAdminID");
		String adminUsername = request.getParameter("newAdminName");
		String startedWorking = request.getParameter("StartedWorking");
		
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","Ceramida");
			PreparedStatement st = con.prepareStatement("Insert into admins values(?,?,?)");
			st.setString(1, adminID);
			st.setString(2, adminUsername);
			st.setString(3, startedWorking);
			int execute = st.executeUpdate();
			
			RequestDispatcher rd = request.getRequestDispatcher("AdminPage.jsp");
			rd.forward(request, response);
			
		}catch(Exception e) {
			
		}
	}

}
