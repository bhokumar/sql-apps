package org.jdbc.jpa.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.jdbc.jpa.JpaApplication;
import org.jdbc.jpa.modal.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class CriteriaQueryTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void jpqlTest() {
		logger.info("Jpql test ");
		TypedQuery<Course> typedQuery = entityManager.createQuery("Select c from Course c", Course.class);
		List<Course> courseList = typedQuery.getResultList();
		logger.info("Courses list --> {}", courseList);
	}
	
	@Test
	public void criteriaQueryTest() {
		logger.info("Criteria query test ");
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
		Root<Course> courseRoot = criteriaQuery.from(Course.class);
		
		//Build the Predicate
		Predicate predicate = criteriaBuilder.like(courseRoot.get("name"), "%lar");
		
		// Add the predicate to query
		criteriaQuery.where(predicate);
		
		TypedQuery<Course> typedQuery = entityManager.createQuery(criteriaQuery.select(courseRoot));
		List<Course> courseList = typedQuery.getResultList();
		logger.info("Courses list --> {}", courseList);
	}
	
	
	@Test
	public void allCourseWithoutStudents() {
		logger.info("Criteria query test ");
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
		Root<Course> courseRoot = criteriaQuery.from(Course.class);
		
		//Build the Predicate
		Predicate predicate = criteriaBuilder.isEmpty(courseRoot.get("students"));
		
		// Add the predicate to query
		criteriaQuery.where(predicate);
		
		TypedQuery<Course> typedQuery = entityManager.createQuery(criteriaQuery.select(courseRoot));
		List<Course> courseList = typedQuery.getResultList();
		logger.info("Courses list --> {}", courseList);
	}
	
	@Test
	public void joins() {
		logger.info("Join Test ");
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
		Root<Course> courseRoot = criteriaQuery.from(Course.class);
		
		//Build the Predicate
		Join<Object, Object> join = courseRoot.join("students");
		// Add the predicate to query
		//criteriaQuery.where(predicate);
		
		TypedQuery<Course> typedQuery = entityManager.createQuery(criteriaQuery.select(courseRoot));
		List<Course> courseList = typedQuery.getResultList();
		logger.info("Courses list --> {}", courseList);
	}
	
	
	@Test
	public void leftJoin() {
		logger.info("Left Join Test ");
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
		Root<Course> courseRoot = criteriaQuery.from(Course.class);
		
		//Build the Predicate
		Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);
		// Add the predicate to query
		//criteriaQuery.where(predicate);
		
		TypedQuery<Course> typedQuery = entityManager.createQuery(criteriaQuery.select(courseRoot));
		List<Course> courseList = typedQuery.getResultList();
		logger.info("Courses list --> {}", courseList);
	}
	
}
