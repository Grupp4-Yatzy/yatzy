/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jensen.yatzy.view;

import com.jensen.yatzy.model.Constant;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author benjamin
 */
public class MenuView extends JPanel {
    
    JPanel centerPanel;
    ArrayList<JButton> menuButtons;
    Component continueFiller;
    
    public MenuView() {
        this.setLayout(new BorderLayout());
        // special green color
        this.setBackground(Constant.BG_COLOR_GREEN);
        
        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(300, 200));
        northPanel.setOpaque(false);
        
        String[] bigButtonTexts = {"Continue", "New Game", "Options", "Rules", "Quit"};
        
        centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        
        menuButtons = new ArrayList<>();
        for (String buttonText : bigButtonTexts) {
            JButton bigButton = new MenuButton(buttonText, false);
            menuButtons.add(bigButton);
            
            if (buttonText.equalsIgnoreCase("options"))
                bigButton.setEnabled(false);
            if (buttonText.equalsIgnoreCase("continue")) {
                int h = bigButton.getIcon().getIconHeight();
                continueFiller = Box.createVerticalStrut(h);
                centerPanel.add(continueFiller);
                bigButton.setEnabled(false);
                bigButton.setVisible(false);
            }
            Component filler;
            if (buttonText.equalsIgnoreCase("quit"))
                filler = Box.createVerticalStrut(50);
            else 
                filler = Box.createVerticalStrut(10);
            
            centerPanel.add(filler);
            
            centerPanel.add(bigButton);
        }
        centerPanel.add(Box.createVerticalStrut(25));
        
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
    }
    
    public void enableContinueButton() {
        for (JButton button : menuButtons) {
            if (button.getText().equalsIgnoreCase("continue")) {
                button.setEnabled(true);
                button.setVisible(true);
                continueFiller.setVisible(false);
                break;
            }
        }
    }
    
    public void addMenuLListener(ActionListener listener) {
        for (JButton button : menuButtons) {
            button.addActionListener(listener);
        }
    }
    
}
