<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="HomePageStyle.css">
<meta charset="UTF-8">
<title>Admin Login</title>
</head>
<body>	

	<%
	
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
	%>

	<div class="HomePage">
	<div class="centered-content">

	<h2>Input credentials</h2>

	<form action="ALogin" method="post">
	
	Enter your ID:<input type="text" name="aID">
	
	<br>
	<br>
	
	Enter your user name:<input type="text" name="aUname">
	
	<br>
	<br>
	
	<input type="submit" class="roundButton" value="Login"> 
	
	
	</form>
	
	</div>
	</div>

</body>
</html>