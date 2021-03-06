package com.carlosrdev.nom35.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {

	// fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "status")
	private Boolean status;

	@ManyToMany
	@JoinTable(
			name = "rol_module", 
			joinColumns = @JoinColumn(name = "rol_id"), 
			inverseJoinColumns = @JoinColumn(name = "module_id")
			)
	private List<Module> modules;

	// constructors

	public Rol() {

	}

	public Rol(String name, Boolean status) {
		this.name = name;
		this.status = status;
	}

	// getters & setters

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

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	// methods

	public void addModule(Module tempModule) {

		if (modules == null) {
			modules = new ArrayList<>();
		}

		modules.add(tempModule);

	}

	// toString() method
	@Override
	public String toString() {
		return "Rol [id=" + id + ", name=" + name + ", status=" + status + "]";
	}

}
