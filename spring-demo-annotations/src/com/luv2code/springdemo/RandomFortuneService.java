package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private Random myRandom = new Random();
	
	private String[] data = {
			"Beware of the wolf",
			"I am running fast",
			"I will win"
	};

	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		return data[index];
	}

}
