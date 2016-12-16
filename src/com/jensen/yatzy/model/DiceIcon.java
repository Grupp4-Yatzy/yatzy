package com.jensen.yatzy.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class DiceIcon {
	
	private static DiceIcon instance;
	private Icon[][] diceIcons;
	
	private DiceIcon(){
		diceIcons = new Icon[6][3];
		for(int i = 0; i<diceIcons.length; i++){
			diceIcons[i][0]= new ImageIcon(getClass().getResource("/images/normal/"+(i+1)+".png"));
			diceIcons[i][1]= new ImageIcon(getClass().getResource("/images/gray/"+(i+1)+".png"));
			diceIcons[i][2]= new ImageIcon(getClass().getResource("/images/blue/"+(i+1)+".png"));
		}
		
	}
	
	public static DiceIcon getInstance(){
		
		if(instance == null){
			instance = new DiceIcon();
		}
		return instance;
	}
	
	public Icon[] getDiceIcons(int diceValue){
		
		return diceIcons[diceValue-1];
	}

}
