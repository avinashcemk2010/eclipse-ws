package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;
			
			session.beginTransaction();
			
			//if object is not found for that key then session.get will return null.
			Student myStudent = session.get(Student.class, studentId);
			System.out.println(myStudent);
			myStudent.setFirstName("Scooby");
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			
			System.out.println("Done..");
			
		} finally {
			session.close();
		}
	}

}
