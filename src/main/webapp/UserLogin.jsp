<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="HomePageStyle.css">
<title>User Login</title>
</head>
<body>
	
	<%
	
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
	%>
	
	<div class="HomePage">
	<div class="centered-content">
	
	<h2>Input credentials</h2>
	
	<form action="ULogin" method="post">
	
	Enter your ID:<input type="text" name="uname">
	
	<br>
	<br>
	
	Enter your user name:<input type="text" name = "uID">
	
	<br>
	<br>
	
	<input type="submit" class="roundButton" value="Login">

	</form>
	
	</div>
	</div>
	
</body>
</html>