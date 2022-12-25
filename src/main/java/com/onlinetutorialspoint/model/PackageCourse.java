package com.onlinetutorialspoint.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "package_course")
public class PackageCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
}
