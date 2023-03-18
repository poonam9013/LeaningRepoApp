package com.springboot.service;

import java.util.List;

import com.springboot.entity.CourseEntity;


public interface CourseService 
{
	//add Course
	CourseEntity addCourse(CourseEntity course);
	//getAllCourses
	List<CourseEntity> getAllCourses();
	//getCourseById
	CourseEntity getCourseById(int courseId);
	//UpdateCourseById
	CourseEntity updateCourseById(CourseEntity course,int courseId);
	//Delete Courses
	public void deleteCourse(int courseId);
	//getCourseBystudentId
	List<CourseEntity> getCourseEnrolledBySid(int studentId); 

}
