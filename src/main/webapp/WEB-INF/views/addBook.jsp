<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Book Archive</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="/static/css/app.css" rel="stylesheet"></link>
</head>

<body>

<div align="center">
	<h2>Add a new book to the Archive</h2><BR>
	
	<div class="belch">
    <form action="/api/favoritebooks/addBook" method="post" modelAttribute="book" align="center">
    <br><br><label>Title:  <input type="text" name="title" required="required"/></label><br><br>
    	<label>Series:  <input type="text" name="series"/></label><br><br>
        <label>Author:  <input type="text" name="author" required="required"/></label><br><br>
        <label>Illustrator:  <input type="text" name="illustrator" /></label><br><br>
        <label>Genre:  <input type="text" name="genre" /></label><br><br>
        <a href="/api/favoritebooks">
        <input type="submit" value="Submit new book"/>
        </a>
        <p style="color: red">${error}</p>
    </form><br>
	
	
	<a href="/api/favoritebooks">
	<button>See our list of books</button>
	</a><br><br>
	</div>
</div>
	  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
      <script src="/static/js/app.js"></script>
      <script src="/static/js/service/listService.js"></script>
      <script src="/static/js/controller/listController.js"></script>
</body>
</html>