package org.bookarchive.controller;

import java.util.List;

import org.bookarchive.model.Book;
import org.bookarchive.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/favoritebooks")
@Configuration
@ComponentScan("org.bookarchive")
public class ListController {

	@Autowired
	ListService listService; // = new ListServiceImpl();

	List<Book> books;
	ModelAndView mv = new ModelAndView("bookList");

	@GetMapping
	public ModelAndView getBookListHome(@ModelAttribute("books") List<Book> books) {
		
		mv.addObject("books", books);
		return mv;
	}

	@GetMapping("/addBook")
	public ModelAndView getAddBookPage() {

		return new ModelAndView("addBook");
	}

	@PostMapping("/addBook")
	public ModelAndView submit(ModelAndView getAddBookPage, @ModelAttribute("book") Book book) {

		if (book != null && (book.getTitle() != null && !book.getTitle().equals(""))
				&& (book.getAuthor() != null && !book.getAuthor().equals(""))) {

			book.setTitle(book.getTitle());
			book.setAuthor(book.getAuthor());

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

			listService.saveBook(book);

			mv.addObject("book", books);
			return mv;
		} else {
			mv.addObject("error", "Both Title and Author of book are required.");
			return getAddBookPage;
		}

	}
}
