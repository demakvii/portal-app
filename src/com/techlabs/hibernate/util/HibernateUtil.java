package com.techlabs.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration();
			System.out.println(configuration.getClass());
			sessionFactory = configuration.configure("hibernate.cfg.xml")
					.buildSessionFactory();
			System.out.println(sessionFactory.getClass());
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session openSession() {
		return sessionFactory.openSession();
	}

	public static void closeSession() {
		if (!sessionFactory.isClosed())
			sessionFactory.close();
	}
}
