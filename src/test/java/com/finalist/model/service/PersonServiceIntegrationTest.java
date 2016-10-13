package com.finalist.model.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.finalist.config.TestSpringConfig;
import com.finalist.model.entities.Book;
import com.finalist.model.entities.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestSpringConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles("hsql")
public class PersonServiceIntegrationTest {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private BookService bookService;

	@Before
	public void itShouldAddPerson() {
		
		Person person = new Person("Any", "pass" , "AnyName", "Any Last");
			
		// WHEN
		person = personService.addPerson(person);
		System.out.println("itShouldAddPerson  " + person.getId() );
		 
		addBookForPerson(person);
		
		// THEN
		assertNotNull(person);
		assertNotEquals(0,  person.getId());
	}
	
	
	public void addBookForPerson(Person person){
		Book book = new Book("MyBook", "Any Writer");
		book.setLoanedTo(person);
		book = bookService.addBook(book);
		System.out.println("itShouldAddBook  " + book.getId() );
		
		
		Book book2 = new Book("MyBook2", "Any Writer2");		 
		book2.setLoanedTo(person);
		book2 = bookService.addBook(book2);
		System.out.println("itShouldAddBook  " + book2.getId() );
		
	}
	
	@Ignore
	@Test
	public void itShouldUpdatePerson() {
			
		// WHEN
		Person person = personService.findPerson(1);
		person.setFirstname("Onther Name");
		System.out.println("itShouldUpdatePerson  " + person.getId() );
		personService.updatePerson(person);
		// THEN
		assertNotNull(person);
		assertNotEquals(0,  person.getId());
	}
	

	@Test
	public void itShouldFindAllPersons() {
		
		// WHEN
		List<Person> persons = personService.findAllPersons();
		System.out.println("itShouldFindAllPersons  " + persons.get(0).getId() + " Person Name = " + persons.get(0).getFirstname());
		
		Person person = personService.getPersonWithBooks(persons.get(0));
		
		System.out.println("Person Books Size = " + person.getBooks().size() );
		
		// THEN
		assertNotNull(persons);
		assertFalse(persons.isEmpty());
		
	}
	
	

}
