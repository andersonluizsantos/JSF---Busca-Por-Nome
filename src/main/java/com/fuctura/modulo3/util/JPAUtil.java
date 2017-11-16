package com.fuctura.modulo3.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf;
	private static EntityManager em;

	public static EntityManager getEntityManager() {

		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("fucturaPU");
		}

		if (em == null || !em.isOpen()) {
			em = emf.createEntityManager();
		}

		return em;
	}
}
