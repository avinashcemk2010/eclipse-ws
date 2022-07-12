package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			System.out.println("creating new student object....");
			Student tempStudent = new Student("duffy", "harbour", "duffy.harbour@gmail.com");
			
			session.beginTransaction();
			System.out.println("saving the student");
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//if object is not found for that key then session.get will return null.
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println(myStudent);
			
			session.getTransaction().commit();
			
			
			System.out.println("Done..");
			
		} finally {
			session.close();
		}
	}

}
