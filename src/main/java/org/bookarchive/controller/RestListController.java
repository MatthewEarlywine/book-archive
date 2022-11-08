package org.bookarchive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestListController {

	@GetMapping("/list")
	public String getBookListHome() {
		return "bookListHome";
	}

//	public void updateView() {
//		printBookInfo(book.getTitle(), book.getGenre(), book.getAuthor());
//	}
//
//	private void printBookInfo(String title, String genre, String author) {
//		// TODO Auto-generated method stub
//
//	}
}
