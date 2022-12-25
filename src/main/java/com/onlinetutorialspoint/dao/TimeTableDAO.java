package com.onlinetutorialspoint.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.onlinetutorialspoint.model.TimeTable;

public class TimeTableDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public String saveTimeTable(TimeTable timeTable) {
		Long isSuccess = (Long)getSession().save(timeTable);
		if(isSuccess >= 1){
			return "Success";
		}else{
			return "Error while Saving Person";
		}
		
	}
	public boolean delete(TimeTable timeTable) {
		getSession().delete(timeTable);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<TimeTable> getAllPersons() {
		return getSession().createQuery("from TimeTable").list();
	}
}
