<%@page import="java.util.List"%>
<%@page import="com.UserPackage.Book"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="AdminAndUserPagesStyle.css">
<meta charset="UTF-8">
<title>User page</title>
</head>
<body>

	<%
	
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
	if(session.getAttribute("uname")==null || session.getAttribute("uID")==null){
	 response.sendRedirect("UserLogin.jsp");
	}

	%>

	<h1>Welcome</h1> 
		
	<form action="Logout">
	
	<input type="submit"  class="roundButton"  value="logout">
	
	<br>
	<br>
	
	</form>
	
	<div class="AdminAndUserStyle">

	<div class="actionsDiv">
	
	<h2>Rent a book</h2> 
	
	<form action="addBook">
	
	To rent a book please input the book name into the field<br>
	
	<input type="text" name="newBook">
	
	<br>
	<br>
	
	<input type = "submit"  class="roundButton"  value="Borrow">
	
	</form>
	
	</div>
	
	<div class="actionsDiv">
	
	<form action="showBooks" method="post">
	
	<h2>Update book list</h2> 
	
	To update the list of borrowed books,press the button
	
	<br>
	<br>
	
	<input type = "submit"  class="roundButton"  value="update">
	
	</form>
	
	</div>
	
	<div class="actionsDiv">
	
	<form action="removeBooks">
	
	<h2>Remove a book</h2> 
	
	To remove a book from the list of borrowed books,enter the name of the book in the field and press the button
	
	<br>
	<br>
	
	<input type = "text" name="bookRemove">
	
	<br>
	<br>
	
	<input type = "submit"  class="roundButton"  value="remove">
	
	</form>
	
	</div>

	</div>	

	<br>
	<br>

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
		
	<tr bgcolor="lime">

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