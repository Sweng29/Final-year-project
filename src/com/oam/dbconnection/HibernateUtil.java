package com.oam.dbconnection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	static{
		if(sessionFactory==null)
		{
			Configuration configuration = new Configuration();
			sessionFactory = configuration.configure().buildSessionFactory();
		}
	}
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
