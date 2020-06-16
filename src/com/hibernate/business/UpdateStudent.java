package com.hibernate.business;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			
			
			//Begin Transaction
			session.beginTransaction();
						
			//Session.get to read an object
			Student student = session.get(Student.class, 4);
			
			//Update by setter
			student.setEmail("update@email.com");
			
			//Commit
			session.getTransaction().commit();
			
			/////Update for all Students////
			//Begin Transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
						
			//Session.get to read an object
			session.createQuery("update Student set email='updateall@email.com'").executeUpdate();
			
			//Commit
			session.getTransaction().commit();
			
			
			
			

			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
