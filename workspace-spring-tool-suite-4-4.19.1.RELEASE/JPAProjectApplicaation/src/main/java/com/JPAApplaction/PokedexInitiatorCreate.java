package com.JPAApplaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PokedexInitiatorCreate {

	public static void main(String[] args) {
		
		Pokemon p = new Pokemon();
		p.setName("Pikachu");
		p.setType("Electro type");
		p.setPower("100");
		p.setColor(Color.YELLOW);
		
		Pokemon p1 = new Pokemon();
		p1.setName("Chrlizrd");
		p1.setType("Fire typre");
		p1.setPower("300");
		p1.setColor(Color.ORANGE);
		
		Pokemon p2 = new Pokemon();
		p2.setName("Meouth");
		p2.setType("Cat");
		p2.setPower("80");
		p2.setColor(Color.CREAM);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("anoop");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(p);
		entityManager.persist(p1);
		entityManager.persist(p2);
		entityTransaction.commit();

	}

}
