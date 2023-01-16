package com.onlinetutorialspoint.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.onlinetutorialspoint.model.FeeCollection;

public class FeeCollectionDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public String saveFeeCollection(FeeCollection feeCollection) {
		Long isSuccess = (Long)getSession().save(feeCollection);
		if(isSuccess >= 1){
			return "Success";
		}else{
			return "Error while Saving Person";
		}
		
	}
	public boolean delete(FeeCollection feeCollection) {
		getSession().delete(feeCollection);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<FeeCollection> getAllPersons() {
		return getSession().createQuery("from FeeCollection").list();
	}
}
