package org.bookarchive.dao;

import java.util.List;

import org.bookarchive.model.Book;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOImpl implements DAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Book findById(Long id) {
		String hql = "FROM Book b WHERE b.id = :id";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setParameter("id", id);
		return (Book) query.uniqueResult();
	}

	public Book findByTitle(String title) {
		String hql = "FROM Book b WHERE b.title = :title"; // HQL Query
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setParameter("title", title);
		return (Book) query.uniqueResult();
	}

	public void saveBook(Book book) {
		sessionFactory.getCurrentSession().save(book);
	}

	public void updateBook(Book book) {
		sessionFactory.getCurrentSession().update(book);
	}

	public void deleteBookById(Long id) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM Book WHERE ID = :ID");
		query.setLong("ID", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Book> findAllBooks() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class);
		return (List<Book>) criteria.list();
	}

	public boolean doesBookExist(Book book) {
		Query query = sessionFactory.openSession().createQuery("FROM Book b WHERE b.title = :title");
		query.setString("title", book.getTitle());
		List<?> pList = query.list();
		if (!pList.isEmpty()) {
			return true;
		}
		return false;
	}
}
