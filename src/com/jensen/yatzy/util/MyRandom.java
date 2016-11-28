package com.jensen.yatzy.util;

import java.util.Random;

/**
 * 
 * @author benjamin
 *
 */
public final class MyRandom {
	
	private MyRandom() {
		
	}
	
	/**
	 * 
	 * @param max
	 * @return
	 * 
	 */
	public static int getInt(int max) {
		Random rGen = new Random();
		return rGen.nextInt(max + 1);
	}
	
	/**
	 * 
	 * @param lowerLimit
	 * @param upperLimit
	 * @return
	 */
	public static int getInt(int lowerLimit, int upperLimit) {
		return lowerLimit + getInt(upperLimit - lowerLimit);
	}
	
}
