package com.jensen.yatzy.model;

import java.awt.Color;

/**
 * This class is buildt for the constant in this program. This class only contains instance
 * variables.
 *
 * @author Benjamin Rosman, Roberto Blanco, Kami Hazzansadeh, Robin Nilsson
 */
public class Constant {

  /** Width of columns */
  public static final int COLUMN_WIDTH = 100;

  /** Score if player gets Yatzy */
  public static final int YATZY = 50;

  /** Set the number of dices */
  public static final int DEFUALT_NUMBER_OF_DICES = 5;

  /** Score required for getting bonus in Forced mode */
  public static final int FORCED_REQUIRED_SCORE_FOR_BONUS = 42;

  /** Score required for getting bonus in Normal and Wild mode */
  public static int DEFAULT_REQUIRED_SCORE_FOR_BONUS = 63;

  /** Score given if user reach the amount that is required */
  public static final int BONUS = 50;

  /** Index where the sum is shown */
  public static final int INDEX_OF_SUM = 6;

  /** Index where the bonus is shown */
  public static final int INDEX_OF_BONUS = 7;

  /** The defualt dive value */
  public static final int DEFUALT_DICE_VALUE = 6;

  /** An array of all the combinations */
  public static final String[] COMBINATIONS = {"Ones", "Twos", "Threes",
    "Fours", "Fives", "Sixes",
    "Sum", "Bonus", "One Pair", "Two Pair", "Three Of A Kind", "Four Of A Kind",
    "Small Straight", "Big Straight", "Fullhouse", "Chance", "Yatzy", "Total"};

  /** The total score is shown in index of total */
  public static final int INDEX_OF_TOTAL = COMBINATIONS.length - 1;

  /** A green color (used for the background */
  public static final Color BG_COLOR_GREEN = Color.getHSBColor(0.3305556f, 1.0f, 0.74f);

}
