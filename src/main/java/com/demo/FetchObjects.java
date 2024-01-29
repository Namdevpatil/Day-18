package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchObjects 
{

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);

		//3. SessionFactory object connected with Configuration object
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		//session-1 
		Session session = sessionFactory.openSession();

		Employee employee1 = new Employee();
		employee1.setId(2100);
		
		Employee employee = session.get(Employee.class, employee1.getId());
		
		System.out.println(employee.getId()+" | "+employee.getName()+" | "+employee.getRole());


	}

}
