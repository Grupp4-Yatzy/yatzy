package com.jensen.yatzy.view;


import java.awt.BorderLayout;
import java.awt.Color;
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
    
    public GameView (){
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(westPanel, BorderLayout.WEST);
        centerPanel.setBackground(Color.yellow);
        westPanel.setBackground(Color.blue);
    }
}
