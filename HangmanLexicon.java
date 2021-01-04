/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import acm.util.*;

public class HangmanLexicon {
	
	public HangmanLexicon() {
		wordList = new ArrayList<String>();
		
		try {
			rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));			
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
		
    	
    	try {	
    		while (true) {
    			String word = rd.readLine();
    			if (word == null) break;
    			wordList.add(word);
    		}
    		rd.close();
    	} catch (IOException ex) {//if some other exception happens while reading file
    		throw new ErrorException(ex);
    	} 	
		
		
	}

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return wordList.size();
//		return 10;
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
//		switch (index) {
//			case 0: return "BUOY";
//			case 1: return "COMPUTER";
//			case 2: return "CONNOISSEUR";
//			case 3: return "DEHYDRATE";
//			case 4: return "FUZZY";
//			case 5: return "HUBBUB";
//			case 6: return "KEYHOLE";
//			case 7: return "QUAGMIRE";
//			case 8: return "SLITHER";
//			case 9: return "ZIRCON";
//			default: throw new ErrorException("getWord: Illegal index");
//		}
		if (index<wordList.size()) {
			String word = wordList.get(index); 
			return word;
		}else {
			throw new ErrorException("getWord: Illegal index");
		}
	}
//	
	private ArrayList<String> wordList;
	private BufferedReader rd;
}
