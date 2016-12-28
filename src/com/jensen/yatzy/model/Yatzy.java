package com.jensen.yatzy.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Yatzy class holds the state of the game and check the points so they get filled in the right
 * combination index.
 *
 * @author Benjamin Rosman, Roberto Blanco, Kami Hazzansadeh, Robin Nilsson
 *
 */
public class Yatzy {

  private int numberOfRollsLeft = 3;
  private Dice[] dices;
  private ArrayList<Player> players = new ArrayList<>();
  private Player currentPlayer;

  /**
   * The constructor loops through the dice array and sets the default value of the dices
   */
  public Yatzy() {
    dices = new Dice[Constant.DEFUALT_NUMBER_OF_DICES];
    for (int i = 0; i < dices.length; i++) {
      dices[i] = new Dice();
    }
  }

  /**
   * Holds the array Dice
   *
   * @return dices in the array Dice[]
   */
  public Dice[] getDices() {
    return dices;
  }

  /**
   *
   * If there are no currentPlayer the method returns the first player in the list
   *
   * @return currentPlayer
   */
  public Player getCurrentPlayer() {
    if (currentPlayer == null) {
      currentPlayer = players.get(0);
    }
    return currentPlayer;
  }

  /**
   *
   * @param player
   *
   * @return an index of a player
   */
  public int getPlayerIndex(Player player) {
    return players.indexOf(player);
  }

  /**
   *
   * @return the number of rolls left
   */
  public int getNumbersOfRollsLeft() {
    return this.numberOfRollsLeft;
  }

  /**
   * decreases number of rolls with one each time you push the roll button
   */
  public void decreaseRolls() {
    this.numberOfRollsLeft -= 1;
  }

  /**
   * Changes to next player and give him three rolls
   *
   */
  public void nextPlayer() {
    int nextPlayerIndex = getPlayerIndex(getCurrentPlayer()) + 1;
    if (nextPlayerIndex == players.size()) {
      nextPlayerIndex = 0;
    }
    currentPlayer = players.get(nextPlayerIndex);
    this.numberOfRollsLeft = 3;
  }

  /**
   * Creates a list that stores names in it
   *
   * @param names
   */
  public void addPlayers(String[] names) {
    for (String name : names) {
      players.add(new Player(name));
    }
  }

  /**
   * Adds value of 5 dices(Chance combination)
   *
   * @return
   */
  public int sum() {
    int sum = 0;
    for (Dice dice : dices) {
      sum += dice.getValue();
    }
    return sum;
  }

  /**
   *
   * @param number, depends on which combination you choose
   *
   * @return the sum of value of the dices
   */
  public int sumNumber(int number) {
    int sum = 0;
    for (Dice dice : dices) {
      if (dice.getValue() == number) {
        sum += dice.getValue();
      }
    }
    return sum;
  }

  /**
   * Always takes the highest pair
   *
   * @return the sum of the highest pair
   */
  public int onePair() {
    int sum = 0;
    for (int i = 0; i < dices.length; i++) {
      int diceValue = dices[i].getValue();
      for (int nextDice = i + 1; nextDice < dices.length; nextDice++) {
        if (diceValue == dices[nextDice].getValue()) {
          int tempSum = diceValue * 2;
          if (tempSum > sum) {
            sum = tempSum;
            break;
          }
        }
      }
    }
    return sum;
  }

  /**
   * Checks after two pairs in the Dice array
   *
   * @return the sum of two pair
   *
   */
  public int twoPair() {
    int highestPair = onePair();
    int sum = 0;
    for (int i = 0; i < dices.length; i++) {
      int diceValue = dices[i].getValue();
      for (int nextDice = i + 1; nextDice < dices.length; nextDice++) {
        if (diceValue == dices[nextDice].getValue()) {
          sum = diceValue * 2;
          if (sum != highestPair) {
            return sum + highestPair;
          }
        }
      }
    }
    return 0;

  }

  /**
   * Checks after a three of a kind or four of a kind in the array
   *
   * @param number
   *
   * @return the sum of three of a kind and four of a kind
   */
  public int numberOfAKind(int number) {

    for (int s = 0; s < dices.length; s++) {
      int numberOfEqualDices = 1;
      int diceValue = dices[s].getValue();
      for (int nextDice = s + 1; nextDice < dices.length; nextDice++) {
        if (diceValue == dices[nextDice].getValue()) {
          numberOfEqualDices++;
        }
      }
      if (numberOfEqualDices >= number) {
        return number * diceValue;
      }
    }
    return 0;
  }

  /**
   * Checks after a fullhouse in the array
   *
   * @return the sum of a four dices(if its a Fullhouse)
   */
  public int fullHouse() {
    Set set = new HashSet();
    for (Dice dice : dices) {
      set.add(dice.getValue());
    }
    if (set.size() == 2) {
      Object[] values = set.toArray();
      int value = (Integer) values[0];
      int numberOf = sumNumber(value) / value;
      if (numberOf == 2 || numberOf == 3) {
        return sum();
      }
    }
    return 0;
  }

  /**
   * Looks after Yatzy(five dices with the same value)
   *
   * @return the sum of five dices
   */
  public int yatzy() {
    if (numberOfAKind(Constant.DEFUALT_NUMBER_OF_DICES) > 0) {
      return Constant.YATZY;
    }
    return 0;
  }

  /**
   * Checks after a small straight or a big straight(1-5, 2-6)
   *
   * @param number
   *
   * @return the sum of the two different straights
   */
  public int straight(int number) {
    Set set = new HashSet();
    for (Dice dice : dices) {
      set.add(dice.getValue());
    }
    if (set.size() == 5 && !set.contains(number)) {
      return sum();
    }
    return 0;
  }

  /**
   * Creates a two dimensional array that contains all the values, combinations and the player names
   *
   * @return the table
   */
  public Integer[][] createTable() {
    Integer[][] table = new Integer[Constant.COMBINATIONS.length][players.size()];
    for (int scoreIndex = 0; scoreIndex < table.length; scoreIndex++) {
      for (int playerIndex = 0; playerIndex < table[0].length; playerIndex++) {
        Integer score = players.get(playerIndex).getScore(scoreIndex);
        table[scoreIndex][playerIndex] = score;
      }
    }
    return table;
  }

  @Override
  public String toString() {
    String text = "Players: " + players + "\n"
        + "Current player: " + getCurrentPlayer() + "\n"
        + "Dices: " + Arrays.toString(dices) + "\n"
        + "number of rolls left: " + getNumbersOfRollsLeft() + "\n"
        + "ettor: " + sumNumber(1) + "\n"
        + "tvåor: " + sumNumber(2) + "\n"
        + "treor: " + sumNumber(3) + "\n"
        + "fyror: " + sumNumber(4) + "\n"
        + "femmor: " + sumNumber(5) + "\n"
        + "sexor: " + sumNumber(6) + "\n"
        + "---------------------" + "\n"
        + "par: " + onePair() + "\n"
        + "tvåpar: " + twoPair() + "\n"
        + "tretal: " + numberOfAKind(3) + "\n"
        + "fyrtal: " + numberOfAKind(4) + "\n"
        + "Liten stege: " + straight(6) + "\n"
        + "Stor stege: " + straight(1) + "\n"
        + "Kåk: " + fullHouse() + "\n"
        + "Chans: " + sum() + "\n"
        + "Yatzy: " + yatzy() + "\n"
        + "---------------------";
    return text;
  }

}
