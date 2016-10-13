package com.finalist.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.finalist.model.entities.Language;
 
@Repository
public class LanguageDao {

	@PersistenceContext()//type = PersistenceContextType.EXTENDED
	private EntityManager entityManager;

	public LanguageDao() {

	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Language addLanguage(Language lang) {
		entityManager.persist(lang);
		return lang;
	}

	public void updateLanguage(Language lang) {

		entityManager.merge(lang);
	}

	public void deletLanguage(int id) {
		Language lang = (Language) entityManager.find(Language.class, id);

		if (lang != null) {
			entityManager.remove(lang);
		}
	}

	public List<Language> findAllLanguages() {

		String SELECT_QUERY = "select l from Language l";
		Query query = entityManager.createQuery(SELECT_QUERY);

		List<Language> langs = query.getResultList();
		return langs;
	}
	
	public Language findanguageById(int id) {

		Language lang = (Language) entityManager.find(Language.class, id);
		
		return lang;
	}

}
