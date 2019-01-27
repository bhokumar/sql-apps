package org.jdbc.jpa.repositories;

import static org.junit.Assert.assertEquals;

import org.jdbc.jpa.JpaApplication;
import org.jdbc.jpa.modal.Course;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class CourseRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;
	
	@Before
	public void before() {
		repository.update(new Course("React"));
	}

	@Test
	public void findById() {
		logger.info("Context loads successfully");
		assertEquals("React", repository.findbyId(2).getName());
	}
}
