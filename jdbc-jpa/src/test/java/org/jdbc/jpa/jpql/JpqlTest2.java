package org.jdbc.jpa.jpql;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.jdbc.jpa.JpaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class JpqlTest2 {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void findByIdBasic() {
		Query query = entityManager.createNativeQuery("select * from COURSE");
		logger.info("Entity manager {}", query.getResultList());
	}
	
	@Test
	public void findByIdBasicWhere() {
		Query query = entityManager.createNativeQuery("select * from COURSE where id=?");
		query.setParameter(1, 11001L);
		logger.info("Entity manager {}", query.getResultList());
	}
	
	@Test
	public void findByIdBasicWhereNamedParam() {
		Query query = entityManager.createNativeQuery("select * from COURSE where id= :id");
		query.setParameter("id", 11001L);
		logger.info("Entity manager {}", query.getResultList());
	}
	
	@Test
	@Transactional
	public void joinedUpdate() {
		Query query = entityManager.createNativeQuery("update COURSE set last_updatetime=sysdate()");
		logger.info("Number of rows updated {}", query.executeUpdate());
	}
	
}
