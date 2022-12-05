package org.bookarchive.dao;

import java.util.List;

import org.bookarchive.model.Book;

public interface DAO {

	public Book findById(Long id);

	public Book findByTitle(String title);

	public void saveBook(Book book);

	public void updateBook(Book book);

	public void deleteBookById(Long id);

	public List<Book> findAllBooks();

	public boolean doesBookExist(Book book);

}
