package com.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveObjects 
{

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg2.xml").addAnnotatedClass(Product.class);

		//3. SessionFactory object connected with Configuration object
		SessionFactory sessionFactory = configuration.buildSessionFactory();


		//session-1

		Session session1 = sessionFactory.openSession();

		Product product1 = new Product(); 
		product1.setId(1221);
		product1.setName("Mi"); 
		product1.setModel("m 34");
		product1.setPrice(49762.78);

		Transaction transaction1 = session1.getTransaction();
		transaction1.begin();

		session1.persist(product1);

		transaction1.commit();

		System.out.println("==============session-1==========================");
		
		//session-2
		Session session2 = sessionFactory.openSession();
		
		Product product2 = new Product(); 
		product2.setId(8800);
		product2.setName("OPPO"); 
		product2.setModel("G 7");
		product2.setPrice(134762.12);

		Transaction transaction2 = session2.getTransaction();
		transaction2.begin();

		session2.persist(product2);

		transaction2.commit();


		System.out.println("==============session-2===========================");


	}

}
