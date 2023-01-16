package com.onlinetutorialspoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetutorialspoint.dao.UserDAO;
import com.onlinetutorialspoint.model.User;
import com.onlinetutorialspoint.model.pojo.LoginDetails;

@Service
public class LoginService {

	@Autowired
	private UserDAO userDAO;
	
	public User loginUser(LoginDetails loginDetails) {

		return userDAO.loginUser(loginDetails);
	}
	public List<User> getAllUser() {

		return userDAO.getAllUser();
	}
	public boolean deleteUser(User user) {

		return userDAO.delete(user);
	}
	public User save(User user) {

		return userDAO.save(user);
	}
}
