<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Book Archive</title>

</head>

<body>

<div align="center">
	<h2>Complete Book List</h2><BR>
	
	<table border="1">
		<tr>
			<th>Book Id</th>
			<th>Title</th>
			<th>Author</th>
			<th>Illustrator</th>
			<th>Genre</th>
		</tr>
		<c:forEach  var="book" items="${books}">
			<tr>
				<td>${book.id}</td>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.illustrator}</td>
				<td>${book.genre}</td>
			</tr>
		</c:forEach>
	</table>
</div>
	  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
      <script src="/static/js/app.js"></script>
      <script src="/static/js/service/listService.js"></script>
      <script src="/static/js/controller/listController.js"></script>
</body>
</html>