package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach theCoach = context.getBean("myTrackCoach", Coach.class);
		Coach alphaCoach = context.getBean("myTrackCoach", Coach.class);

		//if scope is singleton one instance will be returned 
		//else if we set it to prototype different objects will be returned
		boolean result = (theCoach == alphaCoach);
		System.out.println(result);
		
		context.close();
	}

}
