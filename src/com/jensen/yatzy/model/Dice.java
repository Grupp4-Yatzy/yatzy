package com.jensen.yatzy.model;

import com.jensen.yatzy.util.MyRandom;

/**
 * 
 * @author benjamin
 *
 */
public class Dice {
	
	private int value;
	
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

}
