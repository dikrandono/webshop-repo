package com.finalist.model.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.finalist.model.dao.BookDao;
import com.finalist.model.entities.Book;
 

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

	@InjectMocks
	private BookService bookService;

	@Mock
	private BookDao bookDao;
	
	@Test
	public void itShouldFindAll() {
		// GIVEN
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("test", "tester"));
		when(bookDao.findAllBooks()).thenReturn(books);
		
		// WHEN
		List<Book> actualBooks = bookService.findAllBooks();
		
		// THEN
		assertSame(books, actualBooks);
	}

}
