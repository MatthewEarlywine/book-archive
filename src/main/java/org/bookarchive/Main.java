package org.bookarchive;

import org.bookarchive.controller.BookController;
import org.bookarchive.model.Book;
import org.bookarchive.view.BookList;

public class Main {

	public static void main(String[] args) {
		Book model = retrieveBook();
		BookList view = new BookList();
		BookController controller = new BookController(model, view);
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
