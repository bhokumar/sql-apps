package org.jdbc.jpa.jpql;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.jdbc.jpa.JpaApplication;
import org.jdbc.jpa.modal.Passport;
import org.jdbc.jpa.modal.Student;
import org.jdbc.jpa.repositories.StudentRepository;
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
public class StudentRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private EntityManager entityManger;
	
	@Test
	@DirtiesContext
	@Transactional
	public void RetrieveStudentAndPassportDetails() {
		Student student = entityManger.find(Student.class, 20001L);
		logger.info("Student --> {}", student);
		logger.info("Passport Details are --> {}", student.getPassport());
	}
	
	@Test
	public void someTest() {
		repository.dummyOperation();
	}
	
	
	@Test
	@DirtiesContext
	@Transactional
	public void retrievePassportAndStudent() {
		Passport passport = entityManger.find(Passport.class, 40001L);
		logger.info("Passport --> {}", passport);
		logger.info("Student Details are --> {}", passport.getStudent());
	}
	
	@Test
	@DirtiesContext
	@Transactional
	public void retrievePassportAndCourses() {
		Student student = entityManger.find(Student.class, 20001L);
		logger.info("Student --> {}", student);
		logger.info("Course Details are--> {}", student.getCourses());
	}
}
