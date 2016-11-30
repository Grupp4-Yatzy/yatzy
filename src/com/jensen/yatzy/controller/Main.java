package com.jensen.yatzy.controller;

import com.jensen.yatzy.view.GameView;
import com.jensen.yatzy.view.Window;

public class Main {

	public static void main(String[] args) {
		Window window = new Window();
                GameView game = new GameView();
                window.setCurrentPanel(game);
                window.setVisible(true);
                System.out.println(game.getHeight());
	}

}
