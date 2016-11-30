package com.jensen.yatzy.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class GameView extends JPanel{
    //JPanel eastPanel = new JPanel();
    JPanel westPanel = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JButton rollButton = new JButton();
    JButton doneButton = new JButton();
    JButton[] diceButtons = new JButton[5];
    ArrayList<String> playerNames = new ArrayList<>();
    
    
    public GameView (){
        this.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.yellow);
        centerPanel.setPreferredSize(new Dimension(200,200));
        
        GridLayout grid = new GridLayout(0,1);
        grid.setVgap(5);
        westPanel.setLayout(grid);
        westPanel.setBackground(Color.blue);
        //westPanel.setPreferredSize(new Dimension(100,100));
        for(int numberOfLabels=1; numberOfLabels<=10; numberOfLabels++){
            JLabel label = new JLabel(""+numberOfLabels);
            label.setPreferredSize(new Dimension(200,100/10));
            label.setBackground(Color.PINK);
            label.setOpaque(true);
            label.setHorizontalAlignment(JLabel.CENTER);
            westPanel.add(label);
           
            
        }
        
        JPanel northGridPanel = new JPanel();
        GridLayout northGrid = new GridLayout(1,0);
        northPanel.setLayout(new BorderLayout());
        northPanel.setBackground(Color.BLACK);
        //northPanel.setPreferredSize(new Dimension(600,100));
        String[] names = {"Benjamin", "Robin", "Roberto", "Kami"};
        System.out.println(names.toString());
        setPlayerNames(names);
        for(String playerName: playerNames){
            JLabel label = new JLabel(playerName);
            //label.setPreferredSize(new Dimension(200,100/10));
            label.setBackground(Color.GREEN);
            label.setOpaque(true);
            label.setHorizontalAlignment(JLabel.CENTER);
            northGridPanel.add(label);
        }
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(westPanel.getWidth(), 20));
        northPanel.add(label, BorderLayout.WEST);
        northPanel.add(northGridPanel, BorderLayout.CENTER);
                
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(westPanel, BorderLayout.WEST);
        this.add(northPanel, BorderLayout.NORTH);
    }
    public void setPlayerNames(String[] names){
        for(int i=0; i<names.length; i++){
            playerNames.add(names[i]);
        }
    }
}
