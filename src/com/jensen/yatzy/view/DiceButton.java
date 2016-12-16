package com.jensen.yatzy.view;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.JButton;

public class DiceButton extends JButton {

    public DiceButton(String text) {

        super(text);
        this.setPreferredSize(new Dimension(50, 50));
    }

    public DiceButton() {
		super();
        this.setPreferredSize(new Dimension(50, 50));
	}

	public void DiceToggleLock() {
        if (this.isSelected()) {
            this.setSelected(false);
        } else {
            this.setSelected(true);
        }
    }
    
    public void setIcons(Icon[] icons){
    	setIcon(icons[0]);
    	setDisabledIcon(icons[1]);
    	setSelectedIcon(icons[2]);
    }
}
