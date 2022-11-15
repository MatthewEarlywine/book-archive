<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Favorite Books List</title>
     <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="ListController as ctrl">
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">Complete Book List</span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID</th>
                              <th>Title</th>
                              <th>Author</th>
                              <th>Genre</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="book in ctrl.books">
                              <td><span ng-bind="book.id"></span></td>
                              <td><span ng-bind="book.title"></span></td>
                              <td><span ng-bind="book.author"></span></td>
                              <td><span ng-bind="book.genre"></span></td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      <script src="<c:url value='/resources/static/js/app.js' />"></script>
      <script src="<c:url value='/resources/static/js/service/listService.js' />"></script>
      <script src="<c:url value='/resources/static/js/controller/listController.js' />"></script>
  </body>
</html>