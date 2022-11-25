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
	
	private DAO bookRepo; 	
	
	public List<Book> findAllBooks() {
		return bookRepo.findAllBooks();
	}

	public Book findById(Long id) {
		return bookRepo.findById(id);
	}

	public Book findByTitle(String title) {
		return bookRepo.findByTitle(title);
	}

	public void saveBook(Book book) {
		bookRepo.saveBook(book);
	}

	public void updateBook(Book book) {
		bookRepo.updateBook(book);
	}

	public void deleteBookById(Long id) {
		bookRepo.deleteBookById(id);
	}

	public boolean doesBookExist(Book book) {
		return bookRepo.doesBookExist(book);
	}

}
