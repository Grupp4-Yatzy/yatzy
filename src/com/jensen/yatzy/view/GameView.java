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
 * A JPanel for displaying a game of yatzy
 *
 * @author Benjamin Rosman, Roberto Blanco, Kami Hazzansadeh, Robin Nilsson
 *
 */
public class GameView extends JPanel {

  private JPanel westPanel;
  private JPanel centerPanel;
  private JButton rollButton;
  private JButton doneButton;
  private JButton menuButton;
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

    menuButton = new MenuButton("Menu", true);
    menuButton.setPreferredSize(combinationLabelSize);
    JLabel label = new JLabel("Yatzy");
    northPanel.add(menuButton, BorderLayout.WEST);
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
    rollButton = new MenuButton("Roll", true);
    rollButton.setActionCommand("Roll");
    doneButton = new MenuButton("Done", true);
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
   * Returns the list of JLabels with the player names.
   *
   * @return playerNames The list of JLabels with the player names.
   */
  public ArrayList<JLabel> getPlayerNames() {
    return playerNames;
  }

  /**
   * Creates a new JTable with the given model and adds it to the panel. Used to initiate the table.
   * The table displays the scores.
   *
   * @param model The model to update the table.
   *
   * @see YatzyTableModel
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

  /**
   * Returns the table displaying the scores.
   *
   * @return The table displeying the scores.
   */
  public JTable getTable() {
    return this.table;
  }

  /**
   * Sets the dice buttons to display the values of the dices.
   *
   * @param dices Array of dices which values will be displayed on the buttons.
   * @param icons Object containg all dice icons.
   *
   * @see Dice
   * @see DiceButton
   * @see DiceIcon
   */
  public void setDiceButtons(Dice[] dices, DiceIcon icons) {
    for (int i = 0; i < diceButtons.length; i++) {
      diceButtons[i].setIcons(icons.getDiceIcons(dices[i].getValue()));
    }
  }

  /**
   * Sets all dice button to be enabled or disabled.
   *
   * @param enableDice given true all dice buttons will be enabled otherwise disabled.
   */
  public void setEnableDiceButtons(boolean enableDice) {
    for (int i = 0; i < diceButtons.length; i++) {
      diceButtons[i].setEnabled(enableDice);
    }
  }

  /**
   * Returns the array with all dice buttons.
   *
   * @return The array with all dice buttons.
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
   * Returns the done button.
   *
   * @return doneButton The done button.
   */
  public JButton getDoneButton() {
    return doneButton;
  }

  /**
   * Returns the menu button.
   *
   * @return The menu button.
   */
  public JButton getMenuButton() {
    return menuButton;
  }

  /**
   * Creates and adds JLables to the GameView panel for each element in combinations
   *
   * @param combinations An array of string containing the combinations in the order to be displayed
   */
  public void setCombinations(String[] combinations) {
    for (int i = 0; i < combinations.length; i++) {
      JLabel label = new JLabel(combinations[i]);
      label.setPreferredSize(combinationLabelSize);
      label.setSize(combinationLabelSize);
      label.setBackground(Color.getHSBColor(0.3305556f, 1.0f, 0.74f));
      label.setOpaque(true);
      label.setHorizontalAlignment(JLabel.CENTER);
      if (Constant.INDEX_OF_BONUS == i || Constant.INDEX_OF_SUM == i || Constant.INDEX_OF_TOTAL == i) {
        label.setFont(new Font("Arial", Font.BOLD, 14));
      } else {
        label.setFont(new Font("Arial", Font.PLAIN, 12));
      }
      westPanel.add(label);
    }
  }

  /**
   * Marks the current player with bold and bigger font size and set all other player fonts to
   * plain.
   *
   * @param playerIndex The index of the current player.
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
   * Adds an ActionListener to all the dice buttons.
   *
   * @param listener The action listener to be notified when a dice is clicked.
   */
  public void addDiceListener(ActionListener listener) {
    for (int i = 0; i < diceButtons.length; i++) {
      diceButtons[i].addActionListener(listener);
    }
  }

  /**
   * Adds an ActionListener to the roll button and the done button.
   *
   * @param listener The action listener to be notified when the roll or done button is clicked.
   */
  public void addPlayListener(ActionListener listener) {
    rollButton.addActionListener(listener);
    doneButton.addActionListener(listener);
  }

  /**
   * Adds an ActionListener to the menu button.
   *
   * @param listener The action listener to be notified when the menu button is clicked.
   */
  public void addMenuListener(ActionListener listener) {
    menuButton.addActionListener(listener);
  }
}
