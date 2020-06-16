package com.hibernate.business;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			
			////Delete by Session////
			//Begin Transaction
			session.beginTransaction();
						
			//Session.get to read an object
			Student student = session.get(Student.class, 2);
			
			//Delete
			session.delete(student);
			
			//Commit
			session.getTransaction().commit();
			
			/////Delete by Query////
			//Begin Transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
						
			//Session.get to read an object
			session.createQuery("delete from Student where id=3").executeUpdate();
			
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
