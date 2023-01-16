package com.onlinetutorialspoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onlinetutorialspoint.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserNameAndPassword(String userName,String password);
	
	@Query("SELECT e FROM User e WHERE e.type = :type")
    public List<User> listUsers(@Param("type") String type);
}
