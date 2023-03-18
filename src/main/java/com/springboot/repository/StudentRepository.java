package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>
{
	

}
