package com.jensen.yatzy.model;

/**
 * Enum class created for three different Yatzy modes.
 *
 * @author Benjamin Rosman, Roberto Blanco, Kami Hazzansadeh, Robin Nilsson
 */
public enum YatzyMode {
  FORCED_YATZY("Forced"), NORMAL_YATZY("Normal"), WILD_YATZY("Wild");

  private String mode;

  /**
   * Intializes mode
   *
   * @param s
   */
  private YatzyMode(String s) {
    this.mode = s;
  }

  /**
   *
   * @return mode
   */
  public String getMode() {
    return this.mode;
  }
}
