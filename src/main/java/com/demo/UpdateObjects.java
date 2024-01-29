package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateObjects 
{

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);

		//3. SessionFactory object connected with Configuration object
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session1 = sessionFactory.openSession();

		Employee employee1 = new Employee(); 
		employee1.setId(2100);
	
		Employee employee2 = session1.get(Employee.class, employee1.getId());

		employee2.setName("Raj Kumar");
		
		Transaction transaction1 = session1.getTransaction();//1.2 Transaction object connected with Session object
		transaction1.begin();
		  
		session1.persist(employee2);
		
		transaction1.commit();
		
		
	}

}
