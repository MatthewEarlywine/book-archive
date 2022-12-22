package org.archive.provider.repository;

import java.util.List;

import org.archive.provider.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Long>{

//	public List<Book> findAllBooks();
	
//	public boolean doesBookExist(Book book);

	public Book findByTitle(String title);

}