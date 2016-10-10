package com.finalist.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.finalist.model.entities.Book;


@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class BookDao {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	
	public BookDao() {
		// TODO Auto-generated constructor stub
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
   public Book findBookById(int id) {
		
		Book book = (Book) entityManager.find(Book.class, id);;

		return book;
	}

	public Book addBook(Book book) {
		entityManager.persist(book);
		return book;
	}

	public void updateBook(Book book) {
		
		 entityManager.merge(book);
	}

	
	public void deletBook(int id) {
		Book book = (Book) entityManager.find(Book.class, id);
		
		if (book != null) {
			entityManager.remove(book);
		}
	}
	
	public List<Book> findAllBooks() {
			
			String SELECT_QUERY = "select b from Book b";
			Query query = entityManager.createQuery(SELECT_QUERY);
			
			List<Book> books =  query.getResultList();
			return books;
	}


}
