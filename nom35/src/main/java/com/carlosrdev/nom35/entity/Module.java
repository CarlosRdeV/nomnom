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
@Table(name = "module")
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToMany
	@JoinTable(
			name = "rol_module", 
			joinColumns = @JoinColumn(name = "module_id"), 
			inverseJoinColumns = @JoinColumn(name = "rol_id")
			)
	private List<Rol> roles;

	public Module() {

	}

	public Module(String name) {
		this.name = name;
	}

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

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public void addRol(Rol tempRol) {

		if (roles == null) {
			roles = new ArrayList<>();
		}

		roles.add(tempRol);

	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", name=" + name + ", roles=" + roles + "]";
	}

}
