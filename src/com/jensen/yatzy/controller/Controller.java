package com.jensen.yatzy.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jensen.yatzy.controller.Controller.DiceListener;
import com.jensen.yatzy.controller.Controller.PlayListener;
import com.jensen.yatzy.model.Dice;
import com.jensen.yatzy.model.Yatzy;
import com.jensen.yatzy.view.GameView;
import com.jensen.yatzy.view.Window;

/**
 * 
 * @author benjamin
 *
 */
public class Controller {
	
	/**
	 * 
	 * @author benjamin
	 *
	 */
	class PlayListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String ac = e.getActionCommand().toLowerCase();
			
			switch (ac) {
			case "roll":
				rollButton();
				// TODO disable roll button if numberOfRolls left is equal to 0
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

	/**
	 * 
	 * @author benjamin
	 *
	 */
	class DiceListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO figure out which button was clicked
			// toggle lock of said dice & set button to selected

		}

	}
	
	public static final String[] combinations = {"Ettor", "Tvåor","Treor","Fyror","Femmor","Sexor",
												"Summa","Bonus","Ett par","Två par","Tretal","Fyrtal",
												"L.Stege","S.Stege","Kåk","Chans","Yatzy","Totalt"};

	private Window window;
	private GameView gamePanel;
	private Yatzy game;
	
	public Controller(Window w, Yatzy g) {
		this.window = w;
		this.game = g;
		
		// Creates defualt start-up panel
		gamePanel = new GameView();
		window.setCurrentPanel(gamePanel);
		gamePanel.addPlayListener(new PlayListener());
		gamePanel.addDiceListener(new DiceListener());
		gamePanel.setDiceButtons(game.getDices());
		
		// tests
		String[] names = {"Benjamin", "Robin", "Roberto", "Kami"};
		gamePanel.setPlayerNames(names);
		gamePanel.setCombinations(combinations);
		Integer[][] data = new Integer[combinations.length][names.length];
		gamePanel.setTable(data, names);
	}

	/**
	 * Rolls all unlocked dices
	 * TODO unlock all dices
	 */
	void rollButton() {
		Dice[] dices = game.getDices();
		for (Dice dice: dices) {
			if (!dice.isLocked()) {
				dice.roll();
			}
		}
		gamePanel.setDiceButtons(dices);
	}

	/**
	 * 
	 */
	void doneButton() {
		// TODO Implement doneButton()
		
	}
	
}
