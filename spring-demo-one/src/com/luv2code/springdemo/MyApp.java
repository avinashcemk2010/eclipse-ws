package com.luv2code.springdemo;

public class MyApp {
	
	
	public static void main(String[] args) {
		
		//We can use interface but again it is hardcoded
		Coach theCoach = new TrackCoach();
		
		System.out.println(theCoach.getDailyWorkout());
		
	}
	

}
