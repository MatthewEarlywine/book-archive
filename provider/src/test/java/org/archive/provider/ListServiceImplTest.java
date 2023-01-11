package org.archive.provider;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.archive.provider.entity.Book;
import org.archive.provider.repository.BookDao;
import org.archive.provider.service.ListServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ListServiceImplTest extends AbstractTestNGSpringContextTests{
	
	public Book makeTestBook(Long i) {
		Book book = new Book();
		
		book.setId(i);
		book.setTitle("Dracula");
		book.setAuthor("Bram Stoker");
        book.setSeries("Horror Classics");
        book.setIllustrator("Karfax");
        book.setGenre("Horror");
        
        return book;
	}
	
	@Mock
	private BookDao mockDao;
	
	@InjectMocks
	private ListServiceImpl service;
	
    @BeforeClass
    public void setUp() {

         MockitoAnnotations.openMocks(this);
         
    }
    
	@AfterMethod
	@AfterClass
	public void tearDown() throws Exception {
		MockitoAnnotations.openMocks(this).close();
	}
    
	@Test
	private void findAllBooksTest() {	
		Book book4 = makeTestBook(4L);
		Book book5 = makeTestBook(5L);
	
		List<Book> books = new ArrayList<>();
		
		books.add(book4);
		books.add(book5);
		
		Mockito.when(service.findAllBooks()).thenReturn(books);
		List<Book> allBooks = service.findAllBooks();
		
		assertEquals(allBooks, books);
		
		Mockito.verify(mockDao, Mockito.atMost(2)).findAll();
	}
	
	@Test
	public void findAllBooksEmptyListTest() {
		List<Book> books = new ArrayList<>();
		Book book = makeTestBook(3L);
		
		
		Mockito.when(mockDao.findAll()).thenReturn(books);
		
		List<Book> list = service.findAllBooks();
		//list.add(book);
		assertTrue(list.isEmpty());
		
		Mockito.verify(mockDao, Mockito.atMost(2)).findAll();
	}
	
	@Test
	private void findById_success() {
		Book book = makeTestBook(1L);

		Mockito.when(mockDao.getReferenceById(1L)).thenReturn(book);
		
		Book bookSought = service.findById(1L);
		
		assertEquals(bookSought, book);
		
		Mockito.verify(mockDao).getReferenceById(1L);
		
	}
	
	@Test
	public void findBadId_ReturnNull() {
		Book book = makeTestBook(2L);
		Mockito.when(mockDao.getReferenceById(5L)).thenReturn(null);
		Mockito.when(mockDao.getReferenceById(2L)).thenReturn(book);

		Book book1 = service.findById(5L);
		Book book2 = service.findById(2L);

		assertEquals(book1, null);
		assertEquals(book2, book);
		
		Mockito.verify(mockDao).getReferenceById(2L);
		Mockito.verify(mockDao).getReferenceById(5L);
	}
	
	@Test
	public void givenLongValue_doesIdExistTest_returnBooleanValue() {
		List<Book> books = new ArrayList<>();
		Book book = makeTestBook(1l);
		books.add(book);
		
		Boolean truth = true;
		
		Mockito.when(mockDao.getReferenceById(1L)).thenReturn(book); 
		Mockito.when(mockDao.getReferenceById(6L)).thenReturn(null);
		
		Object sampleObject1 = mockDao.getReferenceById(6L);  // ClassCastException kicks in here
		Object sampleObject2 = mockDao.getReferenceById(1L);
		
		System.out.println(String.valueOf(sampleObject1));
		System.out.println(String.valueOf(sampleObject2));
		
		Book answer = mockDao.getReferenceById(6L);		
		assertEquals(null, sampleObject1);

		answer = mockDao.getReferenceById(1L);
		assertEquals(book, answer);
		assertTrue(service.doesIDExist(1L));
		assertFalse(service.doesIDExist(6L));
		
		System.out.println(service.doesIDExist(1L));
		System.out.println(service.doesIDExist(6L));
		
	}
	
	@Test
	public void findByTitle_success() {
		Book book = makeTestBook(1L); 
		Mockito.when(mockDao.findByTitle("Dracula")).thenReturn(book);
		
		Book bookSought = service.findByTitle("Dracula");
		
		assertEquals(bookSought, book);
		
		Mockito.verify(mockDao).findByTitle("Dracula");		
	}
	
	@Test
	public void findByTitle_failure() {
		Book book = makeTestBook(1L); 
		Mockito.when(mockDao.findByTitle("Dracula")).thenReturn(book);
		
		Book bookSought = service.findByTitle("Frankenstein");
		
		assertNotEquals(bookSought, book);
		
		Mockito.verify(mockDao).findByTitle("Frankenstein");	
	}
	
	@Test
	private void saveBook_success() {
		Book book = makeTestBook(1L);
			
		when(mockDao.save(any())).thenReturn(book);
			
		Book savedBook = service.saveBook(book);
		
		assertEquals(savedBook, book);
	}
	
	@Test
	private void updateBookRecord_success() {
		Book book = makeTestBook(1L);
		Book updatedBook = new Book();
		
		when(service.updateBook(any())).thenReturn(updatedBook);
		when(mockDao.findById(any())).thenReturn(Optional.of(updatedBook));
		
		assertEquals(book.getIllustrator(), "Karfax");
			
		updatedBook = book;
		updatedBook.setIllustrator("Bonny Beaux");
		
		assertEquals(updatedBook.getIllustrator(), "Bonny Beaux");
		
		assertEquals(updatedBook, book);
		
		updatedBook.setIllustrator("New House of Karfax");
		
		assertNotEquals(updatedBook.getIllustrator(), "Karfax");
		assertNotEquals(updatedBook.getIllustrator(), "Bonny Beaux");
		assertEquals(book.getIllustrator(), "New House of Karfax");
		assertEquals(updatedBook, book);		
	}
	
	@Test
	private void deleteBook_success() {
		Book book = makeTestBook(3L);
		when(mockDao.save(any())).thenReturn(book);
		assertNotEquals(book, null);
		
		Boolean isGone = service.deleteBookById(3L);
		assertEquals(service.findById(3L), null);
		assertTrue(isGone);
	}
	


}
