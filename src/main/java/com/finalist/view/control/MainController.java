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
		 System.out.println("Kssssssssss 111111111111111111 index");
	  return model;  
	 }  
	 
	 @RequestMapping(value = "/login")  
	 public ModelAndView goToLogin() { 
				 
		ModelAndView model = new ModelAndView("login");
		System.out.println("Kssssssssss 2222222222222222222222 login");
		 
	  return model;  
	 }  
	


}
