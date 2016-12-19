package com.jensen.yatzy.view;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 * Models a dice button. It inherits from JButton
 *
 * @author RobertoBlanco
 */
public class DiceButton extends JButton {


	/**
	 *Intialize super and sets preferred size
	 * @param text
	 */
	public DiceButton() {
		super();
		this.setPreferredSize(new Dimension(50, 50));
		setContentAreaFilled(false);
		setBorderPainted(false);
	}

	/**
	 * Enables a dice to be locked and unlocked
	 */
	public void DiceToggleLock() {
		if (this.isSelected()) {
			this.setSelected(false);
		} else {
			this.setSelected(true);
		}
	}

	/**
	 * set three different  icons  in an array
	 * @param icons 
	 */
	public void setIcons(Icon[] icons) {
		setIcon(icons[0]);
		setDisabledIcon(icons[1]);
		setSelectedIcon(icons[2]);
	}
}
