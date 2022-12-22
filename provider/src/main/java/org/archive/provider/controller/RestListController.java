package org.archive.provider.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PostLoad;

import org.archive.provider.entity.Book;
import org.archive.provider.service.ListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/favoritebooks/")
public class RestListController {

	Logger logger = LoggerFactory.getLogger(RestListController.class);

	@Autowired
	private ListService bookService;

	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> bookList = bookService.findAllBooks();

		if(!(bookList != null)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
	}
	
	@GetMapping(value = "test")
	public ResponseEntity<String> testMethod(){
		return new ResponseEntity<String>("test", HttpStatus.OK);
	}
	
	@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getBookById(@PathVariable("id") Long id){
		
        if (bookService.doesIDExist(id)) {
        	Book book = bookService.findById(id);
        	return new ResponseEntity<>(book, HttpStatus.OK);
        }
		
		return new ResponseEntity<String>("No book with ID: " + id + " was found", HttpStatus.CONFLICT);
	}
	
	@GetMapping(value = "title/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getBookByTitle(@PathVariable("title") String title){
		Book book = bookService.findByTitle(title);
        if (book == null) {
            return new ResponseEntity<String>("No book titled " + title + " was found.", HttpStatus.CONFLICT);
        }
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@PostMapping(value = "saveBook")
	public ResponseEntity<?> saveBook(@RequestBody Book book){
        if (bookService.doesBookExist(book)) {
            logger.debug("A book with title " + book.getTitle() + " authored by " + book.getAuthor() + " is already listed");
            System.out.println("A book with title " + book.getTitle() + " authored by " + book.getAuthor() + " is already listed");
            return new ResponseEntity<String>("A book with title " + book.getTitle() + " authored by " + book.getAuthor() + " is already listed",HttpStatus.CONFLICT);
        }
		bookService.saveBook(book);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<?> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
		logger.debug("Updating Book " + id);

		bookService.updateBook(book);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@DeleteMapping(value = "delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
		logger.debug("Fetching & Deleting Book with id " + id);

		bookService.deleteBookById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}