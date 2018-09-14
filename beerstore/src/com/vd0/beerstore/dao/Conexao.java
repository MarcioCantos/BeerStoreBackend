package com.vd0.beerstore.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("beerstore");
	
	public static EntityManagerFactory getInstance() {
		try {
			
			return emf;
			
		} catch (RuntimeException | Error e) { e.printStackTrace(); throw e; }
	}
	
}
