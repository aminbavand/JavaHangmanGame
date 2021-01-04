/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		incorrectGuesses = 0;
		removeAll();
		addScaffold();

		
	}
	private void addScaffold() {
		int Cx = getWidth()/2;
		int Cy = getHeight()/2;
		int x1 = Cx-BEAM_LENGTH;
		int y1 = Cy+SCAFFOLD_HEIGHT-(ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
		int x2 = Cx-BEAM_LENGTH;
		int y2 = Cy-(ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
		GLine scaffold = new GLine(x1,y1,x2,y2);
		int x3 = Cx;
		int y3 = y2;
		int x4 = Cx;
		int y4 = y3+ROPE_LENGTH;
		GLine beam = new GLine(x2,y2,x3,y3);
		GLine rope = new GLine(x3,y3,x4,y4);
		add(scaffold);
		add(beam);
		add(rope);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		int Cx = getWidth()/2;
		int Cy = getHeight()/2;
		if (wordLabel!=null) remove(wordLabel);
		wordLabel = new GLabel(word);
		int x = Cx-BEAM_LENGTH-10;
		int y = Cy+SCAFFOLD_HEIGHT-(ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH)+40;
		wordLabel.setFont("Times New Roman-24");
		add(wordLabel,x,y);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		int Cx = getWidth()/2;
		int Cy = getHeight()/2;
		String letterString=String.valueOf(letter); 
		if (lastLabel!=null) {
			double w = lastLabel.getWidth();
			double x = lastLabel.getX();
			double newX = x +w+2;
			int y = Cy+SCAFFOLD_HEIGHT-(ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH)+60;
			GLabel label = new GLabel(letterString);
			add(label,newX,y);
			lastLabel = label;
			
		}else {
			int x = Cx-BEAM_LENGTH-10;
			int y = Cy+SCAFFOLD_HEIGHT-(ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH)+60;
			GLabel label = new GLabel(letterString);
			add(label,x,y);
			lastLabel = label;
		}
		
		
		
		incorrectGuesses+=1;
		   switch (incorrectGuesses) {
		      case 1:
		         addHead();
		         break;
		      case 2:
		         addBody();
		         break;
		      case 3:
		         addLeftArm();
		         break;
		      case 4:
		         addRightArm();
		         break;
		      case 5:
		         addLeftLeg();
		         break;
		      case 6:
		         addRightLeg();
		         break;
		      case 7:
		         addLeftFoot();
		         break;
		      case 8:
		         addRightFoot();
		         break;
		   }
	}
	private void addHead() {
		int Cx = getWidth()/2;
		int Cy = getHeight()/2;
		int x = Cx-HEAD_RADIUS;
		int y = Cy - BODY_LENGTH-2*HEAD_RADIUS;
		GOval head = new GOval(2*HEAD_RADIUS,2*HEAD_RADIUS);
		add(head,x,y);
	}
	private void addBody() {
		int Cx = getWidth()/2;
		int Cy = getHeight()/2;
		int x1 = Cx;
		int y1 = Cy;
		int x2 = Cx;
		int y2 = Cy-BODY_LENGTH;
		GLine body = new GLine(x1,y1,x2,y2);
		add(body);
	}
	private void addLeftArm() {
		int Cx = getWidth()/2;
		int Cy = getHeight()/2;
		int x1 = Cx;
		int y1 = Cy-BODY_LENGTH+ARM_OFFSET_FROM_HEAD;
		int x2 = Cx+UPPER_ARM_LENGTH;
		int y2 = y1;
		GLine upArm = new GLine(x1,y1,x2,y2);
		add(upArm);
		int x3 = x2;
		int y3 = y2+LOWER_ARM_LENGTH;
		GLine lowArm = new GLine(x2,y2,x3,y3);
		add(lowArm);
	}
	private void addRightArm() {
		int Cx = getWidth()/2;
		int Cy = getHeight()/2;
		int x1 = Cx;
		int y1 = Cy-BODY_LENGTH+ARM_OFFSET_FROM_HEAD;
		int x2 = Cx-UPPER_ARM_LENGTH;
		int y2 = y1;
		GLine upArm = new GLine(x1,y1,x2,y2);
		add(upArm);
		int x3 = x2;
		int y3 = y2+LOWER_ARM_LENGTH;
		GLine lowArm = new GLine(x2,y2,x3,y3);
		add(lowArm);
	}
	private void addLeftLeg() {
		int Cx = getWidth()/2;
		int Cy = getHeight()/2;
		int x1 = Cx;
		int y1 = Cy;
		int x2 = Cx+HIP_WIDTH/2;
		int y2 = Cy;
		GLine leftHip = new GLine(x1,y1,x2,y2);
		add(leftHip);
		int x3 = x2;
		int y3 = y2+LEG_LENGTH;
		GLine leftLeg = new GLine(x2,y2,x3,y3);
		add(leftLeg);
	}
	private void addRightLeg() {
		int Cx = getWidth()/2;
		int Cy = getHeight()/2;
		int x1 = Cx;
		int y1 = Cy;
		int x2 = Cx-HIP_WIDTH/2;
		int y2 = Cy;
		GLine rightHip = new GLine(x1,y1,x2,y2);
		add(rightHip);
		int x3 = x2;
		int y3 = y2+LEG_LENGTH;
		GLine righLeg = new GLine(x2,y2,x3,y3);
		add(righLeg);
	}
	private void addLeftFoot() {
		int Cx = getWidth()/2;
		int Cy = getHeight()/2;
		int x1 = Cx+HIP_WIDTH/2;
		int y1 = Cy+LEG_LENGTH;
		int x2 = x1+FOOT_LENGTH;
		int y2 = y1;
		GLine rightHip = new GLine(x1,y1,x2,y2);
		add(rightHip);
	}
	private void addRightFoot() {
		int Cx = getWidth()/2;
		int Cy = getHeight()/2;
		int x1 = Cx-HIP_WIDTH/2;
		int y1 = Cy+LEG_LENGTH;
		int x2 = x1-FOOT_LENGTH;
		int y2 = y1;
		GLine rightHip = new GLine(x1,y1,x2,y2);
		add(rightHip);
	}
	


/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

	//instance variables
	private int incorrectGuesses;
	private GLabel lastLabel;
	private GLabel wordLabel;
}
