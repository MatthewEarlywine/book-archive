'use strict';

angular.module('myApp').controller('listController', ['$scope', '$log' , 'ListService', function($scope, $log, ListService) {
    var self = this;
    self.book = { id: null, title: '', series: '', author: '', illustrator: '', genre: ''};
    $scope.books = [];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
	
	// form variables
	
	$scope.id=null;
	$scope.title='';
	$scope.series='';
	$scope.author='';
	$scope.illustrator='';
	$scope.genre='';

    findAllBooks();

    function findAllBooks(){
        ListService.fetchAllBooks()
            .then(
            function(d) {
                $scope.books = d;
            },
            function(errResponse){
                $log.error('Error while fetching Books ', errResponse);
            }
        );
    }

	$scope.submit = () => {
		var newBook = {};
		newBook.id = $scope.id;
		newBook.title = $scope.title;
		newBook.series = $scope.series;
		newBook.author = $scope.author;
		newBook.illustrator = $scope.illustrator;
		newBook.genre = $scope.genre;
		postBook(newBook);
	}

	function postBook(book){
		ListService.createBook(book)
			.then(
			function(d){
				$scope.books.push(d);
				reset();
			},
			function(errResponse){
                $log.error('Error while creating Book ', errResponse);
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
            function(){findAllBooks();},
            function(errResponse){
                $log.error('Error while updating Book ', errResponse);
            }
        );
    }

    function deleteBook(book){
        ListService.deleteBook(book)
            .then(
				function(){findAllBooks();}
            ,
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

	$scope.selectBook = function(book) {
		$log.log(book);
		self.book = angular.copy(book);
	}

    function edit(book){
    	var id = book.id;
        $log.log('id to be edited', id);
        for(var i = 0; i < $scope.books.length; i++){
            if($scope.books[i].id === id) {
                $scope.book = angular.copy($scope.books[i]);
                break;
            }
        }
    }

    function remove(book){
        $log.log('id to be deleted', book.id);
        //clean form after book is deleted
        if($scope.id === book.id) { 
            reset();
        }
        deleteBook(book);
    }


    function reset(){
        $scope.book={id: null, title: '', series: '', author: '', illustrator: '', genre: ''};
        $scope.bookForm.$setPristine();
    }

}]);