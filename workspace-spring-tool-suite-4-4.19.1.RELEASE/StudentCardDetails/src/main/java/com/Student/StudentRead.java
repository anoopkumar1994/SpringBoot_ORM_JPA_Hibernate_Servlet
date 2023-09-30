package com.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("anoop1");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Student s1 = entityManager.find(Student.class, 2);
		System.out.println(s1.getName());
		for(Course c : s1.getCourseList()) {
			System.out.println(c.getCourseName());
		}
		
//		System.out.println(s1.getCard().getIdCard() + " " + s1.getCard().getSoftwareVersion());
		
		
//		StudentIdCard s2 = entityManager.find(StudentIdCard.class, 3);
//		System.out.println(s2.getStudent().getName() + " " + s2.getIdCard() + " " + s2.getSoftwareVersion());
		
//		Course c1 = entityManager.find(Course.class, 5);
//		System.out.println(c1.getCourseName() + " " + c1.getStudent().getName());
		
		
	}

}
