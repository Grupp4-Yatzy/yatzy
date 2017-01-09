package com.jensen.yatzy.model;

import java.awt.Color;

/**
 * This class gathers most of the constants in this program to a single file.
 *
 * @author Benjamin Rosman, Roberto Blanco, Kami Hazzansadeh, Robin Nilsson
 */
public class Constant {

  /** The default number of dices */
  public static final int DEFUALT_NUMBER_OF_DICES = 5;
  
  /** Number of rolls */
  public static final int NUMBER_OF_ROLLS = 3;

  /** The defualt dice value */
  public static final int DEFUALT_DICE_VALUE = 6;

  /** Score required for getting bonus in Forced mode */
  public static final int FORCED_REQUIRED_SCORE_FOR_BONUS = 42;

  /** Score required for getting bonus in Normal and Wild mode */
  public static int DEFAULT_REQUIRED_SCORE_FOR_BONUS = 63;

  /** The Amount of bonus points recieved */
  public static final int BONUS = 50;

  /** The score rewarded when a player gets yatzy */
  public static final int YATZY = 50;

  /** An array of all the combinations */
  public static final String[] COMBINATIONS = {"Ones", "Twos", "Threes",
    "Fours", "Fives", "Sixes",
    "Sum", "Bonus", "One Pair", "Two Pair", "Three Of A Kind", "Four Of A Kind",
    "Small Straight", "Big Straight", "Fullhouse", "Chance", "Yatzy", "Total"};

  /** Index where the sum is shown */
  public static final int INDEX_OF_SUM = 6;

  /** Index where the bonus is shown */
  public static final int INDEX_OF_BONUS = 7;

  /** Index where the total is shown */
  public static final int INDEX_OF_TOTAL = COMBINATIONS.length - 1;

  /** Width of columns */
  public static final int COLUMN_WIDTH = 100;

  /** The background color (green) */
  public static final Color BG_COLOR_GREEN = Color.getHSBColor(0.3305556f, 1.0f, 0.74f);

}
