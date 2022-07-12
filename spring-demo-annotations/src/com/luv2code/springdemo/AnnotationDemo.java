package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemo {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TennisCoach coach = context.getBean("thatSillyCoach", TennisCoach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		//Default bean id
		BaseballCoach bcoach = context.getBean("baseballCoach", BaseballCoach.class);
		System.out.println(bcoach.getDailyWorkout());
		System.out.println(bcoach.getDailyFortune());
		
		context.close();
	}

}
