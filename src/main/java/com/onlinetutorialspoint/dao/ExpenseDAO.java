package com.onlinetutorialspoint.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.onlinetutorialspoint.model.Expense;
import com.onlinetutorialspoint.model.Person;

public class ExpenseDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public String saveExpense(Expense expense) {
		Long isSuccess = (Long)getSession().save(expense);
		if(isSuccess >= 1){
			return "Success";
		}else{
			return "Error while Saving Person";
		}
		
	}
	public boolean delete(Expense expense) {
		getSession().delete(expense);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Expense> getAllPersons() {
		return getSession().createQuery("from Expense").list();
	}
}
