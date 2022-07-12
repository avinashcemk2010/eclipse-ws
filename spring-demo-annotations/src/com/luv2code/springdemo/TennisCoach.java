package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	//constructor injection
	//with new spring release we don't need autowired for constructor injection
	/*@Autowired
	public TennisCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}*/
	

	@Override
	public String getDailyWorkout() {
		return "Practise backend volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println("inside init method");
	}
	
	@PreDestroy
	public void doMyCleanUp() {
		System.out.println("inside doMyCleanUp");
	}

}
