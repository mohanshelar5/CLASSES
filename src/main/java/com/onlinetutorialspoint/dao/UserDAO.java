package com.onlinetutorialspoint.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlinetutorialspoint.model.User;
import com.onlinetutorialspoint.model.pojo.LoginDetails;
import com.onlinetutorialspoint.repository.UserRepository;

@Component
public class UserDAO {
	@Autowired
	UserRepository userRepository;
	
	public User save(User user) {
		return userRepository.save(user);
	}
	public boolean delete(User user) {
		 userRepository.delete(user);
		return true;
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	public Optional<User> getUser(Long id) {
		return userRepository.findById(id);
	}
	
	public User loginUser(LoginDetails loginDetails) {
		return userRepository.findByUserNameAndPassword(loginDetails.getUserName(),loginDetails.getPassword());
	}
}
