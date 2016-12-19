package com.jensen.yatzy.util;

import java.util.Random;

/**
 * Utility class that generate random values from 1-6.
 * @author benjamin
 *
 */
public final class MyRandom {

	private MyRandom() {

	}

	/**
	 * 
	 * @param max
	 * @return random int + 1
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
