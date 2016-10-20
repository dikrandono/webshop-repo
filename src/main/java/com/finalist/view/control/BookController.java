package com.finalist.view.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finalist.model.entities.Book;
import com.finalist.model.service.BookService;
import com.finalist.view.service.BookViewService;
 
@Controller
public class BookController {

	@Autowired
	BookService bookService ;
	
	@Autowired
	BookViewService bookViewService;
	
	public BookController() {
		 
	}
	
	
	@RequestMapping("/booksview")
	public ModelAndView books() {
				
		 ModelAndView model = new ModelAndView("books");
		 
		 refreshBooksList(model);
		
		return model;
	}
	
	 @RequestMapping(value = "/bookform/{id}")  
	 public ModelAndView getBookById(@PathVariable int id) {  
		
		Book book = bookService.findBookWithLangs(id);
		
		ModelAndView model = new ModelAndView("bookform");
		model.addObject("book", book);
		model.addObject("allLangs", bookViewService.LoadAllLanguages());
		model.addObject("message", "Edit Book");
		
	  return model;  
	 }
	 
	 
	 @RequestMapping(value = "/bookformadd")  
	 public ModelAndView bookFormAdd() {  
				
		ModelAndView model = new ModelAndView("bookform");
		model.addObject("book", new Book("",""));
		model.addObject("message", "Add Book");
		model.addObject("allLangs", bookViewService.LoadAllLanguages());
		
	  return model;  
	 }
	 
	 @RequestMapping(value = "/deletebook/{id}")  
	 public ModelAndView deleteBook(@PathVariable int id) {  
				
		ModelAndView model = new ModelAndView("books");
		bookService.deleteBook(id);
		refreshBooksList(model);
		
	  return model;  
	 }
	 
	 
	 @RequestMapping(value = "/books", method = RequestMethod.POST)  
	 public ModelAndView saveBook(@ModelAttribute("book")Book book) { 
		
	    bookViewService.saveBook(book);
		 
		ModelAndView model = new ModelAndView("books");
		refreshBooksList(model);
	  return model;  
	 }  
	 
	 @RequestMapping(value = "/index")  
	 public ModelAndView goToIndex() { 
				 
		ModelAndView model = new ModelAndView("../../index");
		 
	  return model;  
	 }  
	 
	 @RequestMapping(value = "/login")  
	 public ModelAndView goToLogin() { 
				 
		ModelAndView model = new ModelAndView("../../login");
		 
	  return model;  
	 }  
	
	
	 private void refreshBooksList(ModelAndView model){
		    List<Book> books = bookService.findAllBooks();
			model.addObject("books", books);
			model.addObject("message", "Books View");
			System.out.println("refreshBokksList " + books.size());
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
