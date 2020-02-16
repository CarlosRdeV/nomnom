package com.carlosrdev.nom35.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rol_id")
	private Rol rol;

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

	// useful methods

	// toString() method
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", status=" + status + ", rol=" + rol + "]";
	}


}
