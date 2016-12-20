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
 * NewGamePanel class creates the first window where you can choose how many
 * players will participate in the game and choose which yatzy mode the user
 * wants to play.
 * @author RobertoBlanco
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
     * The constructor initialize panels, labels, an ArrayList, textfields and a
     * button.
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
     * 
     * @return okButton
     */
    public JButton getPlayButton() {
        return playButton;
    }

    /**
     *
     * @return numberOfPlayers
     */
    public JTextField getNumberOfPlayers() {
        return numberOfPlayers;
    }

    /**
     * An ArrayList that stores player names in a textfield
     *
     * @return player names
     */
    public String[] getPlayerNames() {
        String[] names = new String[playerNames.size()];

        for (int i = 0; i < names.length; i++) {
            names[i] = playerNames.get(i).getText();
        }
        return names;
    }
    
    /**
     * Creates ButtonGroup for three different Yatzy modes
     * and adds them to the headPanel.
     * @param modes 
     */
    public void setYatzyModeOptions(YatzyMode[] modes) {
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
     * Creates the player fields name
     *
     * @param numberOfPlayers
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
     * Adds an ActionListener to the okButton, the numberOfPlayers and
     * yatzyModeOptions
     *
     * @param listener A action listener to be notified when an action has
     * occurred
     */
    public void AddOptionListener(ActionListener listener) {
        playButton.addActionListener(listener);
        numberOfPlayers.addActionListener(listener);
        for (int i = 0; i < yatzyModeOptions.size(); i++) {
            yatzyModeOptions.get(i).addActionListener(listener);
        }

    }
    
    public void addMenuListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

}
