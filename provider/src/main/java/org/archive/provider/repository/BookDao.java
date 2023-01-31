package org.archive.provider.repository;

import org.archive.provider.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Long>{

	public Book findByTitle(String title);

	public Book findByTitleAndAuthorAndIllustrator(String title, String author, String illustrator);	

}