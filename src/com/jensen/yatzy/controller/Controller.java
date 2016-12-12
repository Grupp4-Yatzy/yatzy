package com.jensen.yatzy.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.jensen.yatzy.model.Constant;
import com.jensen.yatzy.model.Dice;
import com.jensen.yatzy.model.Player;
import com.jensen.yatzy.model.Yatzy;
import com.jensen.yatzy.view.DiceButton;
import com.jensen.yatzy.model.YatzyTableModel;
import com.jensen.yatzy.util.MyRandom;
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
                    window.pack();
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
            String ac = e.getActionCommand();
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
    private YatzyTableModel tableModel;

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
        String[] names = {"playerOne", "playerTwo"};
        game.addPlayers(names);
        gamePanel.setPlayerNames(names);
        gamePanel.setCombinations(Constant.COMBINATIONS);

        //Integer[][] data = new Integer[Constant.COMBINATIONS.length][names.length];
        Integer[][] data = game.createTable();
        tableModel = new YatzyTableModel();
        tableModel.initTable(data.length, data[0].length);
        gamePanel.initTable(tableModel);
        /*
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            for (int col = 0; col < tableModel.getColumnCount(); col++) {
                tableModel.setValueAt(MyRandom.getInt(50), row, col);
                tableModel.fireTableCellUpdated(row, col);
            }
        }
        */

        gamePanel.setEnableDice(false);
    }

    /**
     * Rolls all unlocked dices TODO unlock all dices
     */
    private void rollButton() {
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
        if (game.getNumbersOfRollsLeft() == 0) {

            gamePanel.getRollButton().setEnabled(false);
        }
        gamePanel.getRollButton().setText("Roll (" + game.getNumbersOfRollsLeft() + ")");

        System.out.println("ettor: " + game.sumNumber(1));
        System.out.println("tvåor: " + game.sumNumber(2));
        System.out.println("treor: " + game.sumNumber(3));
        System.out.println("fyror: " + game.sumNumber(4));
        System.out.println("femmor: " + game.sumNumber(5));
        System.out.println("sexor: " + game.sumNumber(6));
        System.out.println("---------------------");
        System.out.println("par: " + game.onePair());
        System.out.println("tvåpar: " + game.twoPair());
        System.out.println("tretal: " + game.numberOfAKind(3));
        System.out.println("fyrtal: " + game.numberOfAKind(4));
        System.out.println("Liten stege: " + game.straight(6));
        System.out.println("Stor stege: " + game.straight(1));
        System.out.println("Kåk: " + game.fullHouse());
        System.out.println("Chans: " + game.sum());
        System.out.println("Yatzy: " + game.yatzy());
        System.out.println("---------------------");
    }

    /**
     *
     */
    private void doneButton() {
    	// TODO implement save and update functionality
    	// get current player
    	Player player = game.getCurrentPlayer();
    	int col = game.getPlayerIndex(player);
    	// get first empty index
    	int index = player.getFirstEmptyScoreIndex();
    	Integer[] playerScore = player.getScoreList();
    	// TODO if done add total and update table
    	if (index < playerScore.length - 1) {
    		// get score for index
    		int score = getScore(index);
    		// add score to player & update table
    		player.addScore(score, index);
    		tableModel.setValueAt(score, index, col);
    		tableModel.fireTableCellUpdated(index, col);

    		if (index + 1 == Constant.INDEX_OF_SUM) {
    			int sumIndex = Constant.INDEX_OF_SUM;
    			int bonusIndex = Constant.INDEX_OF_BONUS;
    			player.addSum();
    			tableModel.setValueAt(playerScore[sumIndex], sumIndex, col);
    			tableModel.fireTableCellUpdated(sumIndex, col);
    			player.addBonus();
    			tableModel.setValueAt(playerScore[bonusIndex], bonusIndex, col);
    			tableModel.fireTableCellUpdated(bonusIndex, col);
			}
    		
    		final int totalIndex = playerScore.length - 1;
    		if (index + 1 == totalIndex) {
    			player.addTotal();
	        	tableModel.setValueAt(playerScore[totalIndex], totalIndex, col);
		        tableModel.fireTableCellUpdated(totalIndex, col);
			} 
		}

        Dice[] dices = game.getDices();
        for (Dice dice : dices) {
            dice.setLock(false);
        }
        
        DiceButton[] button = gamePanel.getDiceButtons();

        for (DiceButton but : button) {
            //but.setOpaque(false);
            //but.setSelected(false);
        }
        
        gamePanel.setEnableDice(false);
        game.nextPlayer();
        gamePanel.getRollButton().setEnabled(true);
        gamePanel.getRollButton().setText("Roll (" + game.getNumbersOfRollsLeft() + ")");
    }

    private int getScore(int index) {
    	int score = 0;
    	switch (index) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			// ones to sixes
			score = game.sumNumber(index + 1);
			break;
		case 8:
			score = game.onePair();
			break;
		case 9:
			score = game.twoPair();
			break;
		case 10:
			// three of a kind
			score = game.numberOfAKind(3);
			break;
		case 11:
			// four of a kind
			score = game.numberOfAKind(4);
			break;
		case 12:
			// small straight
			score = game.straight(6);
			break;
		case 13:
			// big straight
			score = game.straight(1);
			break;
		case 14:
			score = game.fullHouse();
			break;
		case 15:
			// chance
			score = game.sum();
			break;
		case 16:
			// Yatzy
			score = game.numberOfAKind(5);
			break;
		default:
			System.out.println("Missing case for given index: " + index);
			break;
		}
    	return score;
	}
    
}
