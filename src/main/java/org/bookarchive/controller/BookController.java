package org.bookarchive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

	@GetMapping("/book")
	public String getBookPage() {
		return "book";
	}

}
