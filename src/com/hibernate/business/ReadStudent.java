package com.hibernate.business;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class ReadStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			//Create a Student 
			System.out.println("Creating a new Student");
			Student student1 = new Student("Jessica", "jones", "jsjones@marvel.com");
			//Start transaction 
			session.beginTransaction();
			//Save the object
			session.save(student1);
			//Commit
			session.getTransaction().commit();
			
			/////////Read//////////
			//Read the student
			//Recreate a new session 
			Session session2 = factory.getCurrentSession();
			
			//Begin Transaction
			session2.beginTransaction();
			
			System.out.println("The Object for the id: "+student1.getId());
			
			//Session.get to read an object
			Student student = session2.get(Student.class, student1.getId());
			
			System.out.println("The object is: "+ student);
			

			//Commit
			session2.getTransaction().commit();
			
			

			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
