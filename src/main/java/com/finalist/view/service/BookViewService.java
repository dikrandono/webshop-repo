package com.finalist.view.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalist.model.entities.Book;
import com.finalist.model.entities.Language;
import com.finalist.model.service.BookService;
import com.finalist.model.service.LanguageService;

@Service
public class BookViewService {

	@Autowired
	LanguageService langService ;
	
	@Autowired
	BookService bookService ;
	List<Language> allLangs = new ArrayList<Language>();;
	
	public BookViewService() {
		
	}
	
	public void saveBook(Book book){
		List<Language>  newlanges = new ArrayList<Language>();
		
		 if(book.getLanguages() != null){
			 for(Language ll: book.getLanguages()){
				 for(Language l2: allLangs){
					 if(ll.getTitel().equals(l2.getTitel())){
						 newlanges.add(l2) ;
					 }
				 }
			   }
		 }
		book.setLanguages(newlanges);
		if(book.getId() == 0){
			bookService.addBook(book);
		}else{
			bookService.updateBook(book);
		}
	}
	
	
	public List<Language> LoadAllLanguages(){
		
	    allLangs = langService.findAllLanguages();
		System.out.println("allLanguagesList allLanguagesList " + allLangs.size());
		
		return allLangs;
	}

	 
}
