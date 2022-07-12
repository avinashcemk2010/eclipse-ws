package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
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
