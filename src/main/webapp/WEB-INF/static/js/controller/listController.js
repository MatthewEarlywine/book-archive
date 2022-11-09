'use strict';
 
angular.module('myApp').controller('ListController', ['$scope','$attrs', '$http', 'ListService', function($scope, ListService) {
    var self = this;
    self.book = { id: '', title:'', author: '', genre:'' }
    self.books = [];

    findAllBooks();
 
    function findAllBooks(){
	console.log('id to be read');
    	ListService.findAllBooks()
            .then(
            function(d) {
                self.books = d;
                $scope.books = d;
            },
            function(errResponse){
                console.error('Error while fetching products');
            }
        );
    }       
}]);