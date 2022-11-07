package org.bookarchive.controller;

import org.bookarchive.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ListController {
	private Book book;

	public void updateView() {
		printBookInfo(book.getTitle(), book.getGenre(), book.getAuthor());
	}

	private void printBookInfo(String title, String genre, String author) {
		// TODO Auto-generated method stub

	}
}
