package com.finalist.view.control;

 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finalist.model.entities.Book;
import com.finalist.model.entities.Person;
import com.finalist.model.service.PersonService;
import com.finalist.view.service.PersonViewService;
 
 
@Controller
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@Autowired
	PersonViewService personViewService;
	
	public PersonController() {
		 
	}
	
	@RequestMapping(value = "/personsfreem")
	public ModelAndView personsFreeMarkerPage() {
		
		ModelAndView model = new ModelAndView("persons");
		refreshPersonsList(model);
		
	    return model;
	}
	
	 
	 @RequestMapping(value = "/savePerson", method = RequestMethod.POST)  
	 public ModelAndView savePersonk(@ModelAttribute("person")Person person) { 
		
		 personViewService.savePerson(person);
		 
		ModelAndView model = new ModelAndView("persons");
		refreshPersonsList(model);
	  return model;  
	 }  
	 
	 @RequestMapping(value = "/editperson/{id}")  
	 public ModelAndView editPerson(@PathVariable int id ) {  
		 
		Person person = personService.findPerson(id);
		
		ModelAndView model = new ModelAndView("persons");
		refreshPersonsList(model);
		model.addObject("person", person);
		
	  return model;  
	 }
	 
	 
	
	 @RequestMapping(value = "/deleteperson/{id}")  
	 public ModelAndView deletePerson(@PathVariable int id) {  
				
		ModelAndView model = new ModelAndView("persons");
		personService.deletePerson(id);
		refreshPersonsList(model);
		
	  return model;  
	 }
	 
	 
	 private void refreshPersonsList(ModelAndView model){
		    List<Person> personsList = personService.findAllPersons();
		   
			model.addObject("personsList", personsList);
			model.addObject("message","Persons List");
			model.addObject("person",new Person("","","",""));
			System.out.println("refreshPersonsList " + personsList.size());
	 }
 

}
