package org.jdbc.jpa.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.jdbc.jpa.JpaApplication;
import org.jdbc.jpa.modal.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class JpqlTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void findByIdBasic() {
		List resultList = entityManager.createQuery("Select c from Course c").getResultList();
		logger.info("Entity manager {}", resultList);
	}
	
	@Test
	public void findByIdBasicType() {
		List<Course> resultList = entityManager.createQuery("Select c from Course c", Course.class).getResultList();
		logger.info("Entity manager {}", resultList);
	}
	
	
	
	@Test
	public void findByIdWhereCondition() {
		List<Course> resultList = entityManager.createQuery("Select c from Course c where name like '%R'", Course.class).getResultList();
		logger.info("Entity manager {}", resultList);
	}
	
	@Test
	public void findByIdWhereConditionNamedQuery() {
		TypedQuery<Course> query = entityManager.createNamedQuery("queryGetAllCourses", Course.class);
		
		logger.info("Entity manager {}", query.getResultList());
	}
}
