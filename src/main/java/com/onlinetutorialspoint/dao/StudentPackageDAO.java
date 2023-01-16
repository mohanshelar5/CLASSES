package com.onlinetutorialspoint.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.onlinetutorialspoint.model.StudentPackage;

public class StudentPackageDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public String saveStudentPackage(StudentPackage studentPackage) {
		Long isSuccess = (Long)getSession().save(studentPackage);
		if(isSuccess >= 1){
			return "Success";
		}else{
			return "Error while Saving Person";
		}
		
	}
	public boolean delete(StudentPackage studentPackage) {
		getSession().delete(studentPackage);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<StudentPackage> getAllPersons() {
		return getSession().createQuery("from StudentPackage").list();
	}
}
