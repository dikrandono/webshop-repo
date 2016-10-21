package com.finalist.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.finalist.model.dao.PersonDao;
import com.finalist.model.entities.Person;
 
@Service("personService")
@Transactional(propagation = Propagation.REQUIRED)
public class PersonService {

	@Autowired  
	PersonDao personDao; 
	
	public PersonService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	 public List<Person> findAllPersons() {  
	  return personDao.findAllPersons();  
	 }  
	  
	 @Transactional  
	 public Person findPerson(int id) {  
	  return personDao.findPersonById(id);  
	 }  
	 
	 @Transactional  
	 public Person findPersonByUsername(String username) {  
	  return personDao.findPersonByUsername(username);  
	 }  
	  
	 @Transactional  
	 public Person addPerson(Person person) {  
		 return personDao.addPerson(person);  
	 }  
	  
	 @Transactional  
	 public void updatePerson(Person person) {  
		 personDao.updatePerson(person);
	  
	 }  
	  
	 @Transactional  
	 public void deletePerson(int id) {  
		 personDao.deletePerson(id);  
	 }  
	 
	 @Transactional
	 public Person getPersonWithBooks(Person person){
		 
		 Person personWithBooks = personDao.findPersonById(person.getId());
		 personWithBooks.getBooks().size();
		 return personWithBooks;
		 
		 
	 }

}
