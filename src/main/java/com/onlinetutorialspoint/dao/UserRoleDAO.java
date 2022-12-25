package com.onlinetutorialspoint.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.onlinetutorialspoint.model.UserRole;

public class UserRoleDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public String saveUserRole(UserRole userRole) {
		Long isSuccess = (Long)getSession().save(userRole);
		if(isSuccess >= 1){
			return "Success";
		}else{
			return "Error while Saving Person";
		}
		
	}
	public boolean delete(UserRole userRole) {
		getSession().delete(userRole);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<UserRole> getAllPersons() {
		return getSession().createQuery("from UserRole").list();
	}
}
