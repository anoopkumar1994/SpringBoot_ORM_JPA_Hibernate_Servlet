package com.JPAApplaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PokedexInitiatorRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("anoop");
		EntityManager entityMnager = entityManagerFactory.createEntityManager();
		Pokemon p = entityMnager.find(Pokemon.class, "name");
		
		System.out.println(p);
		
	}

}
