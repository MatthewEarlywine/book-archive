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
	
	<div ng-controller="RestListController as ctrl" class="belch">
    	<form ng-submit="ctrl.findBook()" modelAttribute="book" align="center">
    		<label>Search by: 
    			<select name="book">
			    	<option value="id">ID: </option>
			    	<option value="title">Title: </option>
			    </select>
			    <input type="text" name="field" id="field" ng-model="${book.value}" />
        	</label>
        	
	        <a href="/bookarchive">
	        <input type="submit" value="Search for book"/>
	        </a>
        	<p style="color: red">${error}</p>
    	</form><br>	

	</div>
</div>

<div class="tablecontainer" align="center">
        	<table class="belch">
            	<thead>
                	<tr>
                    	<th>Book ID</th>
                        <th>Title</th>
                        <th>Series</th>
                        <th>Author</th>
                        <th>Illustrator</th>
                        <th>Genre</th>
                        <th width="20%"></th>
                        <th width="20%"></th>
                        <th width="20%"></th>
                    </tr>
                </thead>
                <tbody>
                	<tr ng-repeat="currentBook in ctrl.books">
                    	<td><span ng-bind="currentBook.id"></span></td>
                        <td><span ng-bind="currentBook.title"></span></td>
                        <td><span ng-bind="currentBook.series"></span></td>
                        <td><span ng-bind="currentBook.author"></span></td>
                        <td><span ng-bind="currentBook.illustrator"></span></td>
                        <td><span ng-bind="currentBook.genre"></span></td>
                        <td></td>
                        <td><button data-ng-click="ctrl.updateBook(currentBook)" class="btn btn-secondary btn-sm">Select</button></td>
                        <td><button data-ng-click="ctrl.deleteBook(currentBook)" class="btn btn-secondary btn-sm">Delete</button></td>
                    </tr>
                </tbody>
           </table>
           			<a href="/favoritebooks">
			<button>See our full list of books</button>
			</a><br><br>
       </div>
	  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
      <script src="/static/js/app.js"></script>
      <script src="/static/js/service/listService.js"></script>
      <script src="/static/js/controller/listController.js"></script>
</body>
</html>