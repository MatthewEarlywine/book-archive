package org.bookarchive.service;

import java.util.List;

import org.bookarchive.model.Book;

public interface ListService {

	Book findById(long id);

	Book findByTitle(String title);

	void saveBook(Book book);

	void updateBook(Book book);

	void deleteBookById(long id);

	List<Book> findAllBooks();

	void deleteAllBooks();

	public boolean doesBookExist(Book book);

}
