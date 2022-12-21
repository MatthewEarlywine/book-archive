package org.bookarchive.webapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.bookarchive.webapp.manager.ListManager;
import org.bookarchive.webapp.model.BookView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/favoritebooks/")
//@Configuration
//@ComponentScan("org.bookarchive")
public class RestListController {

	Logger logger = LoggerFactory.getLogger(RestListController.class);

	@Autowired
	private ListManager bookManager;

	
	ModelAndView mv = new ModelAndView("bookList");
//
//	@GetMapping
//	public ModelAndView getBookListHome() {
//			
//		return mv;
//	}

//  -----  Just the views that frame the data; js service and controller call and organize data from Back End --------------
	
	@GetMapping          
	public ModelAndView getAllBooks(){

		ResponseEntity<BookView[]> books = bookManager.findAllBooks();
		
		List<Object> bookList = Arrays.stream(books.getBody()).collect(Collectors.toList());
		
		//mv.addObject("bookList", bookList);
		
//		ModelAndView allBooks = new ModelAndView.add("bookList", new Map <"books", ResponseEntity<BookView[]>> , HttpStatus.OK);
		
		return mv;
	}
	
	
/*	ModelAndView mv = new ModelAndView("bookList");

	 

	List<Book> bookList = Arrays.stream(books.getBody())

	  .collect(Collectors.toList());

	 

	mv.addObject( attributeName, bookList);

	return mv;    */
	
	
//	@GetMapping(value = "/checkBook", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Boolean> checkBook(Book book){
//		System.out.println("Checking if book exists REST.");
//		System.out.println(book.getTitle() + " 1");
//		Boolean answer = bookManager.doesBookExist(book);
//		return new ResponseEntity<Boolean>(answer, HttpStatus.OK);
//	}
//	
//	@GetMapping(value = "test")
//	public ResponseEntity<String> testMethod(){
//		return new ResponseEntity<String>("test", HttpStatus.OK);
//	}
//	
//	@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> getBookById(@PathVariable("id") Long id){
//		
//		return bookManager.findById(id);
//	}
//
//	
//	@GetMapping(value = "title/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> getBookByTitle(@PathVariable("title") String title){
//
//		return bookManager.findByTitle(title);
//	}
//	
//	@PostMapping(value = "saveBook")
//	public ResponseEntity<?> saveBook(@RequestBody BookView book){
//		
//		return bookManager.saveBook(book);
//	}
//
//	@PutMapping(value = "{id}")
//	public ResponseEntity<?> updateBook(@PathVariable("id") Long id, @RequestBody BookView book) {
//		logger.debug("Updating Book " + id);
//		
//		return bookManager.updateBook(book);
//	}
//
//	@DeleteMapping(value = "delete/{id}")
//	public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
//		logger.debug("Fetching & Deleting Book with id " + id);
//
//		bookManager.deleteBookById(id);
//		
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}

}