package org.jdbc.jpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.jdbc.jpa.modal.Employee;
import org.jdbc.jpa.modal.FullTimeEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EmployeeRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void insert(Employee employee) {
		entityManager.persist(employee);
	}
	
	public List<FullTimeEmployee> retreiveAllFullTimeEmployees(){
		return entityManager.createQuery("Select e from Employee e", FullTimeEmployee.class).getResultList();
	}
	
	public List<FullTimeEmployee> retreiveAllPartTimeEmployees(){
		return entityManager.createQuery("Select e from Employee e", FullTimeEmployee.class).getResultList();
	}
}
