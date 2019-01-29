package org.jdbc.jpa.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.jdbc.jpa.JpaApplication;
import org.jdbc.jpa.modal.Course;
import org.jdbc.jpa.modal.Review;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class CourseRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;
	
	@Autowired
	private EntityManager entityManager;

	@Ignore
	@Test
	public void findById() {
		assertEquals("Angular", repository.findbyId(11001).getName());
	}
	
	@Ignore
	@Test
	@DirtiesContext
	public void deleteById() {
		repository.deleteById(11002);
		assertNull(repository.findbyId(11002));
	}
	
	@Ignore
	@Test
	@DirtiesContext
	public void saveMethod() {
		Course course = repository.findbyId(11001);
		course.setName("Updated Course Name");
		assertEquals("Updated Course Name", repository.save(course).getName());
	}
	
	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		repository.playWithEntityManager();
	}
	
	@Test
	@Transactional
	public void retrieveReviewsForCourse() {
		Course course = repository.findbyId(11001L);
		logger.info("{}", course.getReviews());
	}
	
	
	@Test
	@Transactional
	public void retrieveCourseForreview() {
		Review review = entityManager.find(Review.class, 50001L);
		logger.info("{}", review.getCourse());
	}
}
