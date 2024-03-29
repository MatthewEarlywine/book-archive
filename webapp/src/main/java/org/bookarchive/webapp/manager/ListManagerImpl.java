package org.bookarchive.webapp.manager;

import org.bookarchive.webapp.model.BookView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ListManagerImpl implements ListManager {

	Logger logger = LoggerFactory.getLogger(ListManagerImpl.class);
	private final String RESOURCE_URI = "/api/favoritebooks/";

	@Value("${service.url}")
	private String serviceBaseUrl;

	// @Autowired
	// public SessionFactory sessionFactory;

	@Autowired
	private RestTemplate restTemplate;

	public ResponseEntity<BookView> saveBook(BookView book) {
		String requestUri = serviceBaseUrl + RESOURCE_URI;
		return restTemplate.postForEntity(requestUri, book, BookView.class);
	}

	public ResponseEntity<BookView[]> findAllBooks() {
		String requestUri = serviceBaseUrl + RESOURCE_URI;
		// ResponseEntity<BookView[]> books =

		return restTemplate.getForEntity(requestUri, BookView[].class);
		// BookView[] bookArray = books.getBody();
		// List<BookView> bookViewList = Arrays.asList(bookArray);
		// ResponseEntity<List<BookView>> bookViewResponse =
		// ResponseEntity.ok(bookViewList);

		// List<Object> booksL = Arrays.stream(books.getBody()) //Requires booksL be
		// Type 'List<Object>'
		// .collect(Collectors.toList());
		// return new ResponseEntity<List<BookView>>(booksL, HttpStatus.OK); //Requires
		// booksL be Type 'List<BookView>' OR Remove booksL argument

		// return bookViewResponse;
	}

	public ResponseEntity<BookView> findById(Long id) {
		String requestUri = serviceBaseUrl + RESOURCE_URI;
		return restTemplate.getForEntity(requestUri + "{id}", BookView.class, Long.toString(id));
	}

	public ResponseEntity<BookView> findByTitle(String title) {
		String requestUri = serviceBaseUrl + RESOURCE_URI;
		return restTemplate.getForEntity(requestUri + "title/{title}", BookView.class);
	}

	public ResponseEntity<BookView> updateBook(BookView book) {
		String requestUri = serviceBaseUrl + RESOURCE_URI;
		return restTemplate.exchange(requestUri + "{id}",
				HttpMethod.PUT,
				new HttpEntity<>(book),
				BookView.class,
				Long.toString(book.getId()));

	}

	public void deleteBookById(Long id) {
		String requestUri = serviceBaseUrl + RESOURCE_URI;
		restTemplate.delete(requestUri + "{id}", Long.toString(id));
	}
}
