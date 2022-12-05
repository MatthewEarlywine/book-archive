package org.bookarchive.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.bookarchive.model.Book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOImpl implements DAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Book findById(Long id) {
		Session s = sessionFactory.getCurrentSession();
		return s.get(Book.class, id);
	}

	public Book findByTitle(String title) {
		Session s = sessionFactory.getCurrentSession();
		return s.get(Book.class, title);
	}

	public void saveBook(Book book) {
		book.setId(0L);
		
		Session s = sessionFactory.getCurrentSession();
		s.save(book);
	}

	public void updateBook(Book book) {
		sessionFactory.getCurrentSession().update(book);
	}

	public void deleteBookById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = session.byId(Book.class).load(id);
		session.delete(book);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAllBooks() {
		Session s = sessionFactory.getCurrentSession();		
		CriteriaBuilder cb = s.getCriteriaBuilder();		
		CriteriaQuery<Book> cq = cb.createQuery(Book.class);		
		Root<Book> root = cq.from(Book.class);		
		cq.select(root);		
		Query query = s.createQuery(cq);		
		return query.getResultList();
	}
	

	public boolean doesBookExist(Book book) {
		System.out.println(book.getTitle());
		Query query = sessionFactory.openSession().createQuery("FROM Book b WHERE b.title = :title and b.author = :author and b.illustrator = :illustrator");
		query.setParameter("title", book.getTitle());
		query.setParameter("author", book.getAuthor());
		query.setParameter("illustrator", book.getIllustrator());
		System.out.println(book.getTitle());
		List<?> pList = query.getResultList();
		System.out.println(pList.size());
		if (!pList.isEmpty()) {
			return true;
		}
		return false;
	}
}
