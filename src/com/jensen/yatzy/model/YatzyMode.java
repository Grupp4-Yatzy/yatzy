package com.jensen.yatzy.model;

/**
 * Holds the different yatzy modes
 *
 * @author Benjamin Rosman, Roberto Blanco, Kami Hazzansadeh, Robin Nilsson
 */
public enum YatzyMode {
  FORCED_YATZY("Forced"), NORMAL_YATZY("Normal"), WILD_YATZY("Wild");

  private String modeName;

  private YatzyMode(String s) {
    this.modeName = s;
  }

  /**
   * Returns the name of the mode as a string.
   *
   * @return The name of the mode.
   */
  public String getMode() {
    return this.modeName;
  }
}
