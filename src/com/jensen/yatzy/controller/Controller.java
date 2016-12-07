package com.jensen.yatzy.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jensen.yatzy.controller.Controller.DiceListener;
import com.jensen.yatzy.controller.Controller.PlayListener;
import com.jensen.yatzy.model.Constant;
import com.jensen.yatzy.model.Dice;
import com.jensen.yatzy.model.Yatzy;

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
                    int count = 3;
                    game.decreaseRolls();
                    if(game.getNumbersOfRollsLeft()==0)
                    {
                        gamePanel.getRollButton().setEnabled(false);
                    }
                    gamePanel.getRollButton().setText("Roll (" + game.getNumbersOfRollsLeft()+")");
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
            
            System.out.println(ac);
            Dice[] dices = game.getDices();
            String value = ac.substring(ac.length() - 1);
            Integer index = Integer.parseInt(value);
            dices[index].toggleLock();
            
            JButton buttonColor = (JButton) e.getSource();
            if(dices[index].isLocked())
            {
                buttonColor.setOpaque(true);
                buttonColor.setBackground(Color.GREEN);
                
            }
            else
            {
                buttonColor.setOpaque(false);
            }
            
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
        gamePanel.setCombinations(Constant.combinations);
        Integer[][] data = new Integer[Constant.combinations.length][names.length];
        gamePanel.setTable(data, names);
    }

    /**
     * Rolls all unlocked dices TODO unlock all dices
     */
    void rollButton() {
        Dice[] dices = game.getDices();
        for (Dice dice : dices) {
            if (!dice.isLocked()) {
                dice.roll();
            }
            dice.setLock(false);
            
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
