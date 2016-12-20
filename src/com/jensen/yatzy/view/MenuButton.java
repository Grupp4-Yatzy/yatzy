/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jensen.yatzy.view;

import com.jensen.yatzy.model.ButtonIcon;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author benjamin
 */
public class MenuButton extends JButton {
    
    public MenuButton(String txt, boolean small) {
        super(txt);
        if (small) {
            initSmallButton();
        } else {
            initLargeButton();
        }
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setAlignmentX(CENTER_ALIGNMENT);
        
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        // set text color to match the frame
        this.setForeground(Color.getHSBColor(0.152778f, 0.91f, 0.92f));
    }
    
    private void initSmallButton() {
        this.setIcon(ButtonIcon.SMALL_FRAME);
        this.setDisabledIcon(ButtonIcon.SMALL_DISABLED_FRAME);
        this.setRolloverIcon(ButtonIcon.SMALL_ROLL_OVER_FRAME);
        this.setPressedIcon(ButtonIcon.SMALL_PRESSED_FRAME);
        
        Dimension d = new Dimension(ButtonIcon.SMALL_FRAME.getIconWidth(),
                ButtonIcon.SMALL_FRAME.getIconHeight());
        
        this.setPreferredSize(d);
        this.setMaximumSize(d);
        
        this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
    }

    private void initLargeButton() {
        this.setIcon(ButtonIcon.FRAME);
        this.setDisabledIcon(ButtonIcon.DISABLED_FRAME);
        this.setRolloverIcon(ButtonIcon.ROLL_OVER_FRAME);
        this.setPressedIcon(ButtonIcon.PRESSED_FRAME);
        
        Dimension d = new Dimension(ButtonIcon.FRAME.getIconWidth(), 
                ButtonIcon.FRAME.getIconHeight());
        
        this.setPreferredSize(d);
        this.setMaximumSize(d);
        
        this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    }
    
}
