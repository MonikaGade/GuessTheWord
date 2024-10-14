package com.guessthegame.Service;

import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class RandomWords {
	
	private String[] randomWords= {"father","mother","sister","hello",
			"bady","boy","girl"};
	
	private String randomlyChoosenWord=null;
	char[] allCharactersOfTheWord;
	
	public RandomWords() {
		randomlyChoosenWord = randomWords[random.nextInt(randomWords.length)];
		allCharactersOfTheWord=new char[randomlyChoosenWord.length()];
	}
	
	
	Random random=new Random();
	
	
	
	
	public String toString() {
		//return randomWords[random.nextInt(randomWords.length)];
		
		String ret="";
		for(char c:allCharactersOfTheWord) {
			if(c=='\u0000') {
				ret+="_ ";
			}
			else {
				ret=ret+c;
			}
		}
		return ret;
	}




	public boolean addGuess(char enteredGuessChar) {
		boolean isGuessedWord=false;
		for(int i=0;i<randomlyChoosenWord.length();i++) {
			System.out.println(randomlyChoosenWord.charAt(i)==enteredGuessChar);
			
				if(randomlyChoosenWord.charAt(i)==enteredGuessChar) {
				
					allCharactersOfTheWord[i]=enteredGuessChar;
					isGuessedWord=true;
				}
			
		}
		return isGuessedWord;
		
	} 

	

}
