package com.onlinetutorialspoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetutorialspoint.dao.UserDAO;
import com.onlinetutorialspoint.dao.UserDetailsDAO;
import com.onlinetutorialspoint.model.User;
import com.onlinetutorialspoint.model.UserDetails;

@Service
public class StudentService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserDetailsDAO userDetailsDAO;

	public List<UserDetails> getAllStudent() {

		return userDetailsDAO.getAllUser("S");
	}
	
	public List<UserDetails> save(UserDetails userDetails) {
		User user=new User();
		user.setUserName(userDetails.getEmail());
		user.setPassword("12345");
		user.setType("S");
		userDetails.setUsers(user);
		user.setUserDetails(userDetails);
		User usavedUser=userDAO.save(user);
		return userDetailsDAO.getAllUser("S");
		
	}
}
