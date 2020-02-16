package com.carlosrdev.nom35.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	// fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "status")
	private Boolean status;

	// ONE TO ONE RELATIONSHIP
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rol_id")
	private Rol rol;

	// MANY TO ONE RELATIONSHIP
	@OneToMany(mappedBy = "user",
				cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
						   CascadeType.DETACH,CascadeType.REFRESH})
	private List<Course> courses;

	// constructors

	public User() {

	}

	public User(String name, Boolean status) {
		this.name = name;
		this.status = status;
	}

	// Getter and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	// useful methods
	public void addCourse(Course tempCourse) {
		
		if(courses == null) {
			courses = new ArrayList<>();
		}
		
		courses.add(tempCourse);
		
		tempCourse.setUser(this);
	}

	// toString() method
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", status=" + status + ", rol=" + rol + "]";
	}

}
