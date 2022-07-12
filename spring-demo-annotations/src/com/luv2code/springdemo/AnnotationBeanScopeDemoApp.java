package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach theCoach = context.getBean("baseballCoach", Coach.class);
		Coach alphaCoach = context.getBean("baseballCoach", Coach.class);
		
		System.out.println(theCoach == alphaCoach);
		
		context.close();

	}

}
