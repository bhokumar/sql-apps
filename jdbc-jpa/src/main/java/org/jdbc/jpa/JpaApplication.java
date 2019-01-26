package org.jdbc.jpa;

import java.util.Date;

import org.jdbc.jpa.modal.Person;
import org.jdbc.jpa.repositories.PersonJPARepository;
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
	PersonJPARepository jpaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\nFound User --> {}", jpaRepository.findbyId(10001));
		Person person = new Person();
		
		logger.info("\nUpdate User --> {}", jpaRepository.update(new Person(10001, "Rathore", "Noida", new Date())));
		
		logger.info("\nInsert User --> {}", jpaRepository.update(new Person(10004, "Rathore", "Noida", new Date())));
		
		logger.info("\nUser Deleted -->");
		jpaRepository.deleteById(10002);
		
		logger.info("All Users {}", jpaRepository.findAll());
	}
}
