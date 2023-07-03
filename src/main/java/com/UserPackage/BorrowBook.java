package com.UserPackage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BorrowBook
 */
public class BorrowBook extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	    Calendar calendar = Calendar.getInstance();
		
		sdf.setTimeZone(calendar.getTimeZone());
        int month = calendar.get(Calendar.MONTH)+3;
		
		String bookName = request.getParameter("newBook");
		String dateBorrowed = sdf.format(calendar.getTime());;
		String returnDate = calendar.get(Calendar.YEAR)+"-"+month+"-"+calendar.get(Calendar.DAY_OF_MONTH);;
		
		UserDao dao = new UserDao();
		Book newBook = dao.borrowABook(bookName, dateBorrowed, returnDate);
		
		request.setAttribute("newBook", newBook);
		RequestDispatcher rd = request.getRequestDispatcher("UserPage.jsp");
		rd.forward(request, response);
		
	}
}
