package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			int theid = 1;
			Instructor instructor = session.get(Instructor.class, theid);
			
			Course course1 = new Course("Air guitar");
			Course course2 = new Course("Polluted guitar");
			instructor.add(course1);
			instructor.add(course2);
			
			session.save(course1);
			session.save(course2);

			session.getTransaction().commit();
			System.out.println("Done..");
		} finally {
			session.close();
			factory.close();
		}
	}

}