package com.jensen.yatzy.controller;

import com.jensen.yatzy.view.GameView;
import com.jensen.yatzy.view.Window;

public class Main {

	public static void main(String[] args) {
		Window window = new Window();
                window.setCurrentPanel(new GameView());
                window.setVisible(true);
	}

}
