package com.jensen.yatzy.view;

import java.awt.Dimension;
import javax.swing.JButton;

public class DiceButton extends JButton {

    public DiceButton(String text) {

        super(text);
        this.setPreferredSize(new Dimension(50, 50));
    }

    public void DiceToggleLock() {
        if (this.isOpaque()) {
            this.setOpaque(false);
        } else {
            this.setOpaque(true);
        }
    }
}
