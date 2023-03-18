package com.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Course")
public class CourseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
	
	@Column(nullable = false, length = 20)
	private String courseName;
	
	@Column(nullable = false, length =20)
	private String courseDuration;
	
	@Column(nullable = false, length =20)
	private double courseFee;
	
	@ManyToOne
	@JoinColumn(name="s_id")
	private StudentEntity student1;
	
	
	public StudentEntity getStudent() {
		return student1;
	}
	public void setStudent(StudentEntity student) {
		this.student1 = student;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	public double getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}
	public CourseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CourseEntity [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration="
				+ courseDuration + ", courseFee=" + courseFee + ", student1=" + student1 + "]";
	}

}
