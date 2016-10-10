package com.finalist.model.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.finalist.config.TestSpringConfig;
import com.finalist.model.entities.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestSpringConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonServiceIntegrationTest {

	@Autowired
	private PersonService personService;

	@Test
	public void itShouldAddPerson() {
		
		Person person = new Person("Any", "pass" , "AnyName", "Any Last");
			
		// WHEN
		person = personService.addPerson(person);
		System.out.println("itShouldAddPerson  " + person.getId() );
		 
		// THEN
		assertNotNull(person);
		assertNotEquals(0,  person.getId());
	}
	
	
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
		System.out.println("itShouldFindAllPersons  " + persons.size());
		
		// THEN
		assertNotNull(persons);
		assertFalse(persons.isEmpty());
	}
	
	

}
