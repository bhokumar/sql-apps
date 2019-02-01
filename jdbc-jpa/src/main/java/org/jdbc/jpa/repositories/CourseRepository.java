package org.jdbc.jpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.jdbc.jpa.modal.Course;
import org.jdbc.jpa.modal.Review;
import org.jdbc.jpa.modal.ReviewRating;
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
	
	public void addReviewtoCourse() {
		Course course = findbyId(11001L);
		logger.info("Reviews --> {}", course.getReviews());
		Review review1 = new Review("Great HandsOn", ReviewRating.FIVE);
		Review review2 =new Review("Hatsoff", ReviewRating.FOUR);
		course.addReview(review1);
		course.addReview(review2);
		
		review1.setCourse(course);
		review2.setCourse(course);
		
		entityManager.persist(review1);
		entityManager.persist(review2);
	}
	
	public void addReviewtoCourse(Long courseId, List<Review> reviews) {
		Course course = findbyId(courseId);
		logger.info("Reviews --> {}", course.getReviews());
		
		reviews.forEach(review -> {
			course.addReview(review);
			review.setCourse(course);
			entityManager.persist(review);
		});
	}
}
