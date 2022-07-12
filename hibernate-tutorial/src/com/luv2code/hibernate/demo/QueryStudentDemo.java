package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			//Student passed in query is being mapped to class name
			List<Student> theStudents = session.createQuery("from Student").list();
			
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='jana'").list();
			
			displayStudents(theStudents);
			
			theStudents = 
					session
					.createQuery(
							"from Student s where s.lastName='jana' OR s.firstName='tom'")
					.list();
			
			displayStudents(theStudents);
			
			session.getTransaction().commit();
			System.out.println("Done..");
		} finally {
			session.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

}
