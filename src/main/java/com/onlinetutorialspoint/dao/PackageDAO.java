package com.onlinetutorialspoint.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.onlinetutorialspoint.model.Person;

public class PackageDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public String savePackage(Package packagevalue) {
		Long isSuccess = (Long)getSession().save(packagevalue);
		if(isSuccess >= 1){
			return "Success";
		}else{
			return "Error while Saving Person";
		}
		
	}
	public boolean delete(Package packageValue) {
		getSession().delete(packageValue);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Package> getAllPersons() {
		return getSession().createQuery("from Package").list();
	}
}
