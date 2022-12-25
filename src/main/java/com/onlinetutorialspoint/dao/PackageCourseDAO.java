package com.onlinetutorialspoint.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.onlinetutorialspoint.model.PackageCourse;
import com.onlinetutorialspoint.model.Person;

public class PackageCourseDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public String savePackageCourse(PackageCourse packageCourse) {
		Long isSuccess = (Long)getSession().save(packageCourse);
		if(isSuccess >= 1){
			return "Success";
		}else{
			return "Error while Saving Person";
		}
		
	}
	public boolean delete(PackageCourse packageCourse) {
		getSession().delete(packageCourse);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<PackageCourse> getAllPersons() {
		return getSession().createQuery("from PackageCourse").list();
	}
}
