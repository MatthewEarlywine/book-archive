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
		String hql = "FROM Book b WHERE b.id = :id";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setParameter("id", id);
		return (Book) query.getResultList();
	}
	
//	@Override
//    public Task findTaskById(Long id) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        return currentSession.get(Task.class, id);
//    }



	public Book findByTitle(String title) {
		String hql = "FROM Book b WHERE b.title = :title"; // HQL Query
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setParameter("title", title);
		return (Book) query.getResultList();
	}

	public void saveBook(Book book) {
		sessionFactory.getCurrentSession().save(book);
	}

	public void updateBook(Book book) {
		sessionFactory.getCurrentSession().update(book);
	}

	public void deleteBookById(Long id) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM Book WHERE ID = :ID");
		query.setParameter("ID", id);
		query.executeUpdate();
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
	
//	@SuppressWarnings("unchecked")
//    @Override
//    public List<Task> listTasks() {
//        Session session = sessionFactory.getCurrentSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery <Task> cq = cb.createQuery(Task.class);
//        Root<Task> root = cq.from(Task.class);
//        cq.select(root);
//        Query query = session.createQuery(cq);
//        return query.getResultList();
//    }

	public boolean doesBookExist(Book book) {
		Query query = sessionFactory.openSession().createQuery("FROM Book b WHERE b.title = :title");
		query.setParameter("title", book.getTitle());
		List<?> pList = query.getResultList();
		if (!pList.isEmpty()) {
			return true;
		}
		return false;
	}
}
