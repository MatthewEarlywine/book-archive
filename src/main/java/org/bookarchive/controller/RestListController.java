package org.bookarchive.controller;

import java.util.List;

import org.bookarchive.model.Book;
import org.bookarchive.service.ListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/list/")
public class RestListController {

	Logger logger = LoggerFactory.getLogger(RestListController.class);

	@Autowired
	private ListService listService;

	@GetMapping
	public ResponseEntity<?> listAllBooks() {
		List<Book> books = listService.findAllBooks();
		if (books.isEmpty()) {
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@GetMapping(value = "/list/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getBook(@PathVariable("id") long id) {
		logger.debug("Fetching Book with id " + id);
		Book book = listService.findById(id);
		if (book == null) {
			logger.debug("No book with id " + id + " found");
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@PostMapping(value = "/list/{id}")
	public ResponseEntity<?> createBook(@RequestBody Book book, UriComponentsBuilder ucBuilder) {
		logger.debug("Creating Book " + book.getTitle());

		if (listService.doesBookExist(book)) {
			logger.debug("A Book with title " + book.getTitle() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		listService.saveBook(book);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/list/{id}").buildAndExpand(book.getId()).toUri());
		return new ResponseEntity<Book>(book, HttpStatus.CREATED);
	}

	@PutMapping(value = "/list/{id}")
	public ResponseEntity<?> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
		logger.debug("Updating Book " + id);

		Book currentBook = listService.findById(id);

		if (currentBook == null) {
			logger.debug("Book with id " + id + " not found");
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		}

		currentBook.setTitle(book.getTitle());
		currentBook.setAuthor(book.getAuthor());
		currentBook.setGenre(book.getGenre());

		listService.updateBook(currentBook);
		return new ResponseEntity<Book>(currentBook, HttpStatus.OK);
	}

	@DeleteMapping(value = "/list/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") long id) {
		logger.debug("Fetching & Deleting Book with id " + id);

		Book book = listService.findById(id);
		if (book == null) {
			logger.debug("Unable to delete. Book with id " + id + " not found");
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		}

		listService.deleteBookById(id);
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping(value = "/list/")
	public ResponseEntity<Book> deleteAllBooks() {
		logger.debug("Deleting All Books");

		listService.deleteAllBooks();
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}

}