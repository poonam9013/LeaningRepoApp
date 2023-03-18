package com.springboot.entity;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



/*
 * create student entity and its parameters
 *  */
@Entity
@Table(name="Student")
public class StudentEntity {
	
	@Id 						//To make StId as Primery Key
	@GeneratedValue(strategy = GenerationType.AUTO)		//To auto increment the value of stID
	private int stId;
	@Column(nullable = false, length =20)
	private String stName;
	@Column(unique = true)
	private String stEmail;
	@Column(nullable = false, length = 15)
	private String password;
	@Column(nullable = false)
	private String stAge;
	@Column(nullable = false)
	private String stClass;
	
	@OneToMany(mappedBy = "student1",cascade = CascadeType.ALL)         //Association or communication b/w two entities
   
   // private Set<CourseEntity>	courselist;
	//ArrayList<CourseEntity> courselist = new ArrayList<>();
	private List<CourseEntity> courselist = new ArrayList();

	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getStEmail() {
		return stEmail;
	}

	public void setStEmail(String stEmail) {
		this.stEmail = stEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStAge() {
		return stAge;
	}

	public void setStAge(String stAge) {
		this.stAge = stAge;
	}

	public String getStClass() {
		return stClass;
	}

	public void setStClass(String stClass) {
		this.stClass = stClass;
	}

	public List<CourseEntity> getCourselist() {
		return courselist;
	}

	public void setCourselist(List<CourseEntity> courselist) {
		this.courselist = courselist;
	}

	@Override
	public String toString() {
		return "StudentEntity [stId=" + stId + ", stName=" + stName + ", stEmail=" + stEmail + ", password=" + password
				+ ", stAge=" + stAge + ", stClass=" + stClass + ", courselist=" + courselist + "]";
	}

	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
