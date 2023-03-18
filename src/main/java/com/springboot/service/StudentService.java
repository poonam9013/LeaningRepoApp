package com.springboot.service;

import java.util.List;

import com.springboot.entity.StudentEntity;

public interface StudentService {

	//To add new record of student
	StudentEntity addStudent(StudentEntity student);
	//To get all the student list
	List<StudentEntity> getAllStudent();
	//to get student record by id
	StudentEntity getStudentById(int studenId);
	//to update the student record by id
	StudentEntity updateStudentById(StudentEntity student, int studenId);
	//to delete the student record by id
	public void deleteStudentById(int studentId);
}
