package com.jensen.yatzy.model;

import com.jensen.yatzy.util.MyRandom;


/**
 * 
 * @author benjamin
 *
 */
public class Dice {

	

	private int value;
	private boolean isLocked;

	public Dice() {
		value = Constant.DEFUALT_DICE_VALUE;
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
	 * 
	 * @return whether this dice is locked or not
	 */
	public boolean isLocked() {
		return isLocked;
	}

	public void toggleLock(){

		if(isLocked)
		{
			isLocked = false;
		}
		else
		{
			isLocked = true;
		}
	}

	public void setLock(boolean b) {
		isLocked = b;
	}

}
