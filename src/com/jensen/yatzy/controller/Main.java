package com.jensen.yatzy.controller;

import com.jensen.yatzy.model.Dice;
import com.jensen.yatzy.model.Yatzy;
import com.jensen.yatzy.view.GameView;
import com.jensen.yatzy.view.Window;

public class Main {

    
    
    
	public static void main(String[] args) {
		Window window = new Window();
		Yatzy yatzy = new Yatzy();
		Controller controller = new Controller(window, yatzy);
		//test
		window.pack();
		window.setVisible(true);
	}

}
