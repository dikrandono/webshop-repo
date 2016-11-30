package com.finalist.view.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finalist.model.entities.Person;
import com.finalist.model.service.PersonService;

@RestController 
public class PersonsAngCntlr {

	
	@Autowired
	PersonService personService;
	
	@RequestMapping(value = "/data/PersonAng", method = RequestMethod.GET, headers = "Accept=application/json") 
	public List<Person> getAllPersons(){
		System.out.println(" getAllPersons getAllPersons getAllPersons");
		List<Person> persons = personService.findAllPersons();
		
		return persons;
	}
	
	
	@RequestMapping(value = "/data/PersonByidAng/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Person getPersonByid(@PathVariable int id){
		System.out.println(" getPersonByid getPersonByid getPersonByid");
		return personService.findPerson(id);
	}
	
	@RequestMapping(value = "/data/PersonAddAng", method = RequestMethod.POST, headers = "Accept=application/json")
	public Person addPerson(@RequestBody Person person){
		System.out.println(" addPerson addPerson addPerson" + person.getBooks() );
		
		
		Person pp = new Person(person.getUsername(),person.getPassword(),person.getFirstname(),person.getLastname());
		
		return personService.addPerson(pp);
	}
	
	@RequestMapping(value = "/data/PersonEditAng", method = RequestMethod.POST, headers = "Accept=application/json")
	public void updatePerson(@RequestBody Person person){
		System.out.println(" updatePerson updatePerson updatePerson");
		 personService.updatePerson(person);
	}
	
	@RequestMapping(value = "/data/PersonDeleteAng/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void deletePerson(@PathVariable int id){
		System.out.println(" deletePerson deletePerson deletePerson");
		 personService.deletePerson(id);
	}

}
