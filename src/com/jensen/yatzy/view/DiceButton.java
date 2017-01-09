package com.jensen.yatzy.view;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 * Specific button for dices.
 *
 * @author Benjamin Rosman, Roberto Blanco, Kami Hazzansadeh, Robin Nilsson
 * @see JButton
 */
public class DiceButton extends JButton {

  /**
   * Creates a dice button with the preferred size 50x50, sets content area filled and border
   * painted to false.
   */
  public DiceButton() {
    super();
    setPreferredSize(new Dimension(50, 50));
    setContentAreaFilled(false);
    setBorderPainted(false);
  }

  /**
   * Toggles whether a dice is selected or not.
   */
  public void toggleSelection() {
    setSelected(!isSelected());
  }

  /**
   * Sets the buttons icons. Icons need to be in a specific order with the icon on index zero,
   * disabled icon on index 1 and selected icon on index 2.
   *
   * @param icons The array containg the icons to be set on the button.
   */
  public void setIcons(Icon[] icons) {
    setIcon(icons[0]);
    setDisabledIcon(icons[1]);
    setSelectedIcon(icons[2]);
  }
}
