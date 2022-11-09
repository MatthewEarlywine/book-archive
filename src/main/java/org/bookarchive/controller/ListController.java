package org.bookarchive.controller;

import org.bookarchive.model.Book;
import org.bookarchive.service.ListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping(value = "/archive")
public class ListController {

	Logger logger = LoggerFactory.getLogger(ListController.class);

	@Autowired
	private ListService listService;

	@GetMapping(value = "/getAllBooks")
	public String getAllBooks(Model model) {
		model.addAttribute("books", listService.findAllBooks());
		// model.addAttribute("displayheader", true);

		return "bookListHome";
	}

	@GetMapping(value = "/addBook")
	public String addBookView(Model model) {
		model.addAttribute("book", new Book());
		// model.addAttribute("displayheader", true);
		return "addBook";
	}

	@PostMapping(value = "/addBook")
	public RedirectView addBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
		Book bookAdded = listService.saveBook(book);
		if (bookAdded != null) {
			redirectAttributes.addFlashAttribute("savedBook", bookAdded);
			redirectAttributes.addFlashAttribute("addBookSuccess", true);

		} else {
			redirectAttributes.addFlashAttribute("bookExists", true);
			redirectAttributes.addFlashAttribute("addBookSuccess", false);
			redirectAttributes.addFlashAttribute("savedBook", book);

		}
		final RedirectView redirectView = new RedirectView("/archive/addBook", true);
		// redirectAttributes.addFlashAttribute("displayheader", true);
		return redirectView;
	}

	@GetMapping(value = "/updateBook")
	public String updateBookView(Model model) {
		model.addAttribute("book", new Book());
		// model.addAttribute("displayheader", true);
		return "updateBook";
	}

	@PostMapping(value = "/updateBook")
	public RedirectView updateBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
		Book bookUpdated = listService.updateBook(book);
		if (bookUpdated != null) {
			redirectAttributes.addFlashAttribute("updatedBook", bookUpdated);
			redirectAttributes.addFlashAttribute("updateBookSuccess", true);

		} else {
			redirectAttributes.addFlashAttribute("bookDoesNotExist", true);
			redirectAttributes.addFlashAttribute("updateBookSuccess", false);
			redirectAttributes.addFlashAttribute("updatedBook", book);

		}
		final RedirectView redirectView = new RedirectView("/archive/updateBook", true);
		// redirectAttributes.addFlashAttribute("displayheader", true);
		return redirectView;
	}

}