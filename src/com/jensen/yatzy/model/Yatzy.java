package com.jensen.yatzy.model;

public class Yatzy {
	
	private Dice[] dices = new Dice[5];
	
	public Yatzy() {
		for (int i = 0; i < dices.length; i++) {
			dices[i] = new Dice();
		}
	}

	public Dice[] getDices() {
		return dices;
	}

}
