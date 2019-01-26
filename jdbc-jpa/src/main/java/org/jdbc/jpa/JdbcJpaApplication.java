package org.jdbc.jpa;

import java.util.Date;
import java.util.List;

import org.jdbc.jpa.modal.Person;
import org.jdbc.jpa.repositories.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

//@SpringBootApplication
public class JdbcJpaApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(JdbcJpaApplication.class);
	
	@Autowired
	private PersonJdbcDAO personJdbcDAO;
	public static void main(String[] args) {
		SpringApplication.run(JdbcJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Person> persons = personJdbcDAO.findAll();
		logger.info("All Persons --> {}", persons);
		logger.info("\nUser from findbyId   --->{}", personJdbcDAO.findById(10001));
		logger.info("\nUser from Delete By   --->{}", personJdbcDAO.deleteById(10001));
		logger.info("\nUser from insert   --->{}", personJdbcDAO.insert(new Person(10005, "Raj", "Banglore", new Date())));
		logger.info("\nUser from Update   --->{}", personJdbcDAO.update(new Person(10005, "bijendra", "Delhi", new Date())));
	}

}

