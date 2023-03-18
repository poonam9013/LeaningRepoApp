package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.CourseEntity;
import com.springboot.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseServ;
	@PostMapping("/")
	public ResponseEntity<CourseEntity> addCourse(@RequestBody CourseEntity course )
	{
		CourseEntity addcourse = this.courseServ.addCourse(course);
		return new ResponseEntity<CourseEntity>(addcourse, HttpStatus.CREATED);
	}
	

}
