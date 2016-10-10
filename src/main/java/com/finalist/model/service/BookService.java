package com.finalist.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalist.model.dao.BookDao;
import com.finalist.model.entities.Book;
 
@Service("bookService") 
public class BookService {

	@Autowired
	BookDao bookDao;

	public BookService() {
	}
	
	
	@Transactional
	public List<Book> findAllBooks(){
		
		return bookDao.findAllBooks();
	}
	
	
	@Transactional
	public Book findBook(int id){
		
		return bookDao.findBookById(id);
	}
	
	@Transactional
	public Book addBook(Book book){
		
		return bookDao.addBook(book);
	}

	@Transactional
	public void updateBook(Book book){
		
		bookDao.updateBook(book);
	}
	
	@Transactional
	public void deleteBook(int id){
		
		bookDao.deletBook(id);
	}
	
}
