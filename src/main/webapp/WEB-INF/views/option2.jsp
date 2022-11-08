<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Home</title>
     <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="ListController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading">
              	<span class="lead">Game Registration Form </span>
              	<a class="floatRight" style="font-size:18px" href="/GameRate/home" id="homeLink">Home</a>
              </div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.book.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Title</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.book.title" name="title" class="form-control input-sm" placeholder="Enter the book's title" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.title.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Comment</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.book.author" name="author" class="form-control input-sm" placeholder="Enter your authors for the book. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Rating</label>
                              <div class="col-md-7">
                                  <input type="number" ng-model="ctrl.book.genre" name="genre" class="form-control input-sm" placeholder="Enter your genre for the book 1-5" required min="1" max="5"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.genre.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.book.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Games </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID</th>
                              <th>Title</th>
                              <th>Comment</th>
                              <th>Rating</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="book in ctrl.books">
                              <td><span ng-bind="book.id"></span></td>
                              <td><span ng-bind="book.title"></span></td>
                              <td><span ng-bind="book.author"></span></td>
                              <td><span ng-bind="book.genre"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(book.id)" class="btn btn-success custom-width">Edit</button>
                              <button type="button" ng-click="ctrl.remove(book.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
  </body>
</html>