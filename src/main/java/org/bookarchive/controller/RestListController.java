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
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/bookarchive")
@Configuration
@ComponentScan("org.bookarchive")
public class RestListController {

	Logger logger = LoggerFactory.getLogger(RestListController.class);

	@Autowired
	private ListService bookList;

	List<Book> books;
	ModelAndView mv = new ModelAndView("bookList");

	@GetMapping
	public ModelAndView getBookListHome(@ModelAttribute("books") List<Book> books) {

		mv.addObject("books", books);
		return mv;
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getBook(@PathVariable("id") Long id) {
		logger.debug("Fetching Book with id " + id);
		Book book = bookList.findById(id);
		if (book == null) {
			logger.debug("No book with id " + id + " found");
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@GetMapping("/findBook")
	public ModelAndView getFindBookPage() {

		return new ModelAndView("findBook");
	}
	
//	###  Originally was going to use a search page with selector input ### 
	
//	@PostMapping("/findBook")   
//	public ModelAndView submitFindBookPage(ModelAndView getFindBookPage, @ModelAttribute("book") Book book,
//			@RequestParam(value="criteria") String criteria, @RequestParam(value="field") String field) {
//
//		List<Book> foundBooks = new ArrayList<Book>();
//		
//		if (criteria == "id") {
//			Long soughtId = Long.parseLong(field);
//			foundBooks.add(bookList.findById(soughtId));
//		} else if (criteria == "title") {
//			for(Book b : books) {
//				if (b.getTitle() == field) { foundBooks.add(b); }
//				}
//			foundBooks.add(bookList.findByTitle(field));
//		}
//		mv.addObject(foundBooks);
//		return mv;
//	}
	
	
	@GetMapping("/addBook")
	public ModelAndView getAddBookPage() {

		return new ModelAndView("addBook");
	}

	@PostMapping("/addBook")
	public ModelAndView submitAddBookPage(ModelAndView getAddBookPage, @ModelAttribute("book") Book book) {

		if (book != null && (book.getTitle() != null && !book.getTitle().equals(""))
				&& (book.getAuthor() != null && !book.getAuthor().equals(""))) {

			book.setTitle(book.getTitle());
			book.setAuthor(book.getAuthor());

			if (book.getSeries() == null) {
				book.setSeries("");
			} else {
				book.setSeries(book.getSeries());
			}
			
			if (book.getGenre() == null) {
				book.setGenre("");
			} else {
				book.setGenre(book.getGenre());
			}

			if (book.getIllustrator() == null) {
				book.setIllustrator("");
			} else {
				book.setIllustrator(book.getIllustrator());
			}

			bookList.saveBook(book);

			mv.addObject("book", books);
			return mv;
		} else {
			mv.addObject("error", "Both Title and Author of book are required.");
			return getAddBookPage;
		}

	}

	@PutMapping(value = "{id}")
	public ResponseEntity<?> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
		logger.debug("Updating Book " + id);

		Book currentBook = bookList.findById(id);

		if (currentBook == null) {
			logger.debug("Book with id " + id + " not found");
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		}

		currentBook.setTitle(book.getTitle());
		currentBook.setAuthor(book.getAuthor());
		currentBook.setGenre(book.getGenre());

		bookList.updateBook(currentBook);
		return new ResponseEntity<Book>(currentBook, HttpStatus.OK);
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
		logger.debug("Fetching & Deleting Book with id " + id);

		Book book = bookList.findById(id);
		if (book == null) {
			logger.debug("Unable to delete. Book with id " + id + " not found");
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		}

		bookList.deleteBookById(id);
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}

}