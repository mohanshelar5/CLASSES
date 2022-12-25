package com.onlinetutorialspoint.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.onlinetutorialspoint.model.UserDetails;

public class UserDetailsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public String saveStudent(UserDetails student) {
		Long isSuccess = (Long)getSession().save(student);
		if(isSuccess >= 1){
			return "Success";
		}else{
			return "Error while Saving Person";
		}
		
	}
	public boolean delete(UserDetails student) {
		getSession().delete(student);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<UserDetails> getAllPersons() {
		return getSession().createQuery("from Student").list();
	}
}
