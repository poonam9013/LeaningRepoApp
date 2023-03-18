package com.springboot.serviceimpl;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.entity.CourseEntity;
import com.springboot.entity.StudentEntity;
import com.springboot.exception.ResourceNotFoundException;
import com.springboot.repository.CourseRepository;
import com.springboot.repository.StudentRepository;
import com.springboot.service.CourseService;

@org.springframework.stereotype.Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public CourseEntity addCourse(CourseEntity course) {
		
		return this.courseRepository.save(course);
	}

	@Override
	public List<CourseEntity> getAllCourses() {
		
		return this.courseRepository.findAll();
	}

	@Override
	public CourseEntity getCourseById(int courseId) {
		if(!this.courseRepository.existsById(courseId))
		{
			throw new ResourceNotFoundException("course", "Course ID", courseId);
		}
		else
		{
			return this.courseRepository.findById(courseId).get();
		}
	}

	@Override
	public CourseEntity updateCourseById(CourseEntity course, int courseId) {
		
		if(!this.courseRepository.existsById(courseId))
		{
			throw new ResourceNotFoundException("course", "Course ID", courseId);
		}
		else
		{
			return this.courseRepository.save(course);
		}
	}

	@Override
	public void deleteCourse(int courseId) {
		if(!this.courseRepository.existsById(courseId)) {
			throw new ResourceNotFoundException("course", "Course Id", courseId);
		}
		else {
			this.courseRepository.deleteById(courseId);
		}
	}

	@Override
	public List<CourseEntity> getCourseEnrolledBySid(int studentId) {
		// TODO Auto-generated method stub
		StudentEntity studentEntity = this.studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("student", "student Id", studentId));
		return studentEntity;
	}

}
