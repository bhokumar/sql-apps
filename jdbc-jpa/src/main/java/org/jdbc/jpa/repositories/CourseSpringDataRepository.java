package org.jdbc.jpa.repositories;

import java.util.List;

import org.jdbc.jpa.modal.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="/courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
	List<Course> findByName(String name);
	List<Course> findByNameAndId(String name, Long id);
	List<Course> countByName(String name);
	List<Course> findByNameOrderByIdDesc(String name);
	List<Course> deleteByName(String name);
	@Query("Select c from Course c where name like '%pattern%'")
	List<Course> courseWithSpecificPattern(String name);
	
	@Query(value = "Select * from Course c where name like '%pattern%'",
			nativeQuery=true)
	List<Course> courseWithNativeQuery(String name);
}
