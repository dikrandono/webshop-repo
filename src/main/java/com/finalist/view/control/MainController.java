package com.finalist.view.control;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

	
	
	public MainController() {
		
	}
	
	@RequestMapping("/indexpage")
	public ModelAndView indexpage() {
		String message = "Welcome in the webshop";
		
		return new ModelAndView("../../index", "message", message);
	}
	
	 @RequestMapping(value = "/index")  
	 public ModelAndView goToIndex() { 
				 
		ModelAndView model = new ModelAndView("index");
	  return model;  
	 }  
	 
	 @RequestMapping(value = "/login")  
	 public ModelAndView goToLogin() { 
				 
		ModelAndView model = new ModelAndView("login");
		 
	  return model;  
	 }  
	 
	 @RequestMapping(value = "/loginerror")  
	 public ModelAndView goToLoginerror() { 
				 
		ModelAndView model = new ModelAndView("login");
		model.addObject("error", "Incorrect user name or password");
	  return model;  
	 }  
	


}
