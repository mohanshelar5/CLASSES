package com.onlinetutorialspoint.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_package")
public class StudentPackage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
}
