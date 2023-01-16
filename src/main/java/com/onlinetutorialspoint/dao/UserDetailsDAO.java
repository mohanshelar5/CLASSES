package com.onlinetutorialspoint.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlinetutorialspoint.model.User;
import com.onlinetutorialspoint.model.UserDetails;
import com.onlinetutorialspoint.repository.UserDetailsRepository;
import com.onlinetutorialspoint.repository.UserRepository;

@Component
public class UserDetailsDAO {
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public UserDetails save(UserDetails userDetails) {
		return userDetailsRepository.save(userDetails);
	}
	public boolean delete(UserDetails userDetails) {
		userDetailsRepository.delete(userDetails);
		return true;
	}

	public List<UserDetails> getAllUser(String userType) {
		return userDetailsRepository.listUsers(userType);
	}
	
	
}
