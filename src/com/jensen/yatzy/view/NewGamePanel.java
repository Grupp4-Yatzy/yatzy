
package com.jensen.yatzy.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * NewGamePanel class creates the first window where you can choose how
 * many players will participate in the game
 * @author RobertoBlanco
 */
public class NewGamePanel extends JPanel {
    
    private JPanel centerPanel;
    private JButton okButton;
    private JLabel playerLabel;
    private JTextField numberOfPlayers;
    private ArrayList<JTextField> playerNames;
    
    /**
     * The constructor initialize panels, labels, an ArrayList, textfields
     * and a button.
     */
    public NewGamePanel() {
        super();
        //this.setPreferredSize(new Dimension (400,500));
        this.setLayout(new BorderLayout());
        
        JPanel northPanel = new JPanel();
        centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(400,300));
        JPanel southPanel = new JPanel();
        
        playerLabel = new JLabel("Choose Number Of Players (1-6):");
        playerNames = new ArrayList<>();
        numberOfPlayers = new JTextField(3);
        numberOfPlayers.setMaximumSize(new Dimension (20,10));
        okButton = new JButton("OK");
        
        northPanel.add(playerLabel);
        northPanel.add(numberOfPlayers);
        this.add(northPanel, BorderLayout.NORTH);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        this.add(centerPanel, BorderLayout.CENTER);
        southPanel.add(okButton);
        this.add(southPanel, BorderLayout.SOUTH);
        
    }
    
    public JButton getOkButton(){
        return okButton;
    }
    
    /**
     * 
     * @return number of players
     */
    public JTextField getNumberOfPlayers(){
        return numberOfPlayers;
    }
    
    /**
     * An ArrayList that stores player names in a textfield
     * @return player names
     */
    public String[] getPlayerNames(){
        String[] names = new String[playerNames.size()];
        
        for(int i = 0; i<names.length; i++){
            names[i] = playerNames.get(i).getText();
        }
        return names;
    }
    
    /**
     * Creates the player fields name
     * @param numberOfPlayers 
     */
    public void setPlayerFields(int numberOfPlayers){
            centerPanel = new JPanel();
            centerPanel.setPreferredSize(new Dimension(400,300));
            centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
            playerNames = new ArrayList();
        for(int i = 0; i<numberOfPlayers; i++) {
            JTextField textField = new JTextField("Player" + (i + 1), 10);
            playerNames.add(textField);
            textField.setMaximumSize(new Dimension(100,40));
            centerPanel.add(playerNames.get(i));
        } 
        this.add(centerPanel);
    }
     
    public void AddListener(ActionListener listener){
        okButton.addActionListener(listener);
        numberOfPlayers.addActionListener(listener);
    }
    
}
