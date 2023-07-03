<%@page import="java.util.List"%>
<%@page import="com.UserPackage.Book"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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

	if(session.getAttribute("uname")==null || session.getAttribute("uID")==null){
	 response.sendRedirect("UserLogin.jsp");
	}

	%>

	Welcome
	
	<form action="addBook">
	
	To rent a book please input the book name into the field<br>
	<input type="text" name="newBook">
	<input type = "submit" value="Borrow">
	
	</form>
	
	<form action="showBooks" method="post">
	
	To update the list of borrowed books,press the button<br>
	
	<input type = "submit" value="update">
	
	</form>
	
	<form action="removeBooks">
	
	To remove a book from the list of borrowed books,enter the name of the book in the field and press the button<br>
	
	<input type = "text" name="bookRemove">
	<input type = "submit" value="remove">
	
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

	</tr>
	<%
		
	}
	
	%>
			
	</table>
	
	

</body>
</html>