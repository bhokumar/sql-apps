package org.jdbc.jpa.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jdbc.jpa.modal.Course;
import org.jdbc.jpa.modal.Passport;
import org.jdbc.jpa.modal.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Student findbyId(long id) {
		return entityManager.find(Student.class, id);
	}
	
	public Student update(Student student) {
		return entityManager.merge(student);
	}
	
	public Student save(Student student) {
		if(student.getId() == null) {
			entityManager.persist(student);
			return student;
		}else {
			return entityManager.merge(student);
		}	
	}
	
	public void deleteById(long id) {
		Student Student = findbyId(id);
		entityManager.remove(Student);
	}
	
	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123456");
		//entityManager.persist(passport);
		Student student = new Student("Mike");
		student.setPassport(passport);
		entityManager.persist(student);
	}
	
	
	public void saveStudentW() {
		Passport passport = new Passport("Z123456");
		//entityManager.persist(passport);
		Student student = new Student("Mike");
		student.setPassport(passport);
		entityManager.persist(student);
		
	}
	
	public void dummyOperation() {
		// Database operation1
		Student student = entityManager.find(Student.class, 20001L);
		//Persistence context Student
		
		// Database operation2 
		Passport passport = student.getPassport();
		//Persistence context Student, Passport
		
		// Database operation3
		passport.setNumber("R4578912");
		//Persistence context Passport++
		
		// Database operation4
		student.setName("Bhoopendra Rathore");
		//Persistence context Student++, Passport++
	}
	
	public void insertStudent() {
		Student student = new Student("Jack");
		Course course = new Course("Microservices in 250 steps");
		entityManager.persist(course);
		entityManager.persist(student);
		course.addStudent(student);
		student.addCourse(course);
		entityManager.persist(course);
		
	}
	
	public void insertStudent(Student student, Course course) {
		entityManager.persist(course);
		entityManager.persist(student);
		course.addStudent(student);
		student.addCourse(course);
		entityManager.persist(course);
		
	}
}
