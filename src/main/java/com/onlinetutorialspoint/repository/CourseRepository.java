package com.onlinetutorialspoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinetutorialspoint.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
