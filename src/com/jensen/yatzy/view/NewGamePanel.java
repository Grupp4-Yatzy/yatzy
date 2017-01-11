package com.jensen.yatzy.view;

import com.jensen.yatzy.model.Constant;
import com.jensen.yatzy.model.YatzyMode;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * NewGamePanel is a JPanel, which displays a menu of sorts where users can choose number of players
 * and what yatzy mode to play.
 *
 * @author Benjamin Rosman, Roberto Blanco, Kami Hazzansadeh, Robin Nilsson
 */
public class NewGamePanel extends JPanel {

  private JPanel headPanel;
  private JPanel centerPanel;
  private JButton playButton;
  private JButton backButton;
  private JLabel playerLabel;
  private ArrayList<JRadioButton> yatzyModeOptions;
  private JTextField numberOfPlayers;
  private ArrayList<JTextField> playerNames;

  /**
   * Creates a default newGamePanel. Containting a panel for displaying and choosing yatzy mode, a
   * panel where a player can choose number of players, a panel where players can enter their names
   * & a panel containing a back button and a play button.
   */
  public NewGamePanel() {
    super();
    this.setBackground(Constant.BG_COLOR_GREEN);
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    headPanel = new JPanel();
    headPanel.setOpaque(false);

    JPanel northPanel = new JPanel();
    northPanel.setOpaque(false);
    playerLabel = new JLabel("Choose Number Of Players (1-6) & press enter: ");
    playerLabel.setOpaque(false);
    playerNames = new ArrayList<>();
    numberOfPlayers = new JTextField(3);
    numberOfPlayers.setMaximumSize(new Dimension(20, 10));
    northPanel.add(playerLabel);
    northPanel.add(numberOfPlayers);

    centerPanel = new JPanel();
    centerPanel.setOpaque(false);
    centerPanel.setPreferredSize(new Dimension(200, 250));
    centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

    JPanel southPanel = new JPanel();
    southPanel.setOpaque(false);
    playButton = new MenuButton("Play", true);
    backButton = new MenuButton("Back", true);
    backButton.setActionCommand("Menu");
    southPanel.add(backButton);
    southPanel.add(playButton);

    this.add(headPanel);
    this.add(northPanel);
    this.add(centerPanel);
    this.add(southPanel);

  }

  /**
   * Returns the play button.
   *
   * @return the play button.
   */
  public JButton getPlayButton() {
    return playButton;
  }

  /**
   * Returns text field that is holding the player input with the desired number of players.
   *
   * @return the text field containing the number of players.
   */
  public JTextField getNumberOfPlayers() {
    return numberOfPlayers;
  }

  /**
   * Returns an array of strings containing the player names.
   *
   * @return a String array with the player names.
   */
  public String[] getPlayerNames() {
    String[] names = new String[playerNames.size()];

    for (int i = 0; i < names.length; i++) {
      names[i] = playerNames.get(i).getText();
    }
    return names;
  }

  /**
   * Creates and displays a ButtonGroup of JRadioButtons for each YatzyMode in modes.
   *
   * @param modes an array of YatzyMode to be displayed as options to the player.
   */
  public void setYatzyModeOptions(YatzyMode[] modes) {
    // TODO move to constructor
    // headPanel = new JPanel();
    headPanel.removeAll();
    ButtonGroup buttonGroup = new ButtonGroup();
    yatzyModeOptions = new ArrayList<>();
    for (YatzyMode mode : modes) {
      JRadioButton option = new JRadioButton(mode.getMode());
      option.setContentAreaFilled(false);
      if (mode == YatzyMode.NORMAL_YATZY) {
        option.setSelected(true);
      }
      headPanel.add(option);
      yatzyModeOptions.add(option);
      buttonGroup.add(option);
    }

  }

  /**
   * Creates and displays the text fields for the player names.
   *
   * @param numberOfPlayers number of text fields to be created.
   */
  public void setPlayerFields(int numberOfPlayers) {

    Dimension d = centerPanel.getPreferredSize();
    centerPanel.setPreferredSize(d);

    centerPanel.removeAll();
    //centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
    playerNames = new ArrayList();
    for (int i = 0; i < numberOfPlayers; i++) {
      JTextField textField = new JTextField("Player" + (i + 1), 10);
      playerNames.add(textField);
      textField.setMaximumSize(new Dimension(100, 40));
      centerPanel.add(playerNames.get(i));
    }
    //this.add(centerPanel);
    centerPanel.repaint();
  }

  /**
   * Adds an ActionListener to the playButton, the numberOfPlayers and yatzyModeOptions
   *
   * @param listener The action listener to be notified when an option has changed and when the game
   *                 should begin.
   */
  public void AddOptionListener(ActionListener listener) {
    playButton.addActionListener(listener);
    numberOfPlayers.addActionListener(listener);
    for (int i = 0; i < yatzyModeOptions.size(); i++) {
      yatzyModeOptions.get(i).addActionListener(listener);
    }

  }

  /**
   * Adds an ActionListener to the backButton.
   *
   * @param listener The listener to be notified when the back button have been clicked.
   */
  public void addMenuListener(ActionListener listener) {
    backButton.addActionListener(listener);
  }

}
