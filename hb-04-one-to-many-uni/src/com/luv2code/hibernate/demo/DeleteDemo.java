package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			
			int id = 1;
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, id);
			if(instructor != null) {
				//will also delete instructor detail as cascade is set to all
				session.delete(instructor);
			}
			
			
			session.getTransaction().commit();
			System.out.println("Done..");
		} finally {
			session.close();
		}
	}

}
