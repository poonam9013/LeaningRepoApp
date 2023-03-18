package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.StudentEntity;
import com.springboot.exception.ApiResponse;
import com.springboot.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@PostMapping("/")
	public ResponseEntity<StudentEntity> addStudent(@RequestBody StudentEntity student) 
	{
		/*StudentEntity student = new StudentEntity();
		student.setStId(1);
		student.setStName("Anjali");
		student.setStEmail("poonam@gmail.com");
		student.setStClass("MCA");
		
		student.setStAge("23");
		student.setPassword("12345");*/
		
		StudentEntity savedStudent = this.studentService.addStudent(student);
		return new ResponseEntity<StudentEntity>(savedStudent, HttpStatus.CREATED);
		
	}
	//Get all student data
	@GetMapping("/")
	public ResponseEntity<List<StudentEntity>> getAllStudent()
	{
		List<StudentEntity> allStudent = this.studentService.getAllStudent();
		return new ResponseEntity<List<StudentEntity>>(allStudent, HttpStatus.OK);
		
	}
	@GetMapping("/{studentId}")
	public ResponseEntity<StudentEntity> getStudentById(@PathVariable("studentId") int studentId)
	{
		
		StudentEntity studentById = this.studentService.getStudentById(studentId);
		return new ResponseEntity<StudentEntity>(studentById, HttpStatus.OK);
	}
	@PutMapping("/{studentId}")
	public ResponseEntity<StudentEntity> updateStudentById(@RequestBody StudentEntity student, @PathVariable int studentId )
	{
		StudentEntity updateStudent = this.studentService.updateStudentById(student, studentId);
		return new ResponseEntity<StudentEntity>(updateStudent, HttpStatus.OK);	
	}
	@DeleteMapping("/{studentId}")
	public ResponseEntity<ApiResponse> deleteStudentById(@PathVariable int studentId)
	{	
		this.studentService.deleteStudentById(studentId);
		ApiResponse response = new ApiResponse();
		response.setMessage("Student record deleted successfully with Id" +studentId);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK); 
		
	}
}
