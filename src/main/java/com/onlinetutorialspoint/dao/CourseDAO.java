package com.onlinetutorialspoint.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.onlinetutorialspoint.model.Course;
import com.onlinetutorialspoint.model.Person;

public class CourseDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public String saveCourse(Course course) {
		Long isSuccess = (Long)getSession().save(course);
		if(isSuccess >= 1){
			return "Success";
		}else{
			return "Error while Saving Person";
		}
		
	}
	public boolean delete(Course course) {
		getSession().delete(course);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Course> getAllPersons() {
		return getSession().createQuery("from Course").list();
	}
}
