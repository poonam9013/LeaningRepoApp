package com.springboot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.StudentEntity;
import com.springboot.exception.ResourceNotFoundException;
import com.springboot.repository.StudentRepository;
import com.springboot.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService
{

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public StudentEntity addStudent(StudentEntity student) {
		// TODO Auto-generated method stub
		return this.studentRepository.save(student);
	}

	@Override
	public List<StudentEntity> getAllStudent() {
		// TODO Auto-generated method stub
		return this.studentRepository.findAll();
	}

	@Override
	public StudentEntity getStudentById(int studentId) {
		// TODO Auto-generated method stub
		return this.studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("student", "student Id", studentId));
	}

	@Override
	public StudentEntity updateStudentById(StudentEntity student, int studentId) 
	{
		// TODO Auto-generated method stub
		if(!this.studentRepository.existsById(studentId))
		{
			throw new ResourceNotFoundException("student", "student Id", studentId);
		}
		
		return this.studentRepository.save(student);
		
	}

	@Override
	public void deleteStudentById(int studentId) {
		// TODO Auto-generated method stub
		if(!this.studentRepository.existsById(studentId))
		{
			throw new ResourceNotFoundException("student", "student Id", studentId);
		}
		else{
			this.studentRepository.deleteById(studentId);
		}
		
	}

}
