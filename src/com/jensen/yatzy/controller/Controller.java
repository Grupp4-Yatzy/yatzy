package com.jensen.yatzy.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.jensen.yatzy.model.Constant;
import com.jensen.yatzy.model.Dice;
import com.jensen.yatzy.model.Player;
import com.jensen.yatzy.model.Yatzy;
import com.jensen.yatzy.view.DiceButton;
import com.jensen.yatzy.model.YatzyTableModel;
import com.jensen.yatzy.view.GameView;
import com.jensen.yatzy.view.NewGamePanel;
import com.jensen.yatzy.view.Window;
import javax.swing.JTextField;

/**
 * Controls how actions are performed throughout a game of Yatzy
 *
 * @author benjamin
 *
 */
public class Controller {

    private class PlayListener implements ActionListener {

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
                case "new game":
                    newGame();
                    break;
                default:
                    System.out.println("No Command for: " + ac);
                    break;
            }
            window.pack();
        }
    }

    private class DiceListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String ac = e.getActionCommand();
            Dice[] dices = game.getDices();

            String value = ac.substring(ac.length() - 1);
            Integer index = Integer.parseInt(value);

            dices[index].toggleLock();
            DiceButton button = (DiceButton) e.getSource();
            button.DiceToggleLock();
        }
    }

    private class MenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == newGamePanel.getOkButton()) {
                initGame();
            } else if (e.getSource() == newGamePanel.getNumberOfPlayers()) {
                createPlayerFields();

            }
        }

    }

    private Window window;
    private GameView gamePanel;
    private Yatzy game;
    private YatzyTableModel tableModel;
    private NewGamePanel newGamePanel;

    /**
     * Creates a controller and initiates the default view and sets the window
     * to display it.
     *
     * @param window
     *
     */
    public Controller(Window window) {
        this.window = window;
        newGame();
    }

    public void createPlayerFields() {
        JTextField textField = newGamePanel.getNumberOfPlayers();
        String text = textField.getText();
        int numberOfPlayers = 1;
        try {
            numberOfPlayers = Integer.parseInt(text);
            if (numberOfPlayers >= 1 && numberOfPlayers <= 6) {
                newGamePanel.setPlayerFields(numberOfPlayers);
                newGamePanel.getOkButton().setEnabled(true);
            } else {
                window.displayErrorMessage("Number of players must be [1-6].");
            }
        } catch (NumberFormatException ex) {
            window.displayErrorMessage("You need to enter an integer.");
        }
        window.pack();
    }

    public void newGame() {
        newGamePanel = new NewGamePanel();
        newGamePanel.AddListener(new MenuListener());
        window.setCurrentPanel(newGamePanel);
        newGamePanel.getOkButton().setEnabled(false);
    }

    public void initGame() {
        gamePanel = new GameView();
        this.game = new Yatzy();
        gamePanel.addPlayListener(new PlayListener());
        gamePanel.addDiceListener(new DiceListener());
        gamePanel.setDiceButtons(this.game.getDices());

        String[] names = newGamePanel.getPlayerNames();
        game.addPlayers(names);
        gamePanel.setPlayerNames(names);
        gamePanel.setCombinations(Constant.COMBINATIONS);

        Integer[][] data = game.createTable();
        tableModel = new YatzyTableModel();
        tableModel.initTable(data.length, data[0].length);
        gamePanel.initTable(tableModel);

        gamePanel.setEnableDice(false);
        gamePanel.getDoneButton().setEnabled(false);
        gamePanel.getNewGameButton();
        this.window.setCurrentPanel(gamePanel);
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
        gamePanel.getDoneButton().setEnabled(true);

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

            if (index + 1 == Constant.INDEX_OF_SUM) {
                int sumIndex = Constant.INDEX_OF_SUM;
                int bonusIndex = Constant.INDEX_OF_BONUS;
                player.addSum();
                tableModel.setValueAt(playerScore[sumIndex], sumIndex, col);
                player.addBonus();
                tableModel.setValueAt(playerScore[bonusIndex], bonusIndex, col);
            }

            final int totalIndex = playerScore.length - 1;
            if (index + 1 == totalIndex) {
                player.addTotal();
                tableModel.setValueAt(playerScore[totalIndex], totalIndex, col);
            }
        }

        Dice[] dices = game.getDices();
        for (Dice dice : dices) {
            dice.setLock(false);
        }

        DiceButton[] button = gamePanel.getDiceButtons();

        for (DiceButton but : button) {
            but.setOpaque(false);
            //but.setSelected(false);
        }

        gamePanel.setEnableDice(false);
        game.nextPlayer();
        gamePanel.getRollButton().setEnabled(true);
        gamePanel.getRollButton().setText("Roll (" + game.getNumbersOfRollsLeft() + ")");
        gamePanel.getDoneButton().setEnabled(false);
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
