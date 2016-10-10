package com.finalist.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalist.model.dao.LanguageDao;
import com.finalist.model.entities.Language;
 
@Service("languageServive")
public class LanguageService {


	@Autowired
	LanguageDao langDao;

	public LanguageService() {

	}

	@Transactional
	public List<Language> findAllLanguages() {

		return langDao.findAllLanguages();

	}

	@Transactional
	public Language addLanguage(Language lang) {

		return langDao.addLanguage(lang);

	}

	@Transactional
	public void updateLanguage(Language lang) {

		langDao.updateLanguage(lang);
	}

	@Transactional
	public void deleteLanguage(int id) {
		langDao.deletLanguage(id);
	}
	
	@Transactional
	public Language findLangById(int id) {
		return langDao.findanguageById(id);
	}



}
