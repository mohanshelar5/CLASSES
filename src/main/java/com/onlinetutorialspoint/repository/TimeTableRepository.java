package com.onlinetutorialspoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinetutorialspoint.model.TimeTable;

public interface TimeTableRepository extends JpaRepository<TimeTable, Long>{

}
