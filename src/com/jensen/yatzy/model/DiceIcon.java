package com.jensen.yatzy.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * This class holds three different images for each dice value (1-6).
 *
 * @author Benjamin Rosman, Robin Nilsson
 */
public class DiceIcon {

  private static DiceIcon instance;
  private final Icon[][] diceIcons;

  /**
   * The constructor initiates three different images for each value.
   */
  private DiceIcon() {
    diceIcons = new Icon[6][3];
    for (int i = 0; i < diceIcons.length; i++) {
      diceIcons[i][0] = new ImageIcon(getClass().getResource("/images/normal/" + (i + 1) + ".png"));
      diceIcons[i][1] = new ImageIcon(getClass().getResource("/images/gray/" + (i + 1) + ".png"));
      diceIcons[i][2] = new ImageIcon(getClass().getResource("/images/blue/" + (i + 1) + ".png"));
    }

  }

  /**
   * Return the DiceIcon instance if there is no intance a new instance is created.
   *
   * @return the instance of DiceIcon.
   */
  public static DiceIcon getInstance() {

    if (instance == null) {
      instance = new DiceIcon();
    }
    return instance;
  }

  /**
   * Gets the images that is represented by the given value.
   *
   * @param diceValue the value of the dice for which you require icons.
   *
   * @return Icons representing the given value.
   */
  public Icon[] getDiceIcons(int diceValue) {
    return diceIcons[diceValue - 1];
  }

}
