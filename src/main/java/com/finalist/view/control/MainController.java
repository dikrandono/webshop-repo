package com.finalist.view.control;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	public MainController() {

	}

	@RequestMapping("/login-ang")
	public ModelAndView indexpage() {
		String message = "Welcome in the books webshop";

		return new ModelAndView("/angular/login.html", "message", message);
	}

	@RequestMapping(value = "/indexjsp")
	public ModelAndView goToIndex() {

		ModelAndView model = new ModelAndView("index.jsp");
		String message = "Welcome in the webshop";
		model.addObject("message", message);

		return model;
	}
	

	@RequestMapping(value = "/loginjsp")
	public ModelAndView goToLogin() {
		ModelAndView model = new ModelAndView("login.jsp");

		return model;
	}

}
