package org.jdbc.jpa.modal;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "queryGetAllCourses",query = "Select c from Course c"),
		@NamedQuery(name = "queryLikeName",query = "Select c from Course c where name like '%R'")
})
public class Course {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatetime;
	
	@CreationTimestamp
	private LocalDateTime creationTime;

	protected Course() {
	}

	public Course(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
}
