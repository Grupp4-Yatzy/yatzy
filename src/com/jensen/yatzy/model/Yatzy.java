package com.jensen.yatzy.model;

public class Yatzy {
	

        private int numberOfRollsLeft = 3;

	
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
        
        public int getNumbersOfRollsLeft()
        {
            return this.numberOfRollsLeft;
        }
        
        public void decreaseRolls()
        {
            this.numberOfRollsLeft -= 1;
        }

}
