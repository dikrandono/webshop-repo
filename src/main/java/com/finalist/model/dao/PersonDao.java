package com.finalist.model.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.finalist.model.entities.Person;
 
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class PersonDao {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public PersonDao() {
		// TODO Auto-generated constructor stub
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Person> findAllPersons() {

		String SELECT_QUERY = "select p from Person p";
		Query query = entityManager.createQuery(SELECT_QUERY);

		List<Person> persons = query.getResultList();
		return persons;
	}

	public Person findPersonById(int id) {

		Person person = (Person) entityManager.find(Person.class, id);

		return person;
	}

	public Person addPerson(Person person) {
		entityManager.persist(person);
		return person;
	}

	public void updatePerson(Person person) {

		entityManager.merge(person);
	}

	public void deletePerson(int id) {
		Person p = (Person) entityManager.find(Person.class, id);

		if (p != null) {
			entityManager.remove(p);
		}
	}

}
