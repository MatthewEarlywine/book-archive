package org.bookarchive.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.bookarchive.model.Book;
import org.springframework.stereotype.Service;

@Service("listService")
public class ListServiceImpl implements ListService {

	private static final AtomicLong counter = new AtomicLong();

	private static List<Book> books;

	static {
		books = listStarterBooks();
	}

	public List<Book> findAllBooks() {
		return books;
	}

	public Book findById(long id) {
		for (Book book : books) {
			if (book.getId() == id) {
				return book;
			}
		}
		return null;
	}

	public Book findByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				return book;
			}
		}
		return null;
	}

	public List<Book> saveBook(Book book) {
		book.setId(counter.incrementAndGet());
		books.add(book);
		return books;
	}

	public void updateBook(Book book) {
		int index = books.indexOf(book);
		books.set(index, book);
	}

	public void deleteBookById(long id) {
		for (Iterator<Book> iterator = books.iterator(); iterator.hasNext();) {
			Book book = iterator.next();
			if (book.getId() == id) {
				iterator.remove();
			}
		}
	}

	public boolean doesBookExist(Book book) {
		return findByTitle(book.getTitle()) != null;
	}

	public void deleteAllBooks() {
		books.clear();
	}

	public static List<Book> listStarterBooks() {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(counter.incrementAndGet(), "Frankenstein", "Mary Shelly", "Horror"));
		books.add(new Book(counter.incrementAndGet(), "Exalted", "Onyx Path Publishing", "RPG"));
		books.add(new Book(counter.incrementAndGet(), "After Man", "Dougal Dixon", "Science Fiction"));
		return books;
	}
}
