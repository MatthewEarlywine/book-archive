package org.bookarchive;

import org.bookarchive.controller.ListController;
import org.bookarchive.model.Book;

public class Main {

	public static void main(String[] args) {
		Book model = retrieveBook();
		ListController controller = new ListController(model);
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
