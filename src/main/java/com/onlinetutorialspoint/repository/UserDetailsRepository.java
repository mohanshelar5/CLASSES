package com.onlinetutorialspoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onlinetutorialspoint.model.User;
import com.onlinetutorialspoint.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{
	@Query("SELECT e FROM UserDetails e WHERE e.user_type = :user_type")
    public List<UserDetails> listUsers(@Param("user_type") String user_type);
}
