package org.jdbc.jpa.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy = "students")
	private List<Course> courses = new ArrayList<>();
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Passport passport;
		
	public Student() {
	}

	public Student(String name) {
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
	
	

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}
	
	public void removeCourse(Course course) {
		this.courses.remove(course);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
