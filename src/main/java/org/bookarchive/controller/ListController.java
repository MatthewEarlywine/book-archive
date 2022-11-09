package org.bookarchive.controller;

import java.util.List;

import org.bookarchive.model.Book;
import org.bookarchive.service.ListServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {

	List<Book> books = ListServiceImpl.listStarterBooks();

	@GetMapping("/getList")
	public ModelAndView getBookListHome() {

		ModelAndView mv = new ModelAndView("bookListHome");

		mv.addObject("test", "Testing");
		mv.addObject("books", books);
		return mv;
	}

}
