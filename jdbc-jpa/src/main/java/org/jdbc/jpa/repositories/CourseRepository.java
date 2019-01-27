package org.jdbc.jpa.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.jdbc.jpa.modal.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Course findbyId(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public Course update(Course course) {
		return entityManager.merge(course);
	}
	
	public Course save(Course course) {
		if(course.getId() == null) {
			entityManager.persist(course);
			return course;
		}else {
			return entityManager.merge(course);
		}	
	}
	
	public void deleteById(long id) {
		Course course = findbyId(id);
		entityManager.remove(course);
	}
	
	public void playWithEntityManager() {
		logger.info("Starting playing with Entity manager");
		Course course1 = new Course("New Course on microservices!");
		entityManager.persist(course1);
		entityManager.flush();
		
		
		Course course2 = new Course("New Course on microservices101!");
		entityManager.persist(course2);
		entityManager.flush();
		entityManager.clear();
		course2.setName("MicroServices in 101 steps");
		entityManager.merge(course2);
		course2.setName("Third Update");
		
		course1.setName("MicroServices in 100 steps");
		entityManager.flush();
	}
}
