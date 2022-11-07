package org.bookarchive;

import org.bookarchive.controller.BookController;
import org.bookarchive.model.Book;

public class Main {

	public static void main(String[] args) {
		Book model = retrieveBook();
		BookController controller = new BookController(model);
		controller.updateView();

		controller.setGenre("Horror");
		controller.updateView();

	}

	private static Book retrieveBook() {
		Book book = new Book();
		book.setTitle("Frankenstein, the Modern Prometheus");
		book.setGenre("Science-Fiction");
		book.setAuthor("Shelley, Mary");
		return book;
	}
}
