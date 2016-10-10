package com.finalist.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalist.model.dao.PersonDao;
import com.finalist.model.entities.Person;
 
@Service("personService")
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

}
