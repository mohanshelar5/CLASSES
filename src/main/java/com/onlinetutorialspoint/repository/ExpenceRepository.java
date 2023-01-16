package com.onlinetutorialspoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinetutorialspoint.model.Expense;

public interface ExpenceRepository extends JpaRepository<Expense, Long>{

}
