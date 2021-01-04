/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

    public void run() {
    	canvas.reset();  
    	setup();
    	println(canvas.getHeight());
    	play();    	
	}
    
    
    
    private void setup() {
    	setFont("Times New Roman-20");
    	int num = rgen.nextInt(h.getWordCount());
    	word = h.getWord(num);
    	int wordLen = word.length();
    	blanks = wordLen;
    	guessLeft = 8;
    	createDashes(wordLen);
        println("Welcome to Hangman!");
    }
    
    private void play() {
    	while (!gameOver()) {
    		println("The word now looks like this: " + GuessedWord + 
        			"\nYou have " + guessLeft + " guesses left.");
    		canvas.displayWord(GuessedWord);
    		boolean incorrectFormat = true;
    		while (incorrectFormat) {
            	String str = readLine("Your guess: ");
            	char ch = str.charAt(0);
            	if ( (ch>='A' && ch<='Z')||(ch>='a' && ch<='z') ) {      
            		if (GuessedWord.indexOf(Character.toUpperCase(ch))==-1){
	        			incorrectFormat = false;         
	        			ch = Character.toUpperCase(ch);
	        			PlaceLetter(ch);//put the letter in its place if correct       
            		}
            	}
            	else {
            		println("This guess is illegal.");
            	}            	
    		}        	        	
    	}
    	canvas.displayWord(GuessedWord);
    	if (guessLeft==0) {
    		println("You're completely hung.\n The word was: " + word + "\nYou lose.");
    	}
    	if (blanks==0) {
    		println("You guessed the word: " + word + "\nYou win.");
    	}
    }
    
    private void PlaceLetter(char ch) {
    	int isWrong = 1;
    	for (int ind=0; ind<=word.length()-1; ind++) {
    		if (word.charAt(ind)==ch) {    			
    			if  (GuessedWord.charAt(ind)=='-') {
        			blanks-=1;
    			}
    			replaceLetter(ch,ind);
    			isWrong = 0;
    		}
    	}
    	if (isWrong==1) {
    		guessLeft-=1;
    		println("There are no "+ch+"'s in the word");
    		canvas.noteIncorrectGuess(ch);
    	}
    	else {
    		println("That guess is correct");    		
    	}
    }
    private void replaceLetter(char ch,int ind) {
    	String newWord = "";
    	for (int i=0; i<=GuessedWord.length()-1; i++) {
    		if (i!=ind) {
    			newWord = newWord + GuessedWord.charAt(i);
    		}
    		else {
    			newWord = newWord + ch;
    		}    		
    	}
    	GuessedWord = newWord;
    }
    
    private void createDashes(int wordLen) {
    	GuessedWord = "";
    	for (int i=1; i<=wordLen; i++) {
    		GuessedWord = GuessedWord+"-";
    	}    	
    }
    
    
    
    private boolean gameOver() {
    	return( guessLeft==0 || blanks==0);    	
    }
    
    
    public void init() {    	
    	canvas = new HangmanCanvas();
    	add(canvas);
    }
    
    
//    instance variables
    private int blanks;
    private int guessLeft;
    private String word;
    private String GuessedWord;
    private HangmanLexicon h = new HangmanLexicon();
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private HangmanCanvas canvas;

}
