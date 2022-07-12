package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach() {
	}
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getService();
	}
	
	private void doMyStartupStuff() {
		System.out.println("Inside trackcoach init method");
	}
	
	private void doMyCleanUpStuff() {
		System.out.println("Inside trackcoach destroy method");
	}

}
