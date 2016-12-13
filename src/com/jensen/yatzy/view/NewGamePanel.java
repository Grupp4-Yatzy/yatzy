
package com.jensen.yatzy.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author RobertoBlanco
 */
public class NewGamePanel extends JPanel {
    
    private JPanel centerPanel;
    private JButton okButton;
    private JLabel playerLabel;
    private JTextField numberOfPlayers;
    private ArrayList<JTextField> playerNames;
    
    public NewGamePanel() {
        super();
        //this.setPreferredSize(new Dimension (400,500));
        this.setLayout(new BorderLayout());
        
        JPanel northPanel = new JPanel();
        centerPanel = new JPanel();
        JPanel southPanel = new JPanel();
        
        playerLabel = new JLabel("Choose Number Of Players:");
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
    
    public String getNumberOfPlayers(){
        return numberOfPlayers.getText();
    }
    
    public ArrayList<String> getPlayerNames(){
        ArrayList<String> names = new ArrayList<>();
        
        for(JTextField name : playerNames){
            names.add(name.getText());
        }
        return names;
    }
    
    public void setPlayerFields(int numberOfPlayers){
            
        for(int i = 0; i<numberOfPlayers; i++) {
            JTextField textField = new JTextField("Player" + i, 10);
            playerNames.add(textField);
            textField.setMaximumSize(new Dimension(100,40));
            centerPanel.add(playerNames.get(i));
        }     
    }
            
    
}
