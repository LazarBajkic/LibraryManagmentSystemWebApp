package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
			
			session.removeAttribute("adminUsername");
			session.removeAttribute("adminID");
			session.removeAttribute("uname");
			session.removeAttribute("uID");
		
		RequestDispatcher rd = request.getRequestDispatcher("HomePage.jsp");
		rd.forward(request,response);
		
	}

}
