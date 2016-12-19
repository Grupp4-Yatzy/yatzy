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
	 * Generates an int from 0-max.
	 * @param max, is inclusive
	 * @return random int + 1
	 */
	public static int getInt(int max) {
		Random rGen = new Random();
		return rGen.nextInt(max + 1);
	}
	
	/**
	 * Generates an int from lowerLimit to upperLimit
	 * @param lowerLimit, is inclusive
	 * @param upperLimit, is inclusive
	 * @return lowerLimit + getInt(upperLimit - lowerLimit)
	 */
	public static int getInt(int lowerLimit, int upperLimit) {
		return lowerLimit + getInt(upperLimit - lowerLimit);
	}
	
}
