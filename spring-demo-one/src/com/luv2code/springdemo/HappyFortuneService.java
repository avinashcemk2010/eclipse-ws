package com.luv2code.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getService() {
		return "Today is your lucky day";
	}

}
