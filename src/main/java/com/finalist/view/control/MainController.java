package com.finalist.view.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	public MainController() {
		
	}
	
	@RequestMapping(value = "/indexpage", method = RequestMethod.GET)
	public String indexPage(ModelMap model) {
		
		return "../../index";
	}
	
	@RequestMapping(value = "/bookspage", method = RequestMethod.GET)
	public String booksPage(ModelMap model) {
		
		return "books";
	}
	
	@RequestMapping(value = "/personspage", method = RequestMethod.GET)
	public String persons(@RequestParam(value = "name", required = false ) String name,
			Model model) {
		//model.addAttribute("name", name);
		return "persons";
	}

}
