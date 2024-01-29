package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteObjects 
{

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);

		//3. SessionFactory object connected with Configuration object
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session1 = sessionFactory.openSession();

		Employee employee1 = new Employee(); 
		employee1.setId(1019);
	
		Employee employee2 = session1.get(Employee.class, employee1.getId());

		Transaction transaction1 = session1.getTransaction();
		transaction1.begin();
		  
		session1.remove(employee2);
		
		transaction1.commit();	
		
		
	}

}
