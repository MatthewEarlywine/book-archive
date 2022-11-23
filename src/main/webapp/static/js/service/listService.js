'use strict';

angular.module('myApp').factory('ListService', ListServiceFactory)

ListServiceFactory.$inject = ['$http', '$log']

function ListServiceFactory($http, $log) {
	let REST_SERVICE_URI = 'http://localhost:8081/favoritebooks/';

    let factory = {
        fetchAllBooks: fetchAllBooks,
        createBook: createBook,
        updateBook:updateBook,
        deleteBook:deleteBook
    };

    return factory;

    function fetchAllBooks() {
        return $http.get(REST_SERVICE_URI).then(
			function (response) {
                return response.data;
            },
            function (errResponse) {
                $log.error('Error while fetching Books ', errResponse);
            }
        );
    }
    
    function searchForBookById() {
		return $http.post(REST_SERVICE_URI).then(
			function (response) {
				return response.data;
			},
			function (errResponse) {
				$log.error('Error while fetching Book ', errResponse);
			}
		);
	}
	
	function searchForBookByTitle() {
		return $http.post(REST_SERVICE_URI).then(
			function (response) {
				return response.data;
			},
			function (errResponse) {
				$log.error('Error while fetching Book ', errResponse);
			}
		);
	}

    function createBook(book) {
        return $http.post(REST_SERVICE_URI, book).then(
            function (response) {
                return response.data;
            },
            function(errResponse){
                $log.error('Error while creating Book', errResponse);
            }
        );
    }


    function updateBook(book) {
        return $http.put(REST_SERVICE_URI + book.id, book).then(
            function (response) {
                return response.data
            },
            function(errResponse){
                $log.error('Error while updating Book', errResponse);
            }
        );
    }

    function deleteBook(book) {
        return $http.delete(REST_SERVICE_URI + book.id).then(
            function (response) {
                return response.data
            },
            function(errResponse){
                $log.error('Error while deleting Book', errResponse);
            }
        );
    }
}