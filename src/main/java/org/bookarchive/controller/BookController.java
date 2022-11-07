package org.bookarchive.controller;

import org.bookarchive.model.Book;

public class BookController {
	private Book model;

	public BookController(Book model) {
		this.model = model;
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
		printBookInfo(model.getTitle(), model.getGenre(), model.getAuthor());
	}

	private void printBookInfo(String title, String genre, String author) {
		// TODO Auto-generated method stub

	}
}
