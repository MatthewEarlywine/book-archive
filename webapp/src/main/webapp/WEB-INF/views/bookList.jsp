<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Book Archive</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="/static/css/app.css" rel="stylesheet"></link>
     <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
</head>

<body ng-app="myApp" ng-controller="listController as ctrl">

<div align="center" class="belch">
	
	<h2 class="bookListTitle">List of Favorite Books</h2><BR>
    <form align="center" name="bookForm" ng-model="bookForm">
    <br><br><label name="titleLabel">Title:  <input ng-model="title" type="text" name="titleInput" required="required"/></label><br>
    	<label name="seriesLabel">Series:  <input ng-model="series" type="text" name="seriesInput"/></label><br>
        <label name="authorLabel">Author:  <input ng-model="author" type="text" name="authorInput" required="required"/></label><br>
        <label name="illustratorLabel">Illustrator:  <input ng-model="illustrator" type="text" name="illustratorInput" /></label><br>
        <label name="genreLabel">Genre:  <input ng-model="genre" type="text" name="genreInput" /></label><br>
        
        <br><br><input ng-if="!ctrl.book.id" name="submitBookBtn" type="submit" ng-click="submit()" value="Submit new book" />
		<input ng-if="ctrl.book.id" name="updateBookBtn" type="submit" ng-click="ctrl.update(book)" value="Update book" />

        
        <p style="color: red">${error}</p>
    </form><br>
</div>
<div align="center">
	
	<table border="1">
	<thead>
		<tr>
			<th name="columnId">Book Id</th>
			<th name="columnTitle">Title</th>
			<th name="columnSeries">Series</th>
			<th name="columnAuthor">Author</th>
			<th name="columnIllustrator">Illustrator</th>
			<th name="columnGenre">Genre</th>
		</tr>
		</thead>
		<tbody>
		<div>
			<tr id="bookList" name="bookList" ng-repeat="book in books">
				<td id="bookId-{{$index}}" name="bookId">{{book.id}}</td>
				<td id="bookTitle-{{$index}}" name="bookTitle">{{book.title}}</td>
				<td id="bookSeries-{{$index}}" name="bookSeries">{{book.series}}</td>
				<td id="bookAuthor-{{$index}}" name="bookAuthor">{{book.author}}</td>
				<td id="bookIllustrator-{{$index}}" name="bookIllustrator">{{book.illustrator}}</td>
				<td id="bookGenre-{{$index}}" name="bookGenre">{{book.genre}}</td>
				<td>
					<button type="button" ng-click="ctrl.edit(book)" id="editBtn-{{$index}}" name="editBtn" class="btn btn-success custom-width">Edit</button>
                    <button type="button" ng-click="ctrl.remove(book)" id="deleteBtn-{{$index}}" name="deleteBtn" class="btn btn-danger custom-width">Remove</button>
                </td>
			</tr>
			</div>		
		</tbody>
	</table>
</div>
	  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
      <script src="/static/js/app.js"></script>
      <script src="/static/js/service/listService.js"></script>
      <script src="/static/js/controller/listController.js"></script>

</body>
</html>