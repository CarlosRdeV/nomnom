package com.carlosrdev.nom35.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	// MANY TO ONE RELATIONSHIP
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	// constructors
	public Course() {

	}

	public Course(String title, User user) {
		this.title = title;
		this.user = user;
	}

	// getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// methods

	// toString() method

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", user=" + user + "]";
	}

}
