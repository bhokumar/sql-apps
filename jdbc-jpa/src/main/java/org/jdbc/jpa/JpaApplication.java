package org.jdbc.jpa;

import org.jdbc.jpa.repositories.CourseRepository;
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
		
		logger.info("\n**********************************************Course Repository************************\n");
		
		
		/*********************************************Course Repository*********************************/
		courseRepository.addReviewtoCourse();
		
		
	}
}
