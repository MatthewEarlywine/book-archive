'use strict';

angular.module('myApp').controller('ListController', ['$scope', '$log' ,'ListService', function($scope, $log, ListService) {
    var self = this;
    self.book = { id: null, title: '', series: '', author: '', illustrator: '', genre: ''};
    self.books = [];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllBooks();

    function fetchAllBooks(){
        ListService.fetchAllBooks()
            .then(
            function(d) {
                self.books = d;
            },
            function(errResponse){
                $log.error('Error while fetching Books ', errResponse);
            }
        );
    }


	function searchForBookById(){
		ListService.searchForBookById(id)
			.then(
			function(d) {
				self.book = d;
			},
			function(errResponse){
                $log.error('Error while fetching Book ', errResponse);
            }
        );
	}
	
	function searchForBookByTitle(){
		ListService.searchForBookByTitle(title)
			.then(
			function(d) {
				self.book = d;
			},
			function(errResponse){
                $log.error('Error while fetching Book ', errResponse);
            }
        );
	}

    function createBook(book){
        ListService.createBook(book)
            .then(
            fetchAllBooks,
            function(errResponse){
                $log.error('Error while creating Book ', errResponse);
            }
        );
    }

    function updateBook(book){
        ListService.updateBook(book)
            .then(
            fetchAllBooks,
            function(errResponse){
                $log.error('Error while updating Book ', errResponse);
            }
        );
    }

    function deleteBook(book){
        ListService.deleteBook(book)
            .then(
            fetchAllBooks,
            function(errResponse){
                $log.error('Error while deleting Book ', errResponse);
            }
        );
    }

    function submit() {
        if(self.book.id===null){
            $log.log('Saving New Book', self.book);
            createBook(self.book);
        }else{
            updateBook(self.book, self.book.id);
            $log.log('Book updated with id ', self.book.id);
        }
        reset();
    }

    function edit(book){
    	var id = book.id;
        $log.log('id to be edited', id);
        for(var i = 0; i < self.books.length; i++){
            if(self.books[i].id === id) {
                self.book = angular.copy(self.books[i]);
                break;
            }
        }
    }

    function remove(book){
        $log.log('id to be deleted', book.id);
        //clean form after book is deleted
        if(self.book.id === book.id) { 
            reset();
        }
        deleteBook(book);
    }


    function reset(){
        self.book={id: null, title: '', author: '', genre: ''};
        $scope.myForm.$setPristine();
    }

}]);