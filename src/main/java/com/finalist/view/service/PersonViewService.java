package com.finalist.view.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalist.model.entities.Person;
import com.finalist.model.service.PersonService;

@Service
public class PersonViewService {

	@Autowired
	PersonService personService;
	
	public PersonViewService() {
		 
	}
	
	public void savePerson(Person person){
		if(person.getId() == 0){
			personService.addPerson(person);
		}else{
			personService.updatePerson(person);
		}
		
		
	}

}
