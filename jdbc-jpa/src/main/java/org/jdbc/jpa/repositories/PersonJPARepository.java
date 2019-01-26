package org.jdbc.jpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.jdbc.jpa.modal.Person;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonJPARepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Person findbyId(int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		Person person = findbyId(id);
		entityManager.remove(person);
	}
	
	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_person", Person.class);
		return namedQuery.getResultList();
	}
}
