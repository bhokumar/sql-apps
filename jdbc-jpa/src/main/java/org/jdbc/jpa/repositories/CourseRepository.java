package org.jdbc.jpa.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.jdbc.jpa.modal.Course;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Course findbyId(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public Course update(Course course) {
		return entityManager.merge(course);
	}
}
