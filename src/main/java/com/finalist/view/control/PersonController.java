package com.finalist.view.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finalist.model.entities.Person;
import com.finalist.model.service.PersonService;
 
@Controller
public class PersonController {

	@Autowired
	PersonService personService;
	
	public PersonController() {
		 
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Person> getAllPersons(){
		
		List<Person> persons = personService.findAllPersons();
		
		return persons;
	}
	
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Person getPersonById(@PathVariable int id){
		
		return personService.findPerson(id);
	}


}
