package com.jensen.yatzy.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.jensen.yatzy.model.Constant;
import com.jensen.yatzy.model.Dice;
import com.jensen.yatzy.model.Yatzy;
import com.jensen.yatzy.view.DiceButton;
import com.jensen.yatzy.model.YatzyTableModel;
import com.jensen.yatzy.view.GameView;
import com.jensen.yatzy.view.Window;
import java.awt.Color;
import javax.swing.JButton;

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
			String ac = e.getActionCommand();
			//System.out.println(ac);
			Dice[] dices = game.getDices();

			String value = ac.substring(ac.length() - 1);
			Integer index = Integer.parseInt(value);

			dices[index].toggleLock();
			DiceButton button = (DiceButton) e.getSource();
			button.DiceToggleLock();
			gamePanel.setDiceButtons(dices);
		}
	}
	private Window window;
	private GameView gamePanel;
	private Yatzy game;

	/**
	 *
	 * @param window
	 * @param game
	 */
	public Controller(Window window, Yatzy game) {
		this.window = window;
		this.game = game;

		// Creates defualt start-up panel
		gamePanel = new GameView();
		this.window.setCurrentPanel(gamePanel);
		gamePanel.addPlayListener(new PlayListener());
		gamePanel.addDiceListener(new DiceListener());
		gamePanel.setDiceButtons(this.game.getDices());

		// tests
		String[] names = {"Benjamin", "Robin", "Roberto", "Kami"};
		gamePanel.setPlayerNames(names);
		gamePanel.setCombinations(Constant.COMBINATIONS);
        Integer[][] data = {{1,2,3},{4,5,6},{7,8,9}};
        YatzyTableModel model = new YatzyTableModel();
        gamePanel.initTable(model);
        for(int row=0; row<model.getRowCount(); row++){
            for(int col=0; col<model.getColumnCount(); col++){
                model.setValueAt(data[row][col], row, col);
                model.fireTableCellUpdated(row, col);
            }
        }
        
        gamePanel.setEnableDice(false);
    }

	/**
	 * Rolls all unlocked dices TODO unlock all dices
	 */
	void rollButton() {
		gamePanel.setEnableDice(true);
		Dice[] dices = game.getDices();
		for (Dice dice : dices) {

			if (!dice.isLocked()) {
				dice.roll();
			}
		}
		gamePanel.setDiceButtons(dices);
		game.getNumbersOfRollsLeft();
		
		game.decreaseRolls();
		if(game.getNumbersOfRollsLeft()==0){

			gamePanel.getRollButton().setEnabled(false);
		}
		gamePanel.getRollButton().setText("Roll ("+game.getNumbersOfRollsLeft()+")");

		System.out.println("ettor: "+ game.sum(1));
		System.out.println("tvåor: "+ game.sum(2));
		System.out.println("treor: "+ game.sum(3));
		System.out.println("fyror: "+ game.sum(4));
		System.out.println("femmor: "+ game.sum(5));
		System.out.println("sexor: "+ game.sum(6));
		System.out.println("---------------------");
		System.out.println("par: "+ game.onePair());
		System.out.println("tvåpar: "+ game.twoPair());
		System.out.println("tretal: "+ game.numberOfAKind(3));
		System.out.println("fyrtal: "+ game.numberOfAKind(4));
		System.out.println("Liten stege: "+ game.straight(6));
		System.out.println("Stor stege: "+ game.straight(1));
		System.out.println("Kåk: "+game.fullHouse());
		System.out.println("Chans: "+game.sum());
		System.out.println("Yatzy: "+ game.yatzy());
		System.out.println("---------------------");
	}
	/**
	 *
	 */
	void doneButton() {

		// TODO Implement doneButton()

		Dice[] dices = game.getDices();
		for (Dice dice : dices) {

			if (!dice.isLocked()||dice.isLocked()) {

				dice.setLock(false);
			}
		}
		DiceButton[]button=gamePanel.getDiceButtons();
		
		for(DiceButton but :button){
			but.setOpaque(false);

		}
		gamePanel.setEnableDice(false);
		game.nextPlayer();
		gamePanel.getRollButton().setEnabled(true);
		gamePanel.getRollButton().setText("Roll ("+game.getNumbersOfRollsLeft()+")");
	}
}
