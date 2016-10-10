package com.finalist.model.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.finalist.config.TestSpringConfig;
import com.finalist.model.entities.Book;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestSpringConfig.class)
@ActiveProfiles("hsql")
public class BookServiceIntegrationTest {

	
	@Autowired
	private BookService bookService;
    
	@Before
	public void itShouldAddBook() {
		
		Book book = new Book("MyBook", "Any Writer");
			
		// GIVEN
		book = bookService.addBook(book);
		System.out.println("itShouldAddBook  " + book.getId() );
		Book book2 = new Book("MyBook2", "Any Writer2");
		
		// WHEN
		book2 = bookService.addBook(book2);
		System.out.println("itShouldAddBook  " + book2.getId() );
		
		// THEN
		assertNotNull(book2);
		assertNotEquals(0,  book2.getId());
	}
	
    @Ignore
	@Test
	public void itShouldUpdate(){
		
		Book book = bookService.findBook(1);
		book.setTitel("UpdateTitel");
		System.out.println("itShouldUpdateBook  " + book.getId() );
		
		// WHEN
		bookService.updateBook(book);
		// THEN
		assertNotEquals(0,  book.getId());
	}
	
	
	@After
	public void itShouldFindAll() {
		// WHEN
		List<Book> books = bookService.findAllBooks();
		System.out.println("itShouldFindAll  " + books.get(0).getTitel() );
		// THEN
		assertNotNull(books);
		assertFalse(books.isEmpty());
	}
	
 
}
