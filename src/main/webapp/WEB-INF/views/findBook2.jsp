<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

<head>
	<title>Book Archive</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="/static/css/app.css" rel="stylesheet"></link>
</head>

    <body>
        <br>
        <div class="belch" ng-controller="RestListController as ctrl">
            <div class="panel panel-default">
                <div class="panel-heading text-light"><span class="lead">Game Registration Form </span></div>
                <div class="formcontainer">
                    <form ng-submit="ctrl.createBook()" name="bookForm" class="form-horizontal">
                        <input type="hidden" ng-model="ctrl.book.id" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable text-light" for="book_title">Title*</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.book.title" id="book_title" class="book_title form-control input-sm" placeholder="Enter the name of the new book [required]" required ng-minlength="3" />
                                </div>
                            </div>
                        </div>


                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable text-light" for="book_genre">Book Genre</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.book.genre" id="book_genre" class="form-control input-sm" placeholder="Enter the genre of the new book" />
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-actions floatRight">
                                <input data-ng-if="!ctrl.book || !ctrl.book.id" type="submit" value="Add" class="btn btn-primary btn-sm">
                                <button data-ng-if="ctrl.book.id" type="submit" class="btn btn-primary btn-sm">Update</button>
                                <button data-ng-if="ctrl.book" type="reset" class="btn btn-secondary btn-sm">Clear</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
                        
            <div class="panel panel-default mt-3">
                <!-- Default panel contents -->
                <div class="panel-heading text-light">
                	<span class="lead">List of all current books</span>
                	<span data-ng-if="ctrl.genres.length > 1"><span class="lead"> | </span>
                	</span>
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
       </div>
	  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
      <script src="/static/js/app.js"></script>
      <script src="/static/js/service/listService.js"></script>
      <script src="/static/js/controller/listController.js"></script>
</body>
</html></html>