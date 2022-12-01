package org.bookarchive.controller;

import java.util.ArrayList;
import java.util.List;

import org.bookarchive.model.Book;
import org.bookarchive.service.ListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/favoritebooks")
@Configuration
@ComponentScan("org.bookarchive")
public class RestListController {

	Logger logger = LoggerFactory.getLogger(RestListController.class);

	@Autowired
	private ListService bookService;

	
	ModelAndView mv = new ModelAndView("bookList");

	@GetMapping
	public ModelAndView getBookListHome() {
			
		return mv;
	}

	@GetMapping(value = "/getAllBooks")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> books = bookService.findAllBooks();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
//	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> getBook(@PathVariable("id") Long id) {
//		logger.debug("Fetching Book with id " + id);
//		Book book = bookService.findById(id);
//		if (book == null) {
//			logger.debug("No book with id " + id + " found");
//			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<Book>(book, HttpStatus.OK);
//	}

//	@GetMapping("/findBook")
//	public ModelAndView getFindBookPage() {
//
//		return new ModelAndView("findBook");
//	}
//	
//	###  Originally was going to use a search page with selector input ### 
	
//	@PostMapping("/findBook")   
//	public ModelAndView submitFindBookPage(ModelAndView getFindBookPage, @ModelAttribute("book") Book book,
//			@RequestParam(value="criteria") String criteria, @RequestParam(value="field") String field) {
//		
//		List<Book> foundBooks = new ArrayList<Book>();
//		
//		if (criteria == "id") {
//			Long soughtId = Long.parseLong(field);
//			foundBooks.add(bookService.findById(soughtId));
//		} else if (criteria == "title") {
//			for(Book b : bookService.findAllBooks()) {
//				if (b.getTitle() == field) { foundBooks.add(b); }
//				}
//			foundBooks.add(bookService.findByTitle(field));
//		}
//		mv.addObject(foundBooks);
//		return mv;
//	}
	
	
//	@GetMapping("/addBook")
//	public ModelAndView getAddBookPage() {
//
//		return new ModelAndView("addBook");
//	}
	
	@PostMapping(value = "/saveBook")
	public ResponseEntity<Book> saveBook(@RequestBody Book book){
		bookService.saveBook(book);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

//	@PostMapping
//	public ModelAndView submitAddBookPage(ModelAndView getAddBookPage, @ModelAttribute("book") Book book) {
//
//		if (book != null && (book.getTitle() != null && !book.getTitle().equals(""))
//				&& (book.getAuthor() != null && !book.getAuthor().equals(""))) {
//
//			
//			book.setTitle(book.getTitle());
//			book.setAuthor(book.getAuthor());
//
//			if (book.getSeries() == null) {
//				book.setSeries("");
//			} else {
//				book.setSeries(book.getSeries());
//			}
//			
//			if (book.getGenre() == null) {
//				book.setGenre("");
//			} else {
//				book.setGenre(book.getGenre());
//			}
//
//			if (book.getIllustrator() == null) {
//				book.setIllustrator("");
//			} else {
//				book.setIllustrator(book.getIllustrator());
//			}
//
//			bookService.saveBook(book);
//			bookService.findAllBooks();
//			
//			return mv;
//		} else {
//			mv.addObject("error", "Both Title and Author of book are required.");
//			return getAddBookPage;
//		}
//
//	}

	@PutMapping(value = "{id}")
	public ResponseEntity<?> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
		logger.debug("Updating Book " + id);

		Book currentBook = bookService.findById(id);

		if (currentBook == null) {
			logger.debug("Book with id " + id + " not found");
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		}

		currentBook.setTitle(book.getTitle());
		currentBook.setSeries(book.getSeries());
		currentBook.setAuthor(book.getAuthor());
		currentBook.setIllustrator(book.getIllustrator());
		currentBook.setGenre(book.getGenre());

		bookService.updateBook(currentBook);
		return new ResponseEntity<Book>(currentBook, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
		logger.debug("Fetching & Deleting Book with id " + id);

		Book book = bookService.findById(id);
		if (book == null) {
			logger.debug("Unable to delete. Book with id " + id + " not found");
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		}

		bookService.deleteBookById(id);
		
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}

}