package org.bookarchive.controller;

import org.bookarchive.model.Book;
import org.bookarchive.view.BookList;

public class BookController {
	private Book model;
	private BookList view;

	public BookController(Book model, BookList view) {
		this.model = model;
		this.view = view;
	}

	public String getTitle() {
		return model.getTitle();
	}

	public void setTitle(String title) {
		model.setTitle(title);
	}

	public String getAuthor() {
		return model.getAuthor();
	}

	public void setAuthor(String author) {
		model.setAuthor(author);
	}

	public String getGenre() {
		return model.getGenre();
	}

	public void setGenre(String genre) {
		model.setGenre(genre);
	}

	public void updateView() {
		view.printBookInfo(model.getTitle(), model.getGenre(), model.getAuthor());
	}
}
