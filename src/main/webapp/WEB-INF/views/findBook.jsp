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
	<h2>Find a Book in the Archive</h2><BR>
	
	<div class="belch">
    	<form action="/bookarchive/findBook" method="post" modelAttribute="book" align="center">
    		<label>Search by: 
    			<select name="criteria">
			    	<option value="0">ID:  <input type="text" name="id" /></option><br><br>
			    	<option value="1">Title:  <input type="text" name="title" /></option><br><br>
			    </select>
        	</label>
        	
        	<!-- Search through table for book.id or book.title, OR book.${name} -->
        	
	        <a href="/bookarchive">
	        <input type="submit" value="Search for book"/>
	        </a>
        	<p style="color: red">${error}</p>
    	</form><br>
	
	
			<a href="/bookarchive">
			<button>See our full list of books</button>
			</a><br><br>
	</div>
</div>
	  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
      <script src="/static/js/app.js"></script>
      <script src="/static/js/service/listService.js"></script>
      <script src="/static/js/controller/listController.js"></script>
</body>
</html>