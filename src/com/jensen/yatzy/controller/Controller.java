package com.jensen.yatzy.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jensen.yatzy.controller.Controller.DiceListener;
import com.jensen.yatzy.controller.Controller.PlayListener;
import com.jensen.yatzy.model.Dice;
import com.jensen.yatzy.model.Yatzy;
import com.jensen.yatzy.view.GameView;
import com.jensen.yatzy.view.Window;

public class Controller {
	
	public static final String[] combinations = {"Ettor", "Tvåor","Treor","Fyror","Femmor","Sexor",
												"Summa","Bonus","Ett par","Två par","Tretal","Fyrtal",
												"L.Stege","S.Stege","Kåk","Chans","Yatzy","Totalt"};

	private Window window;
	private GameView gamePanel;
	private Yatzy game;
	
	public Controller(Window w, Yatzy g) {
		this.window = w;
		this.game = g;
		gamePanel = new GameView();
		window.setCurrentPanel(gamePanel);
		gamePanel.addPlayListener(new PlayListener());
		gamePanel.addDiceListener(new DiceListener());
		
		// tester
		String[] names = {"Benjamin", "Robin", "Roberto", "Kami"};
		gamePanel.setPlayerNames(names);
		gamePanel.setCombinations(combinations);
		Integer[][] data = new Integer[combinations.length][names.length];
		gamePanel.setTable(data, names);

		/*
		Dice[] dices = new Dice[5];
		for (int i = 0; i < dices.length; i++) {
			Dice dice = new Dice();
			dice.roll();
			dices[i] = dice;
		}*/
		gamePanel.setDiceButtons(game.getDices());
	}
	


	public class PlayListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String ac = e.getActionCommand().toLowerCase();
			
			switch (ac) {
			case "roll":
				rollButton();
				break;
			case "done":
				doneButton();
				break;
			default:
				System.out.println("No Command for: " + ac);
				break;
			}
		}

	}

	public class DiceListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public void rollButton() {
		Dice[] dices = game.getDices();
		for (Dice dice: dices) {
			if (!dice.isLocked()) {
				dice.roll();
			}
		}
		gamePanel.setDiceButtons(dices);
	}

	public void doneButton() {
		// TODO Auto-generated method stub
		
	}
	
}
