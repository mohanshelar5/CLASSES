package com.onlinetutorialspoint.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.onlinetutorialspoint.model.User;
import com.onlinetutorialspoint.model.pojo.LoginDetails;

public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public String saveUser(User user) {
		Long isSuccess = (Long)getSession().save(user);
		if(isSuccess >= 1){
			return "Success";
		}else{
			return "Error while Saving Person";
		}
		
	}
	public boolean delete(User user) {
		getSession().delete(user);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
		return getSession().createQuery("from User").list();
	}
	public User loginUser(LoginDetails loginDetails) {
		
		Query query=getSession().createQuery("from User where user_name=:username and password=:password");
		query.setParameter("username", loginDetails.getUserName());
		query.setParameter("password", loginDetails.getPassword());
		User user=(User)query.uniqueResult();
		return user;
	}
}
