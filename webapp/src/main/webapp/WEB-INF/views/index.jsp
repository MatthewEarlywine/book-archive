<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Archive</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="/static/css/app.css" rel="stylesheet"></link>
</head>
<body class="text-center">
	<form action="login" method="POST">
		<div align="center">
			<h2 class="siteTitle">Book Archive</h2><br>
			<div class="belch">
			<p class="userNameBanner">User Name:</p>
			<input class="userNameInput" type="text" name="username"><br>
			<p class="passwordBanner"> Password:</p>
			<input class="passwordInput" type="password" name="password"><br><br>
			<input type="submit" name="submitLogIn">
			<p class="errorMessage" style="color: red">${error}</p>
			</div>
		</div>
	</form>		
</body>
</html>