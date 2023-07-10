<%@page import="java.util.List"%>
<%@page import="com.UserPackage.Book"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="AdminAndUserPagesStyle.css">
<meta charset="UTF-8">
<title>Admin page</title>
</head>
<body>
	
	
	<%

	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
	if(session.getAttribute("adminUsername")==null || session.getAttribute("adminID")==null){
	 response.sendRedirect("AdminLogin.jsp");
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
	
	<form action="showBooksAdmin" method="post">
	
	<h2>Update book list</h2>
	
	To update the list of borrowed books,press the button
	
	<br>
	<br>
	
	<input type = "submit" class="roundButton" value="update">
	
	</form>
	
	</div>
	
	<div class="actionsDiv">
	
	<form action="removeBooksAdmin">
	
	<h2>Remove a book</h2>
	
	To remove a book from the list of borrowed books,enter the name of the book in the field and press the button
	
	<br>
	<br>
	
	<input type = "text" name="bookAdminRemove">
	
	<br>
	<br>
	
	<input type = "submit" class="roundButton" value="remove">
	
	</form>
	
	</div>
	
	<div class="actionsDiv">
	
	<form action="addNewUser" method="post">
	
	<h2>Add new user</h2>
	
	To add a new user,input the ID,user name,when the membership was issued and when it will expire in the boxes below
	
	<br>
	<br>
	
	Enter ID:<br><input type="text" name="newUserID">
		
	<br>		
	<br>
		
	Enter User name:<input type="text" name="newUserName">
	
	<br>
	<br>
	
	NOTE:please input both in following form MM/DD/YYYY
	
	<br>
	<br>
	
	Enter Date issued:<input type="text" name="Issued">
	
	<br>
	<br>
	
	Enter Expiration date:<input type="text" name="validUntil">
	
	<br>
	<br>
	
	<input type="submit" class="roundButton" value="register new user">
	
	<br>
	<br>
	
	
	</form>
	
	</div>
	
	<div class="actionsDiv">
	
	<form action="addNewAdmin" method="post">
	
	<h2>Add new admin</h2>
	
	To add a new admin,input the ID,user name,and the date when they started working in the boxes below
	
	<br>
	<br>
	
	Enter ID:<br><input type="text" name="newAdminID">
	
	<br>
	<br>
	
	Enter User name:<input type="text" name="newAdminName">
	
	<br>
	<br>
	
	NOTE:please input data in the following form MM/DD/YYYY
	
	<br>
	<br>
	
	Enter Date issued:<input type="text" name="StartedWorking">
	
	<br>
	<br>
	
	<input type="submit" class="roundButton" value="register new admin">
	
	<br>
	<br>
	
	</form>
	
	</div>
	
	<div class="actionsDiv">

	<form action="removeUser" method="post">
	
	<h2>Remove user</h2>
	
	To remove a user input the user name and ID in the fields below:
	
	<br>
	<br>
	
	Enter ID:<br><input type="text" name="deleteUID">
	
	<br>
	<br>
	
	Enter user name:<br><input type="text" name="deleteUname">
	
	<br>
	<br>
	
	<input type="submit" class="roundButton" value="Delete user">
	
	</form>
	
	</div>
	
	<div class="actionsDiv">
	
	<form action="removeAdmin" method="post">
	
	<h2>Remove admin</h2>
	
	To remove an admin input the user name and ID in the fields below:
	
	<br>
	<br>
	
	Enter ID:<br><input type="text" name = "deleteAID">
	
	<br>
	<br>
	
	Enter user name:<br><input type="text" name="deleteAName">
	
	<br>
	<br>
	
	<input type="submit" class="roundButton" value="Delete admin">
	
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
	
	
	
	<%
	
	}
	
	%>
	
	</table>
	
	
	
	
</body>
</html>