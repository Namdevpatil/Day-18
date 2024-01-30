package com.demo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchObjects4 
{

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);

		//3. SessionFactory object connected with Configuration object
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		//session-1 
		Session session = sessionFactory.openSession();

		
		Query query2=session.createQuery("select e1.id, e1.name, e1.role from Employee e1 order by e1.id desc");
		
		List list2 = query2.list();
		
		Iterator iterator = list2.iterator();
		
		while(iterator.hasNext())
		{
			
			Object objects[] = (Object[])iterator.next();
			
			for(Object object: objects)
			{
				System.out.println(object.toString());
				
			}
			System.out.println("----------------------------------");
		}
		
	}

}
