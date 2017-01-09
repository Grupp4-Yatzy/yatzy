package com.jensen.yatzy.model;

import com.jensen.yatzy.util.Randomizer;

/**
 * A class that represent a six sided dice with the property of being locked or unlocked.
 *
 * @author Benjamin Rosman, Roberto Blanco, Kami Hazzansadeh, Robin Nilsson
 *
 */
public class Dice {

  private int value;
  private boolean isLocked;

  /**
   * Creates a dice with the default dice value and is set to unlocked.
   */
  public Dice() {
    value = Constant.DEFUALT_DICE_VALUE;
    isLocked = false;
  }

  /**
   * Gets the value of the upward facing side
   *
   * @return value of the dice
   */
  public int getValue() {
    return value;
  }

  /**
   * Sets the dice value to a random number 1-6 even if the dice is locked.
   */
  public void roll() {
    value = Randomizer.getInt(1, 6);
  }

  /**
   * Returns whether a dice is locked or not.
   *
   * @return True if a dice is locked otherwise false.
   */
  public boolean isLocked() {
    return isLocked;
  }

  /**
   * Toggles wheter a dice is locked or unlocked.
   */
  public void toggleLock() {
    isLocked = !isLocked;
  }

  /**
   * Sets a dice to be locked or not.
   *
   * @param b true to lock the dice, false to unlock it.
   */
  public void setLock(boolean b) {
    isLocked = b;
  }

  @Override
  public String toString() {
    return "Value: " + getValue() + ", locked: " + isLocked();
  }
}
