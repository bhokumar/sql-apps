package org.jdbc.jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.jdbc.jpa.JpaApplication;
import org.jdbc.jpa.modal.Course;
import org.jdbc.jpa.repositories.CourseSpringDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class CourseSpringDataRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseSpringDataRepository courseSpringDataRepository;

	@Test
	public void findByIdCoursePresent() {
		logger.info("Spring data repository");
		Optional<Course> course = courseSpringDataRepository.findById(11001L);
		logger.info("{}", course.isPresent());

	}

	@Test
	public void findByIdCourseNotPresent() {
		logger.info("Spring data repository");
		Optional<Course> course = courseSpringDataRepository.findById(20001L);
		logger.info("{}", course.isPresent());

	}

	@Test
	public void sort() {
		Sort sort = new Sort(Sort.Direction.ASC, "name");
		logger.info("Spring data repository", courseSpringDataRepository.findAll(sort));
	}
	
	@Test
	public void pagination() {
		PageRequest pageRequest = PageRequest.of(1, 3);
		Page<Course> firstPage = courseSpringDataRepository.findAll(pageRequest);
		
		logger.info("Spring data repository", firstPage.getContent());
		Pageable nextPageable = firstPage.nextPageable();
		Page<Course> secondPage = courseSpringDataRepository.findAll(nextPageable);
		logger.info("Second Page {}", secondPage.getContent());
	}
	
	
	@Test
	public void findByName() {
		List<Course> findByName = courseSpringDataRepository.findByName("Name");
		logger.info("Find by namne {}", findByName);
	}
}
