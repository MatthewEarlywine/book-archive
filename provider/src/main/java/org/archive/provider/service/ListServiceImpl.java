package org.archive.provider.service;

import java.util.List;
import org.archive.provider.entity.Book;
import org.archive.provider.repository.BookDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ListServiceImpl implements ListService {

	@Autowired 				
	private BookDao bookRepo; 	
	
	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public List<Book> findAllBooks() {
		return bookRepo.findAll();
	}

	@Override
	public Book findById(Long id) {
		return bookRepo.getReferenceById(id);
	}
	
	@Override
	public Book findByTitle(String title) {
		return bookRepo.findByTitle(title);
	}
	
	@Override
	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}

	public Book updateBook(Book book) {
		
		return bookRepo.save(book);
	}

	public boolean deleteBookById(Long id) {
		bookRepo.deleteById(id);
		return true;
	}

	@Override
	public boolean doesBookExist(Book book) {
		book.getTitle();
		book.getAuthor();
		book.getIllustrator();
		
		if(bookRepo.findByTitleAndAuthorAndIllustrator(book.getTitle(), book.getAuthor(), book.getIllustrator()) != null) {
			return true;
		}	else {
			return false;
		}
		
	}
	
	@Override // what if search for id of record that doesn't exist?
	public boolean doesIDExist(Long id) {
		if(bookRepo.getReferenceById(id) != null) {
			return true;
		} else {
			return false;
		}
	}
	
}
