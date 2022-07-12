package com.luv2code.springdemo;

public class BaseBallCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BaseBallCoach() {
	}
	
	public BaseBallCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "spend 30 mins in batting practise";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getService();
	}

}
