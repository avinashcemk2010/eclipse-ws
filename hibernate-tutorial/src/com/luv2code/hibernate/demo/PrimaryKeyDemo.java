package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			System.out.println("creating new student object....");
			Student tempStudent1 = new Student("tom", "hardy", "tom.hardy@gmail.com");
			Student tempStudent2 = new Student("mary", "jane", "mary.jane@gmail.com");
			Student tempStudent3 = new Student("love", "jana", "love.jana@gmail.com");
			Student tempStudent4 = new Student("minti", "powell", "minti.powell@gmail.com");
			session.beginTransaction();
			System.out.println("saving the student");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.save(tempStudent4);
			session.getTransaction().commit();
			System.out.println("Done..");
		} finally {
			session.close();
		}
	}

}
