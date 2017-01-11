package com.jensen.yatzy.model;

/**
 * Player class holds the player name and a players score
 *
 * @author Benjamin Rosman, Roberto Blanco, Kami Hazzansadeh, Robin Nilsson
 *
 */
public class Player {

  private String name;
  private Integer[] scoreList;

  /**
   * Creates a player and initializes name and scoreList to the length of combinations in Constant.
   *
   * @param name The players name.
   */
  public Player(String name) {
    this.name = name;
    scoreList = new Integer[Constant.COMBINATIONS.length];
  }

  /**
   * Gets the score at the specific index.
   *
   * @param index Index Of the score to be returned.
   *
   * @return the score stored at given index.
   */
  public Integer getScore(int index) {
    return scoreList[index];
  }

  /**
   * Gets the name of the player.
   *
   * @return name of the player.
   */
  public String getName() {
    return name;
  }

  /**
   * Adds a score to a specific index.
   *
   * @param score The score to be saved.
   * @param index The index in which the score should be stored.
   */
  public void addScore(int score, int index) {
    scoreList[index] = score;
  }

  /**
   * Sums a players score from the uppersection (ones to sixes) and stores the sum in index of sum.
   */
  public void addSum() {
    int sum = 0;
    for (int i = 0; i < Constant.INDEX_OF_SUM; i++) {
      sum += getScore(i);
    }
    addScore(sum, Constant.INDEX_OF_SUM);
  }

  /**
   * This methods checks if index of sum has a value of reqScore or more, if so the bonus will be
   * added to index of bonus, else zero will be added to index of bonus.
   *
   * @param reqScore The amount needed to receive the bonus.
   */
  public void addBonus(int reqScore) {
    if (scoreList[Constant.INDEX_OF_SUM] >= reqScore) {
      addScore(Constant.BONUS, Constant.INDEX_OF_BONUS);
    } else {
      addScore(0, Constant.INDEX_OF_BONUS);
    }
  }

  /**
   * Adds all the scores and stores the value in the index of total.
   */
  public void addTotal() {
    int totalIndex = Constant.INDEX_OF_TOTAL;
    int total = getScore(Constant.INDEX_OF_SUM) + getScore(Constant.INDEX_OF_BONUS);
    for (int i = Constant.INDEX_OF_BONUS + 1; i < totalIndex; i++) {
      total += getScore(i);
    }
    addScore(total, totalIndex);
  }

  /**
   * Checks for the first empty index in the scoreList.
   *
   * @return The first empty score index
   */
  public int getFirstEmptyScoreIndex() {
    for (int i = 0; i < scoreList.length; i++) {
      if (isEmpty(i)) {
        return i;
      }
    }
    return scoreList.length;
  }

  /**
   * Returns if scoreList is empty at index.
   *
   * @param index The index that is checked if its empty.
   *
   * @return True if index is empty, false if is not empty.
   */
  public boolean isEmpty(int index) {
    return scoreList[index] == null;
  }

  @Override
  public String toString() {
    return getName();
  }

}
