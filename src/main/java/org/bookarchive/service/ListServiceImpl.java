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

	@Autowired 				// Error creating bean with name 'listController': Unsatisfied dependency
							// expressed through field 'listService':
	private DAO bookRepo; 	// Error creating bean with name 'listServiceImpl': Unsatisfied dependency
							// expressed through field 'bookRepo'
							// Error creating bean with name 'DAOImpl': Injection of autowired dependencies
							// failed;

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
