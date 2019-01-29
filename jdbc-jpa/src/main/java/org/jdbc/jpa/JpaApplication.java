package org.jdbc.jpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.jdbc.jpa.modal.Course;
import org.jdbc.jpa.modal.FullTimeEmployee;
import org.jdbc.jpa.modal.PartTimeEmployee;
import org.jdbc.jpa.modal.Review;
import org.jdbc.jpa.modal.Student;
import org.jdbc.jpa.repositories.CourseRepository;
import org.jdbc.jpa.repositories.EmployeeRepository;
import org.jdbc.jpa.repositories.PersonJPARepository;
import org.jdbc.jpa.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JpaApplication implements CommandLineRunner{
	private Logger logger = LoggerFactory.getLogger(JpaApplication.class);
	
	@Autowired
	private PersonJPARepository jpaRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*logger.info("\nFound User --> {}", jpaRepository.findbyId(10001));
		Person person = new Person();
		
		logger.info("\nUpdate User --> {}", jpaRepository.update(new Person(10001, "Rathore", "Noida", new Date())));
		
		logger.info("\nInsert User --> {}", jpaRepository.update(new Person(10004, "Rathore", "Noida", new Date())));
		
		logger.info("\nUser Deleted -->");
		jpaRepository.deleteById(10002);
		
		logger.info("All Users {}", jpaRepository.findAll());
		
		logger.info("\nCourse found {}", courseRepository.findbyId(100000L));
		logger.info("Deleting Course!");
		courseRepository.deleteById(1);*/
		
		//logger.info("create a new course", courseRepository.save(new Course("View JS")));
		//courseRepository.playWithEntityManager();
		
		/**********************************************Student Repository************************/
		logger.info("\n**********************************************Student Repository************************\n");
		logger.info("Creating Student with Passport ");
		studentRepository.saveStudentWithPassport();
		studentRepository.insertStudent(new Student("Jack"), new Course("Services in 150 steps"));
		
		logger.info("\n**********************************************Course Repository************************\n");
		
		
		/*********************************************Course Repository*********************************/
		courseRepository.addReviewtoCourse();
		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("Awsome Couse", "4.3"));
		reviews.add(new Review("Nice coverage", "4.4"));
		courseRepository.addReviewtoCourse(11002L,reviews );
		
		logger.info("\n**********************************************Employee Repository************************\n");
		employeeRepository.insert(new FullTimeEmployee("Tim", new BigDecimal("60000")));
		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("100")));
		logger.info("All Full Time Employees --> {} ", employeeRepository.retreiveAllFullTimeEmployees());
		
		logger.info("All Part Time Employees --> {} ", employeeRepository.retreiveAllPartTimeEmployees());
	}
}
