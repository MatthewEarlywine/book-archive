'use strict';

angular.module('myApp').factory('ListService', ListServiceFactory)

ListServiceFactory.$inject = ['$http', '$log']

function ListServiceFactory($http, $log) {
	let REST_SERVICE_URI = 'http://localhost:8080/api/favoritebooks/';

    let factory = {
        fetchAllBooks: fetchAllBooks,
        createBook: createBook,
        updateBook: updateBook,
        deleteBook: deleteBook,
        doesBookExist: doesBookExist, 
    };

    return factory;

    function fetchAllBooks() {
        return $http.get('http://localhost:8080/api/favoritebooks/').then(
			function (response) {
                return response.data;
            },
            function (errResponse) {
                $log.error('Error while fetching Books ', errResponse);
            }
        );
    }
    
    function doesBookExist(book){
		$log.log("Checking if book exists JS.");
		$log.log(book);
		return $http.get('http://localhost:8080/api/favoritebooks/checkBook', book).then(
			function (response) {
				$log.log(response);
				return response.data;
			},
			function (errResponse) {
				$log.error('Error while checking Book ', errResponse);
			}
		);
	}
    
    function searchForBookById() {
		return $http.post("http://localhost:8080/api/favoritebooks/" + book.id, book).then(
			function (response) {
				return response.data;
			},
			function (errResponse) {
				$log.error('Error while fetching Book ', errResponse);
			}
		);
	}
	
	function searchForBookByTitle() {
		return $http.post("http://localhost:8080/api/favoritebooks/title/" + book.title, book).then(
			function (response) {
				return response.data;
			},
			function (errResponse) {
				$log.error('Error while fetching Book ', errResponse);
			}
		);
	}

    function createBook(book) {
        return $http.post('http://localhost:8080/api/favoritebooks/saveBook', book).then(
            function (response) {
                return response.data;
            },
            function(errResponse){
                $log.error('Error while creating Book', errResponse);
            }
        );
    }


    function updateBook(book) {
        return $http.put('http://localhost:8080/api/favoritebooks/' + book.id, book).then(
            function (response) {
                return response.data
            },
            function(errResponse){
                $log.error('Error while updating Book', errResponse);
            }
        );
    }

    function deleteBook(book) {
        return $http.delete("http://localhost:8080/api/favoritebooks/delete/" + book.id).then(
            function (response) {
                return response.data
            },
            function(errResponse){
                $log.error('Error while deleting Book', errResponse);
            }
        );
    }
}