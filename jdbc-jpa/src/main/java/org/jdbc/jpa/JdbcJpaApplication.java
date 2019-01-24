package org.jdbc.jpa;

import java.util.List;

import org.jdbc.jpa.modal.Person;
import org.jdbc.jpa.repositories.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
	}

}

