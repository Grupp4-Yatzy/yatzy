package com.jensen.yatzy.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * This class contains three different images of the dices
 * 
 * @author Benjamin Rosman
 */
public class DiceIcon {
	
	private static DiceIcon instance;
	private final Icon[][] diceIcons;
	
        /**
         * The constructor initiates three different images of each value.
         */
	private DiceIcon(){
		diceIcons = new Icon[6][3];
		for(int i = 0; i<diceIcons.length; i++){
			diceIcons[i][0]= new ImageIcon(getClass().getResource("/images/normal/"+(i+1)+".png"));
			diceIcons[i][1]= new ImageIcon(getClass().getResource("/images/gray/"+(i+1)+".png"));
			diceIcons[i][2]= new ImageIcon(getClass().getResource("/images/blue/"+(i+1)+".png"));
		}
		
	}
	
        /**
         * Creates an object if instance is null
         * 
         * @return instance of DiceIcon
         */
	public static DiceIcon getInstance(){
		
		if(instance == null){
			instance = new DiceIcon();
		}
		return instance;
	}
	
        /**
         * 
         * @param diceValue
         * @return diceIcons
         */
	public Icon[] getDiceIcons(int diceValue){
		
		return diceIcons[diceValue-1];
	}

}
