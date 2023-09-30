package com.Student;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		
		Student s1 = new Student();
		s1.setName("Ram");
		
		Student s2 = new Student();
		s2.setName("Shyam");	
		
		StudentIdCard sc1 = new StudentIdCard();
		sc1.setSoftwareVersion("1.0.1");
		sc1.setStudent(s1);
		
		StudentIdCard sc2 = new StudentIdCard();
		sc2.setSoftwareVersion("1.0.2");
		sc2.setStudent(s2);
		
		Course c1 = new Course();
		c1.setCourseName("Java");
		
		Course c2 = new Course();
		c2.setCourseName("DBMS");

		s1.setCard(sc1);
		s2.setCard(sc2);
		
		List<Course> l1 = new ArrayList<>();
		l1.add(c1);
		l1.add(c2);
		
		List<Course> l2 = new ArrayList<>();
		l1.add(c2);
		
		s1.setCourseList(l1);
		s2.setCourseList(l2);
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("anoop1");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityManager.persist(sc1);
		entityManager.persist(sc2);
		entityManager.persist(c1);
		entityManager.persist(c2);
		entityTransaction.commit();
	}
}
