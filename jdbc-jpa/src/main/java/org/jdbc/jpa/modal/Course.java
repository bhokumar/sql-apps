package org.jdbc.jpa.modal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries(value = { @NamedQuery(name = "queryGetAllCourses", query = "Select c from Course c"),
		@NamedQuery(name = "queryLikeName", query = "Select c from Course c where name like '%R'") })
@Cacheable
@SQLDelete(sql = "update course set is_deleted=true where id=?")
@Where(clause = "is_deleted = false")
public class Course {
	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "COURSE_STUDENT", 
		joinColumns = @JoinColumn(name = "COURSE_ID"), 
		inverseJoinColumns = @JoinColumn(name = "STUDENT_ID")
	)
	@JsonIgnore
	private List<Student> students = new ArrayList<>();

	@UpdateTimestamp
	private LocalDateTime lastUpdatetime;

	@CreationTimestamp
	private LocalDateTime creationTime;
	
	private Boolean isDeleted;
	
	@PreRemove
	private void preRemove() {
		this.isDeleted = true;
	}

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

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public void removeStudent(Student student) {
		this.students.remove(student);
	}
	
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "\nCourse [id=" + id + ", name=" + name + "]";
	}
}
