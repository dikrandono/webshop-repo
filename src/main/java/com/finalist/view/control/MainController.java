package com.finalist.view.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/bookspage", method = RequestMethod.GET)
	public String booksPage(ModelMap model) {
		
		return "books";
	}
	
	@RequestMapping(value = "/personspage", method = RequestMethod.GET)
	public ModelAndView persons(@RequestParam(value = "name", required = false ) String name,
			ModelAndView model) {
		model.getModel().put("name", name);
		return model;
	}
	

}
