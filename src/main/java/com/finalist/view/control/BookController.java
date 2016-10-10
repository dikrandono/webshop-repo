package com.finalist.view.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finalist.model.entities.Book;
import com.finalist.model.service.BookService;
 
@RestController
public class BookController {

	//@Autowired
	//BookService bookservice ;
	
	public BookController() {
		 
	}
	/*
	@RequestMapping(value = "/booksData", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public List<Book> getBooks() {  
	    System.out.println("find All Books");
	  List<Book> booksList = bookservice.findAllBooks();  

	  return booksList;  
	 }  
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public Book getBookById(@PathVariable int id) {  
	  return bookservice.findBook(id);  
	 }  
	
	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST, headers = "Accept=application/json")  
	 public Book addBook(@RequestBody Book book) {  
		book.setId(0);
	  return bookservice.addBook(book);  
	 } 
	
	@RequestMapping(value = "/updateBook", method = RequestMethod.PUT, headers = "Accept=application/json")  
	 public Book updateCountry(@RequestBody Book book) {  
	   bookservice.updateBook(book);
	  return book;
	 }  
	
	 @RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
	 public void deleteBook(@PathVariable("id") int id) {  
		 bookservice.deleteBook(id);
	  
	 }   
	*/


}
