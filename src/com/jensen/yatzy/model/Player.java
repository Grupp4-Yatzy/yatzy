package com.jensen.yatzy.model;

/**
 * Player class holds the player name and the score list
 *
 * @author Benjamin Rosman, Roberto Blanco, Kami Hazzansadeh, Robin Nilsson
 *
 */
public class Player {

  private String name;
  private Integer[] scoreList;

  /**
   * Initialze Player name and sets the scoreList to the constant Combination list
   *
   * @param name
   */
  public Player(String name) {
    this.name = name;
    scoreList = new Integer[Constant.COMBINATIONS.length];
  }

  /**
   * Gets the scoreList array (All the combinations).
   *
   * @return the scoreList
   */
  public Integer[] getScoreList() {
    return scoreList;
  }

  /**
   * Gets the score of the specific index.
   *
   * @param index
   *
   * @return the score stored at given index
   */
  public Integer getScore(int index) {
    return scoreList[index];
  }

  /**
   * Gets the name of the player.
   *
   * @return name of the player
   */
  public String getName() {
    return name;
  }

  /**
   * Adds a score to a specific index.
   *
   * @param score the score to be saved
   * @param index the index in which the score should be saved
   */
  public void addScore(int score, int index) {
    scoreList[index] = score;
  }

  /**
   * Adds all the combinations from the upper scoreboard (1-6) and stores the value in index 6
   * (total).
   */
  public void addSum() {
    int sum = 0;
    for (int i = 0; i < Constant.INDEX_OF_SUM; i++) {
      sum += getScore(i);
    }
    addScore(sum, Constant.INDEX_OF_SUM);
  }

  /**
   * This methods checks if index 6 has a value of 42 or more, if so the bonus will be given (50
   * points), else no bonus will be given.
   *
   * @param reqScore the amount needed to get the bonus
   */
  public void addBonus(int reqScore) {
    if (scoreList[Constant.INDEX_OF_SUM] >= reqScore) {
      addScore(Constant.BONUS, Constant.INDEX_OF_BONUS);
    } else {
      addScore(0, Constant.INDEX_OF_BONUS);
    }
  }

  /**
   * This method adds all the index and stores the value in the last index(Total)
   */
  public void addTotal() {
    int totalIndex = scoreList.length - 1;
    int total = getScore(Constant.INDEX_OF_SUM) + getScore(Constant.INDEX_OF_BONUS);
    for (int i = Constant.INDEX_OF_BONUS + 1; i < totalIndex; i++) {
      total += getScore(i);
    }
    addScore(total, totalIndex);
  }

  /**
   * Checks after the first empty index in the scoreList
   *
   * @return the first empty score index
   */
  public int getFirstEmptyScoreIndex() {
    for (int i = 0; i < scoreList.length; i++) {
      if (getScore(i) == null) {
        return i;
      }
    }
    return scoreList.length;
  }

  /**
   * Checks if scoreList is empty at index
   *
   * @param index
   *
   * @return true if index is empty, false if its not empty
   */
  public boolean isEmpty(int index) {
    if (scoreList[index] == null) {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return getName();
  }

}
