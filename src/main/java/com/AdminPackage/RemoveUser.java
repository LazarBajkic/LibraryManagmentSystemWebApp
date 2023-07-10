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
 * Servlet implementation class RemoveUser
 */
public class RemoveUser extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deleteUID = request.getParameter("deleteUID");
		String deleteUname = request.getParameter("deleteUname");
	
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","Ceramida");
			PreparedStatement st = con.prepareStatement("Delete from users where ID=? AND Name=?");
				
				st.setString(1, deleteUID);
				st.setString(2, deleteUname);
			
			int i = st.executeUpdate();
			
			RequestDispatcher rd = request.getRequestDispatcher("AdminPage.jsp");
			rd.forward(request,response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
