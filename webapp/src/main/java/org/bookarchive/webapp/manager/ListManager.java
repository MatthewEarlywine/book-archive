package org.bookarchive.webapp.manager;

import org.bookarchive.webapp.model.BookView;
import org.springframework.http.ResponseEntity;

public interface ListManager {

	ResponseEntity<BookView> findById(Long id);

	ResponseEntity<BookView> saveBook(BookView book);

	ResponseEntity<BookView> updateBook(BookView book);

	void deleteBookById(Long id);

	ResponseEntity<BookView[]> findAllBooks();

	ResponseEntity<BookView> findByTitle(String title);

	// boolean doesBookExist(BookView book);

}
