package com.jensen.yatzy.model;

import com.jensen.yatzy.util.MyRandom;

/**
 * Dice class is created to give the dices values and set the dices
 * different states.
 * @author benjamin
 * 
 */
public class Dice {
 	private static final int DEFUALT_DICE_VALUE=6;
	private int value;
	private boolean isLocked;
        
        /**
         * The constructor initializes the variabels value and isLocked
         * Sets the dice to unlocked and sets the dice value to 6
         */
	public Dice() {
		value = DEFUALT_DICE_VALUE;
                isLocked = false;
	}
        
        /**
	 * Gets the value of the upward facing side
	 * @return value of the dice
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Set value to a random number 1-6
	 */
	public void roll() {
		value = MyRandom.getInt(1, 6);
	}

	/**
	 * Enables a roll if the dices are unlocked
	 * @return whether this dice is locked or not
	 */
	public boolean isLocked() {
		return isLocked;
	}
        
	/**
         * Enables the user to lock and unlock dices
         *  
         */
        public void toggleLock(){
		if(isLocked) {
			isLocked = false;
		}
                else {
			isLocked = true;
		}
	} 
        
        /**
         * Decides if dices are locked or not
         * @param b 
         */
	public void setLock(boolean b) {
		isLocked = b;
	}
}
