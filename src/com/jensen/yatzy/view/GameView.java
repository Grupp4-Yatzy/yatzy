package com.jensen.yatzy.view;

import com.jensen.yatzy.model.Constant;
import com.jensen.yatzy.model.Dice;
import com.jensen.yatzy.model.DiceIcon;
import com.jensen.yatzy.model.YatzyTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * A JPanel for displaying an ongoing Yatzy game
 *
 * @author benjamin
 *
 */
public class GameView extends JPanel {

    private JPanel westPanel;
    private JPanel centerPanel;
    private JButton rollButton;
    private JButton doneButton;
    private JButton newGameButton;
    private DiceButton[] diceButtons = new DiceButton[5];
    private ArrayList<JLabel> playerNames = new ArrayList<>();
    private JTable table;
    private JPanel northGridPanel = new JPanel();
    private Dimension combinationLabelSize = new Dimension(110, 110 / 10);

    /**
     * Creates a GameView
     */
    public GameView() {

        this.setLayout(new BorderLayout());
        westPanel = new JPanel();
        GridLayout westGrid = new GridLayout(0, 1);
        westGrid.setVgap(1);
        westPanel.setLayout(westGrid);
        westPanel.setBackground(Color.BLACK);

        JPanel northPanel = new JPanel();
        GridLayout northGrid = new GridLayout(1, 0);
        northPanel.setLayout(new BorderLayout());
        northPanel.setBackground(Color.BLACK);
        northGridPanel.setLayout(northGrid);
        northGrid.setHgap(1);
        northGridPanel.setBackground(Color.BLACK);

        centerPanel = new JPanel();

        newGameButton = new JButton("New Game");
        newGameButton.setPreferredSize(combinationLabelSize);
        JLabel label = new JLabel("Yatzy");
        northPanel.add(newGameButton, BorderLayout.WEST);
        northPanel.add(northGridPanel, BorderLayout.CENTER);
        label.setPreferredSize(combinationLabelSize);

        JPanel southCenter = new JPanel();
        southCenter.setBackground(Color.GRAY);
        for (int i = 0; i < diceButtons.length; i++) {
            DiceButton dice = new DiceButton();
            diceButtons[i] = dice;
            dice.setActionCommand("Dice" + i);
            southCenter.add(dice);
        }

        JPanel southEast = new JPanel();
        southEast.setBackground(Color.GRAY);
        rollButton = new JButton("Roll");
        rollButton.setActionCommand("Roll");
        doneButton = new JButton("Done");
        southEast.add(rollButton);
        southEast.add(doneButton);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.setBackground(Color.ORANGE);
        southPanel.add(southCenter, BorderLayout.CENTER);
        southPanel.add(southEast, BorderLayout.EAST);

        this.add(westPanel, BorderLayout.WEST);
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
    }

    /**
     * Creates and adds JLables to the panel with the names given
     *
     * @param names The array of names you want displayed above the table
     */
    public void setPlayerNames(String[] names) {
        for (String name : names) {
            JLabel label = new JLabel(name);
            label.setBackground(Color.getHSBColor(0.3305556f, 1.0f, 0.74f));
            label.setOpaque(true);
            label.setHorizontalAlignment(JLabel.CENTER);
            playerNames.add(label);
            label.setPreferredSize(new Dimension(Constant.COLUMN_WIDTH, 20));
            northGridPanel.add(label);
        }
    }

    /**
     *
     * @return playerNames
     */
    public ArrayList<JLabel> getPlayerNames() {

        return playerNames;
    }

    /**
     * Creates a new JTable with the given model and adds it to the panel
     *
     * @param model
     * @see AbstractTableModel
     */
    public void initTable(YatzyTableModel model) {
        this.table = new JTable(model) {
            // Källa på följande kodstycke taget från https://www.youtube.com/watch?v=iMBfneE2Ztg
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
              
                if (row % 2 == 0) {
                    c.setBackground(Color.LIGHT_GRAY);
                } else {
                    c.setBackground(Color.WHITE);
                }
                super.setBackground(Color.BLACK);
                c.setForeground(Color.BLACK);
                return c;

            }
            // Slut på lånad kod
        };
        this.add(table, BorderLayout.CENTER);
    }

    public JTable getTable() {
        return this.table;
    }

    /**
     * Sets the text on the dice buttons to display the values on the dices
     *
     * @param dices Array of dices which values will be displayed on the buttons
     */
    public void setDiceButtons(Dice[] dices, DiceIcon icons) {
        for (int i = 0; i < diceButtons.length; i++) {
            diceButtons[i].setIcons(icons.getDiceIcons(dices[i].getValue()));
        }
    }

    /**
     * Sets each dice button to be enabled or disabled
     *
     * @param enableDice given true all dice buttons will be enabled
     */
    public void setEnableDice(boolean enableDice) {
        for (int i = 0; i < diceButtons.length; i++) {
            diceButtons[i].setEnabled(enableDice);
        }
    }

    /**
     * Returns an array of all dice buttons
     *
     * @return an array of all dice buttons
     */
    public DiceButton[] getDiceButtons() {
        return diceButtons;
    }

    /**
     * Returns the roll button
     *
     * @return the roll button
     */
    public JButton getRollButton() {
        return rollButton;
    }

    /**
     *
     * @return doneButton
     */
    public JButton getDoneButton() {
        return doneButton;
    }

    /**
     *
     * @return newGameButton
     */
    public JButton getNewGameButton() {
        return newGameButton;
    }

    /**
     * Creates and adds JLables to the GameView panel for each element in
     * combinations
     *
     * @param combinations An array of string containing the combinations in the
     * order to be displayed
     */
    public void setCombinations(String[] combinations) {
        for (int i = 0; i < combinations.length; i++) {
            JLabel label = new JLabel(combinations[i]);
            label.setPreferredSize(combinationLabelSize);
            label.setSize(combinationLabelSize);
            label.setBackground(Color.getHSBColor(0.3305556f, 1.0f, 0.74f));
            label.setOpaque(true);
            label.setHorizontalAlignment(JLabel.CENTER);
            if(Constant.INDEX_OF_BONUS==i || Constant.INDEX_OF_SUM==i || Constant.INDEX_OF_TOTAL==i){
                label.setFont(new Font("Arial", Font.BOLD, 14));
            } else {
                label.setFont(new Font("Arial", Font.PLAIN, 12));
            }
            westPanel.add(label);
        }
    }

    /**
     * This metod marks the current player with bold font and bigger size and
     * the non current player with a plain font and a smaller size.
     *
     * @param playerIndex
     */
    public void playerIndicator(int playerIndex) {

        for (int i = 0; i < playerNames.size(); i++) {
            JLabel label = playerNames.get(i);
            if (playerIndex == i) {
                label.setFont(new Font("Arial", Font.BOLD, 14));
            } else {
                label.setFont(new Font("Arial", Font.PLAIN, 12));
            }
        }

    }

    /**
     * Adds an ActionListener to all the dice buttons
     *
     * @param listener A action listener to be notified when an action has
     * occurred
     */
    public void addDiceListener(ActionListener listener) {
        for (int i = 0; i < diceButtons.length; i++) {
            diceButtons[i].addActionListener(listener);
        }
    }

    /**
     * Adds an ActionListener to the roll button and the done button
     *
     * @param listener A action listener to be notified when an action has
     * occurred
     */
    public void addPlayListener(ActionListener listener) {
        rollButton.addActionListener(listener);
        doneButton.addActionListener(listener);
        newGameButton.addActionListener(listener);
    }
}
