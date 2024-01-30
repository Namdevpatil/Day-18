package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveObjects 
{
	
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
		
		//3. SessionFactory object connected with Configuration object
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//session-1 
		
		 
		/*
		 * Session session = sessionFactory.openSession();
		 * 
		 * Employee employee = new Employee(); employee.setId(1019);
		 * employee.setName("Dev"); employee.setRole("Software Engineer");
		 * 
		 * Transaction transaction = session.getTransaction(); transaction.begin();
		 * 
		 * session.persist(employee);//
		 * 
		 * transaction.commit();
		 * 
		 * System.out.println("==============session-1===========================");
		 */
		
		
		  //session-2 
		  
		  Session session1 = sessionFactory.openSession();//2. Session object connected with SessionFactory object
		  
		  Employee employee1 = new Employee(); 
		  employee1.setId(3344);
		  employee1.setName("Kiran"); 
		  employee1.setRole("Software Developer");
		  
		  Transaction transaction1 = session1.getTransaction();//1.2 Transaction object connected with Session object
		  transaction1.begin();
		  
		  session1.persist(employee1);//1.1 Employee object connected with Session object
		  
		  transaction1.commit();
		  
		  System.out.println("==============session-2===========================");
		
		  //session-3 
		  
		  Session session2 = sessionFactory.openSession();
		  
		  Employee employee2 = new Employee(); 
		  employee2.setId(1122);
		  employee2.setName("Harish"); 
		  employee2.setRole("Python Full Stack Developer");
		  
		  Transaction transaction2 = session2.getTransaction(); 
		  transaction2.begin();
		  
		  session2.persist(employee2);
		  
		  //session2.flush();
		  
		  transaction2.commit();
		  
		  
		  System.out.println("==============session-3===========================");
		 
		
	}

}
