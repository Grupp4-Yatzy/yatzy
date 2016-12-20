package com.jensen.yatzy.controller;

import com.jensen.yatzy.exception.InvalidSelectionException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.jensen.yatzy.model.Constant;
import com.jensen.yatzy.model.Dice;
import com.jensen.yatzy.model.DiceIcon;
import com.jensen.yatzy.model.Player;
import com.jensen.yatzy.model.Yatzy;
import com.jensen.yatzy.model.YatzyMode;
import com.jensen.yatzy.view.DiceButton;
import com.jensen.yatzy.model.YatzyTableModel;
import com.jensen.yatzy.view.GameView;
import com.jensen.yatzy.view.MenuView;
import com.jensen.yatzy.view.NewGamePanel;
import com.jensen.yatzy.view.Window;

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
            //String ac = e.getActionCommand();
            Dice[] dices = game.getDices();

            //String value = ac.substring(ac.length() - 1);
            //Integer index = Integer.parseInt(value);
            DiceButton[] buttons = gamePanel.getDiceButtons();
            DiceButton button;
            for (int index = 0; index < buttons.length; index++) {
                button = buttons[index];
                if (button.equals(e.getSource())) {
                    dices[index].toggleLock();
                    button.DiceToggleLock();
                }
            }
        }
    }

    private class MenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand().toLowerCase()) {
                case "forced":
                    mode = YatzyMode.FORCED_YATZY;
                    break;
                case "normal":
                    mode = YatzyMode.NORMAL_YATZY;
                    break;
                case "wild":
                    mode = YatzyMode.WILD_YATZY;
                    break;
                default:
                    break;
            }

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
    private YatzyMode mode;
    private int selectedCol;
    private int selectedRow;

    /**
     * Creates a controller and initiates the default view and sets the window
     * to display it.
     *
     * @param window The window in wich the game will be displayed.
     *
     */
    public Controller(Window window) {
        this.window = window;
        //newGame();
        window.setCurrentPanel(new MenuView());
    }

    /**
     * This method creates player fields in the first window. User choose how
     * many participants will play in the game. If the user choose 1< or 6>
     * players or enter an integer an error message will be shown.
     */
    private void createPlayerFields() {
        String text = newGamePanel.getNumberOfPlayers().getText();
        int numberOfPlayers;

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

    /**
     * This method sets a new first window where the user choose yatzy mode and
     * how many participants it will be in the game. The okButton is disabled
     * until the user has entered the number of participants.
     */
    private void newGame() {
        newGamePanel = new NewGamePanel();
        newGamePanel.setYatzyModeOptions(YatzyMode.values());
        mode = YatzyMode.NORMAL_YATZY;
        newGamePanel.AddMenuListener(new MenuListener());
        window.setCurrentPanel(newGamePanel);
        newGamePanel.getOkButton().setEnabled(false);
    }

    private void initGame() {
        gamePanel = new GameView();
        this.game = new Yatzy();
        gamePanel.addPlayListener(new PlayListener());
        gamePanel.addDiceListener(new DiceListener());
        gamePanel.setDiceButtons(game.getDices(), DiceIcon.getInstance());

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
        gamePanel.playerIndicator(game.getPlayerIndex(game.getCurrentPlayer()));
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
        gamePanel.setDiceButtons(dices, DiceIcon.getInstance());
        game.getNumbersOfRollsLeft();

        game.decreaseRolls();
        if (game.getNumbersOfRollsLeft() == 0) {

            gamePanel.getRollButton().setEnabled(false);
        }
        gamePanel.getRollButton().setText("Roll (" + game.getNumbersOfRollsLeft() + ")");
        gamePanel.getDoneButton().setEnabled(true);

        System.out.println(game);
    }

    private void doneButton() {
        // TODO implement save and update functionality
        // get current player
        Player player = game.getCurrentPlayer();
        //int col = game.getPlayerIndex(player);
        selectedCol = gamePanel.getTable().getSelectedColumn();
        selectedRow = gamePanel.getTable().getSelectedRow();
        try {
            modeController(player);
            saveScore(selectedRow, selectedCol, player);
            if (player.getFirstEmptyScoreIndex() == Constant.INDEX_OF_SUM) {
                calculateSumBonus(player);
            }
            if (player.getFirstEmptyScoreIndex() == Constant.INDEX_OF_TOTAL) {
                calculateTotal(player);
            }

            Dice[] dices = game.getDices();
            DiceButton[] buttons = gamePanel.getDiceButtons();
            for (int i = 0; i < dices.length; i++) {
                dices[i].setLock(false);
                buttons[i].setSelected(false);
                buttons[i].setEnabled(false);
            }

            //gamePanel.setEnableDice(false);
            game.nextPlayer();
            gamePanel.playerIndicator(game.getPlayerIndex(game.getCurrentPlayer()));
            gamePanel.getRollButton().setEnabled(true);
            gamePanel.getRollButton().setText("Roll (" + game.getNumbersOfRollsLeft() + ")");
            gamePanel.getDoneButton().setEnabled(false);
            gamePanel.getTable().clearSelection();
        } catch (InvalidSelectionException e) {
            window.displayErrorMessage(e.getMessage());
        }

    }

    private void modeController(Player player) throws InvalidSelectionException {
        switch (mode) {
            case FORCED_YATZY:
                selectedCol = game.getPlayerIndex(player);
                selectedRow = player.getFirstEmptyScoreIndex();
                break;
            case NORMAL_YATZY:
                if (selectedRow > Constant.INDEX_OF_BONUS && player.getScore(Constant.INDEX_OF_SUM) == null) {
                    throw new InvalidSelectionException("You have to finish the upper section first.");
                }
            case WILD_YATZY:
                if (selectedCol == -1) {
                    throw new InvalidSelectionException(player.getName() + ", you have to choose a combination");
                }
                if (selectedCol != game.getPlayerIndex(player)) {
                    throw new InvalidSelectionException("Wrong column. It is " + player.getName() + "'s turn.");
                }
                if (!player.isEmpty(selectedRow)) {
                    throw new InvalidSelectionException("Already taken");
                }
                if (selectedRow == Constant.INDEX_OF_BONUS || selectedRow == Constant.INDEX_OF_SUM
                        || selectedRow == Constant.INDEX_OF_TOTAL) {
                    throw new InvalidSelectionException("Bonus, sum and total are invalid selections");
                }

                break;
            default:
                break;
        }
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
                score = game.yatzy();
                break;
            default:
                System.out.println("Missing case for given index: " + index);
                break;
        }
        return score;
    }

    private void calculateSumBonus(Player player) {
        Integer[] playerScore = player.getScoreList();
        int playerIndex = game.getPlayerIndex(player);
        int sumIndex = Constant.INDEX_OF_SUM;
        int bonusIndex = Constant.INDEX_OF_BONUS;
        player.addSum();
        tableModel.setValueAt(playerScore[sumIndex], sumIndex, playerIndex);
        player.addBonus(getReqScoreForBonus());
        tableModel.setValueAt(playerScore[bonusIndex], bonusIndex, playerIndex);

    }

    private void calculateTotal(Player player) {
        Integer[] playerScore = player.getScoreList();
        int playerIndex = game.getPlayerIndex(player);
        final int totalIndex = Constant.INDEX_OF_TOTAL;

        player.addTotal();
        tableModel.setValueAt(playerScore[totalIndex], totalIndex, playerIndex);

    }

    private void saveScore(int row, int col, Player player) {

        Integer[] playerScore = player.getScoreList();
        //  If done add total and update table
        if (row < playerScore.length - 1) {
            // get score for index
            int score = getScore(row);
            // add score to player & update table
            player.addScore(score, row);
            tableModel.setValueAt(score, row, col);
        }
    }

    private int getReqScoreForBonus() {
        switch (mode) {
            case FORCED_YATZY:
                return Constant.FORCED_REQUIRED_SCORE_FOR_BONUS;
            default:
                return Constant.DEFAULT_REQUIRED_SCORE_FOR_BONUS;
        }

    }

}
