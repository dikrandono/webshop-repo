package com.finalist.view.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finalist.model.entities.Language;
import com.finalist.model.service.LanguageService;

@Controller
public class LangController {

	@Autowired
	LanguageService langService ;
	
	public LangController(){}
	
	
	@RequestMapping("/langsview")
	public ModelAndView languagesPage() {
				
		 ModelAndView model = new ModelAndView("/languages/languages.jsp");
		
		 refreshLangsList(model);
		
		return model;
	}
	
	
	 @RequestMapping(value = "/langform/{id}")  
	 public ModelAndView getLangById(@PathVariable int id) {  
		
		System.out.println("getBookById =" + id);
		Language lang = langService.findLangById(id);
		
		ModelAndView model = new ModelAndView("/languages/languages.jsp");
		model.addObject("lang", lang);
		model.addObject("message", "Edit Language");
		
	  return model;  
	 }
	 
	 
	 @RequestMapping(value = "/langformadd")  
	 public ModelAndView langFormAdd() {  
				
		ModelAndView model = new ModelAndView("/languages/languages.jsp");
		model.addObject("lang", new Language(""));
		model.addObject("message", "Add Language");
		
	  return model;  
	 }
	 
	 @RequestMapping(value = "/deleteLang/{id}")  
	 public ModelAndView deleteLanguage(@PathVariable int id) {  
				
		ModelAndView model = new ModelAndView("/languages/languages.jsp");
		langService.deleteLanguage(id); 
		refreshLangsList(model);
		
	  return model;  
	 }
	 
	 @RequestMapping(value = "/savelang", method = RequestMethod.POST)  
	 public ModelAndView saveBook(@ModelAttribute("lang")Language lang) { 
		 
		if(lang.getId() == 0){
			langService.addLanguage(lang) ;
		}else{
			langService.updateLanguage(lang); 
		}
		ModelAndView model = new ModelAndView("/languages/languages.jsp");
		refreshLangsList(model);
	  return model;  
	 }  
	 	 
	
	 private void refreshLangsList(ModelAndView model){
		    List<Language> langs = langService.findAllLanguages();
			model.addObject("langs", langs);
			model.addObject("message", "Languages");
			model.addObject("lang", new Language(""));
			System.out.println("refreshLangsList " + langs.size());
	 }
	
	
}
