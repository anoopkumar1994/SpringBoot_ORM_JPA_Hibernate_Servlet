package com.Student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rollNo;
	
	@Column(name = "Student_name", nullable = false)
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	private StudentIdCard card;
	
	@OneToMany(mappedBy = "student")
	private List<Course> courseList;

	
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public StudentIdCard getCard() {
		return card;
	}
	public void setCard(StudentIdCard card) {
		this.card = card;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
