package com.hibernetDemo.HibernateDemo;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student {
	@Id
	private int id;
	private String name;
	private int rollNo;
	private int marks;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		
		return this.id + " " + this.name + " " + this.rollNo + " " +
				this.marks;
	}
	
	
	
	

}
