package com.demo1;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchObjects1 
{

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg2.xml").addAnnotatedClass(Product.class);

		//3. SessionFactory object connected with Configuration object
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		//session-1 
		Session session = sessionFactory.openSession();

		
		Query query2=session.createQuery("select p1.name, p1.price from Product p1 order by p1.name", Product.class);
		
		//set paginations
		query2.setFirstResult(1);
		query2.setMaxResults(4);
		
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
