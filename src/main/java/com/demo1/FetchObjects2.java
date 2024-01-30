package com.demo1;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchObjects2 
{

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg2.xml").addAnnotatedClass(Product.class);

		//3. SessionFactory object connected with Configuration object
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		//session-1 
		Session session = sessionFactory.openSession();

		
		Query<Product> query2=session.createQuery("delete from Product p1 where p1.id = :pid", Product.class);
		query2.setParameter("pid", 1221);		
		query2.executeUpdate();
		
		
	}

}
