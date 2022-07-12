package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class BaseballCoach implements Coach {

	private FortuneService fortuneService;

	public BaseballCoach() {}

	@Override
	public String getDailyWorkout() {
		return "Practise baseball throw";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	//setter method injection
	/*@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/

	//setter method injection on custom method name
	@Autowired
	@Qualifier("happyFortuneService")
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println("Inside doSomeCrazyStuff");
		this.fortuneService = fortuneService;
	}

}
