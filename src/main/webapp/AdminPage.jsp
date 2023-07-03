<%@page import="java.util.List"%>
<%@page import="com.UserPackage.Book"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%

	if(session.getAttribute("adminUsername")==null || session.getAttribute("adminID")==null){
	 response.sendRedirect("AdminLogin.jsp");
	}

	%>
	
	
	Welcome
	
	
	<form action="showBooksAdmin" method="post">
	
	To update the list of borrowed books,press the button<br>
	
	<input type = "submit" value="update">
	
	</form>
	
	<form action="removeBooksAdmin">
	
	To remove a book from the list of borrowed books,enter the name of the book in the field and press the button<br>
	
	<input type = "text" name="bookAdminRemove">
	<input type = "submit" value="remove">
	
	</form>
	
	<form action="addNewUser" method="post">
	
	<br>
	<br>
	
	To add a new user,input the ID,user name,when the membership was issued and when it will expire in the boxes below<br>
	
	Input ID:<input type="text" name="newUserID"><br>
	Input User name:<input type="text" name="newUserName"><br>
	<br>
	NOTE:please input both in following form MM/DD/YYYY
	<br>
	<br>
	Input Date issued:<input type="text" name="Issued"><br>
	Input Expiration date:<input type="text" name="validUntil"><br>
	
	<input type="submit" value="register new user">
	
	<br>
	<br>
	
	</form>
	
	<form action="addNewAdmin" method="post">
	
	<br>
	<br>
	
	To add a new admin,input the ID,user name,and the date when they started working in the boxes below<br>
	
	Input ID:<input type="text" name="newAdminID"><br>
	Input User name:<input type="text" name="newAdminName"><br>
	<br>
	NOTE:please input data in the following form MM/DD/YYYY
	<br>
	<br>
	Input Date issued:<input type="text" name="StartedWorking"><br>
	
	<input type="submit" value="register new admin">
	<br>
	<br>
	
	</form>
	
	
	<table>
	
	<tr>
	
	<th>Book Name</th>
	<th>Date Borrowed</th>
	<th>Return Date</th>
	
	</tr>
	
	<%
	
	List<Book> listBooks = (List<Book>) session.getAttribute("bookList");
	for(Book book : listBooks){

	
	%>
	
	<tr bgcolor="Green">

	<td><%= book.getBookName() %></td>
	<td><%= book.getDateBorrowed() %></td>
	<td><%= book.getReturnDate() %></td>
	
	
	
	<%
	
	}
	
	%>
	
	</table>
	
	
	
</body>
</html>