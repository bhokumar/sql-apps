package org.jdbc.jpa.modal;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
//@Entity
//@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name = "EMPLOYEE_TYPE")
public abstract class Employee {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	public Employee() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "\nEmployee [id=" + id + ", name=" + name + "]";
	}
	
	
}
