package org.archive.provider.service;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.archive.provider.entity.Book;
import org.archive.provider.repository.BookDao;
import org.hibernate.Session;
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
	@SuppressWarnings("unchecked")
	public List<Book> findAllBooks() {
//		Session s = sessionFactory.getCurrentSession();		
//		CriteriaBuilder cb = s.getCriteriaBuilder();		
//		CriteriaQuery<Book> cq = cb.createQuery(Book.class);		
//		Root<Book> root = cq.from(Book.class);		
//		cq.select(root);		
//		Query query = s.createQuery(cq);		
//		return query.getResultList();
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
		
		Query query = sessionFactory.openSession().createQuery("FROM Book b WHERE b.title = :title and b.author = :author and b.illustrator = :illustrator");
		query.setParameter("title", book.getTitle());
		query.setParameter("author", book.getAuthor());
		query.setParameter("illustrator", book.getIllustrator());
		
		List<?> pList = query.getResultList();
		
		if(!pList.isEmpty()) {
			return true;
		}
		return false;
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
