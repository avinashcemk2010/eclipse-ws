package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	private String emailaddress;
	private String team;

	public CricketCoach() {
		System.out.println("Inside no-arg constructor");
	}

	//config file will use this to set fortunservice property
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside setter method of fortune service");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practise fast bowling for 15 mins";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getService();
	}
	
	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		System.out.println("Inside setter method of email address");
		this.emailaddress = emailaddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Inside setter method of team");
		this.team = team;
	}

}
