package com.onlinetutorialspoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinetutorialspoint.model.StudentPackage;

public interface StudentPackageRepository extends JpaRepository<StudentPackage, Long>{

}
