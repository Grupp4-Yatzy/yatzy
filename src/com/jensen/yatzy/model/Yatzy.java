package com.jensen.yatzy.model;

public class Yatzy {
	
	
	private Dice[] dices;
	
	
	public Yatzy() {
		dices = new Dice[Constant.DEFUALT_NUMBER_OF_DICES];
		for (int i = 0; i < dices.length; i++) {
			dices[i] = new Dice();
		}
	}

	
	public Dice[] getDices() {
		return dices;
	}

}
