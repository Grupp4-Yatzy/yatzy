package com.jensen.yatzy.model;

public class Yatzy {
	
	public static final int DEFUALT_NUMBER_OF_DICES = 5;
	
	private Dice[] dices;
	
	
	public Yatzy() {
		dices = new Dice[DEFUALT_NUMBER_OF_DICES];
		for (int i = 0; i < dices.length; i++) {
			dices[i] = new Dice();
		}
	}

	
	public Dice[] getDices() {
		return dices;
	}

}
