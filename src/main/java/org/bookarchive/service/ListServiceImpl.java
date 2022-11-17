package org.bookarchive.service;

import java.util.List;

import org.bookarchive.dao.DAO;
import org.bookarchive.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ListServiceImpl implements ListService {

	@Autowired
	private DAO dao;

	public List<Book> findAllBooks() {
		return dao.findAllBooks();
	}

	public Book findById(Long id) {
		return dao.findById(id);
	}

	public Book findByTitle(String title) {
		return dao.findByTitle(title);
	}

	public void saveBook(Book book) {
		dao.saveBook(book);
	}

	public void updateBook(Book book) {
		dao.updateBook(book);
	}

	public void deleteBookById(Long id) {
		dao.deleteBookById(id);
	}

	public boolean doesBookExist(Book book) {
		return dao.doesBookExist(book);
	}

}
