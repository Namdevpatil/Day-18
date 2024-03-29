package com.demo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchObjects 
{

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);

		//3. SessionFactory object connected with Configuration object
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		//session-1 
		Session session = sessionFactory.openSession();

		Query<Employee> query=session.createQuery("From Employee");
		//HQL query: From Employee
		//SQL query: select * from employee;
		
		List<Employee> list = query.list();
		
		for(Employee employee: list)
		{
			System.out.println(employee.toString());
		}
		
		System.out.println("============================================================");
		
		Query<Employee> query1=session.createQuery("From Employee e1 where e1.id = 2100");
				
		List<Employee> list1 = query1.list();
		
		for(Employee employee: list1)
		{
			System.out.println(employee.toString());
		}
		
		
		System.out.println("============================================================");
		
		Query<Employee> query2=session.createQuery("SELECT e1.name, e1.role From Employee e1");
		
		List<Employee> list2 = query2.list();
		
		Iterator<Employee> iterator = list2.iterator();
		
		while(iterator.hasNext())
		{
			Employee employee = iterator.next();
			System.out.println(employee);
		}
		
	}

}
