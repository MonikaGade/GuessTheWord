package com.guessthegame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.guessthegame.Service.RandomWords;
import com.guessthegame.utils.GameUtilts;

@Controller
public class GameController {
	
	@Autowired
	private RandomWords word;
	
	@Autowired
	private GameUtilts gameUlits;
	
	
	@GetMapping("game-home")
	public String getGameHomePage(@RequestParam(value="guessChar",required = false) String guessChar,Model model) {
		String randomWord = word.toString();
	
		
		if(guessChar!=null) {
			boolean guess = word.addGuess(guessChar.charAt(0));
			randomWord = word.toString();
			if(guess==false) {
				int reduceTry = gameUlits.reduceTry();
				
				System.err.println(gameUlits.getTriesRemaining());
				
			}
		}
		model.addAttribute("wordtodisplay",randomWord);
		model.addAttribute("triesRemaining",gameUlits.getTriesRemaining());		
		
		
		return "game-home-page";
	}
	
	
	@GetMapping("game-reload")
	public String gameReload() {
		word=gameUlits.reload();
		gameUlits.resetTries();
		return "redirect:/game-home";
	}

}
