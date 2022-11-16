package org.bookarchive.service;

import java.util.List;

import org.bookarchive.model.Book;

public interface ListService {

	public Book findById(long id);

	public Book findByTitle(String title);

	public List<Book> saveBook(Book book);

	public void updateBook(Book book);

	public void deleteBookById(long id);

	public List<Book> findAllBooks();

	public void deleteAllBooks();

	public boolean doesBookExist(Book book);

}
