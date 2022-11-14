package org.bookarchive.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.bookarchive.model.Book;
import org.bookarchive.service.ListServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/favoritebooks")
public class ListController {

	private AtomicLong counter = new AtomicLong();
	List<Book> books = ListServiceImpl.listStarterBooks();
	ModelAndView mv = new ModelAndView("bookList");

	@GetMapping
	public ModelAndView getBookListHome() {

		mv.addObject("test", "Testing");
		mv.addObject("books", books);
		return mv;
	}

	@GetMapping("/addBook")
	public ModelAndView getAddBookPage() {

		ModelAndView mv = new ModelAndView("addBook");
		return mv;
	}

	@PostMapping("/addBook")
	public ModelAndView submit(ModelAndView getAddBookPage, @ModelAttribute("book") Book book) {

		if (book != null && (book.getTitle() != null && !book.getTitle().equals(""))
				&& (book.getAuthor() != null && !book.getAuthor().equals(""))) {

			if (book.getGenre() == null) {
				book.setGenre("");
			}

			String title = book.getTitle();
			String author = book.getAuthor();
			String genre = book.getGenre();

			books.add(new Book(counter.incrementAndGet(), title, author, genre));
			mv.addObject("book", books);
			return mv;
		} else {
			mv.addObject("error", "Both Title and Author of book are required.");
			return getAddBookPage;
		}

	}
}
