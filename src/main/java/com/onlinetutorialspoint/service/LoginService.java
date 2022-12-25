package com.onlinetutorialspoint.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlinetutorialspoint.dao.UserDAO;
import com.onlinetutorialspoint.model.User;
import com.onlinetutorialspoint.model.pojo.LoginDetails;

public class LoginService {

	@Autowired
	private UserDAO userDAO;

	public User loginUser(LoginDetails loginDetails) {

		return userDAO.loginUser(loginDetails);
	}
}