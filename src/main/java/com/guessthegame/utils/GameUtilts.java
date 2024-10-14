package com.guessthegame.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.guessthegame.Service.RandomWords;

@Component
public class GameUtilts {
	
	@Autowired
	ConfigurableApplicationContext context;
	
	private int MAX_LIMIT=5;
	
	public int reduceTry() {
		MAX_LIMIT-=1;
		return MAX_LIMIT;
	}
	
	public int getTriesRemaining() {
		return MAX_LIMIT;
	}
	public void resetTries() {
		MAX_LIMIT=5;
	}
	
	
	public RandomWords reload() {
		RandomWords randomWords=context.getBean(RandomWords.class);
		return randomWords;
	}

}
