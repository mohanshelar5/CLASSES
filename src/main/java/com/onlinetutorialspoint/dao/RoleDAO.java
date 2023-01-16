package com.onlinetutorialspoint.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.onlinetutorialspoint.model.Role;

public class RoleDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public String saveRole(Role role) {
		Long isSuccess = (Long)getSession().save(role);
		if(isSuccess >= 1){
			return "Success";
		}else{
			return "Error while Saving Person";
		}
		
	}
	public boolean delete(Role role) {
		getSession().delete(role);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Role> getAllPersons() {
		return getSession().createQuery("from Role").list();
	}
}
