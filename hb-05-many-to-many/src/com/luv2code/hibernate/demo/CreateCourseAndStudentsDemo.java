package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			Course tempCourse = new Course("How to score one million points");
			session.save(tempCourse);
			
			Student student1 = new Student("luv", "kush", "luv@kush.com");
			Student student2 = new Student("ram", "balram", "ram@balram.com");
			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);
			
			session.save(student1);
			session.save(student2);

			session.getTransaction().commit();
			System.out.println("Done..");
		} finally {
			session.close();
			factory.close();
		}
	}

}
