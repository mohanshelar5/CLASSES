package com.onlinetutorialspoint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_mst")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	@Column(name="MENU_NAME")
	private String name;
	@Column(name="ROLE_ID")
	private String city;

	public Person() {
		super();
	}

	public Long getId() {
		return ID;
	}

	public void setId(Long id) {
		this.ID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Person [pid=" + ID + ", pName=" + name + ", pCity=" + city
				+ "]";
	}

}

