package com.demo1;

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
		configuration.configure("hibernate.cfg2.xml").addAnnotatedClass(Product.class);

		//3. SessionFactory object connected with Configuration object
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		//session-1 
		Session session = sessionFactory.openSession();

		Query<Product> query=session.createQuery("From Product", Product.class);
		//HQL query: From Employee
		//SQL query: select * from employee;
		
		List<Product> list = query.list();
		
		for(Product employee: list)
		{
			System.out.println(employee.toString());
		}
		
		System.out.println("============================================================");
		
		Query<Product> query1=session.createQuery("From Product p1 where p1.id = 2011", Product.class);
				
		List<Product> list1 = query1.list();
		
		for(Product employee: list1)
		{
			System.out.println(employee.toString());
		}
		
		
		System.out.println("============================================================");
		
		Query query2=session.createQuery("SELECT p1.name, p1.price From Product p1", Product.class);
		
		List list2 = query2.list();
		
		Iterator iterator = list2.iterator();
		
		while(iterator.hasNext())
		{
			Object objects[] = (Object[])iterator.next();
			
			for(Object object: objects)
			{
				System.out.println(object.toString());
			}
			System.out.println();
		}
		
	}

}
