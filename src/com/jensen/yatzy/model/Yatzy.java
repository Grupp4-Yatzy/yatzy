package com.jensen.yatzy.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Holds the state of a yatzy game, which include the dices, all the players, whos turn it is and
 * how many rolls he has left. Also includes some game logic such as calculating points and
 * switching player.
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
   * Creates a Yatzy object with the default number of dices constant.
   *
   * @see Constant#DEFUALT_NUMBER_OF_DICES
   */
  public Yatzy() {
    dices = new Dice[Constant.DEFUALT_NUMBER_OF_DICES];
    for (int i = 0; i < dices.length; i++) {
      dices[i] = new Dice();
    }
  }

  /**
   * Returns the array of dices.
   *
   * @return The array holding the dices.
   */
  public Dice[] getDices() {
    return dices;
  }

  /**
   * Returns the current player. If there is no currentPlayer the method returns the first player.
   *
   * @return The current player whos turn it is.
   */
  public Player getCurrentPlayer() {
    if (currentPlayer == null) {
      currentPlayer = players.get(0);
    }
    return currentPlayer;
  }

  /**
   * Returns the index of the player.
   *
   * @param player The player whos index is returned.
   *
   * @return The index of player.
   */
  public int getPlayerIndex(Player player) {
    return players.indexOf(player);
  }

  /**
   * Returns the number of rolls the current player has left.
   *
   * @return The number of rolls left.
   */
  public int getNumbersOfRollsLeft() {
    return this.numberOfRollsLeft;
  }

  /**
   * Decreases number of rolls left by one.
   */
  public void decreaseRolls() {
    this.numberOfRollsLeft -= 1;
  }

  /**
   * Changes to the next player and gives him three rolls.
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
   * Adds several players to the game by creating a new player for each name in names and adding
   * them to the list of players.
   *
   * @param names The names of the players to be created and added to the players list.
   */
  public void addPlayers(String[] names) {
    for (String name : names) {
      players.add(new Player(name));
    }
  }

  /**
   * Returns the sum of all the dices.
   *
   * @return The sum of all the dices.
   */
  public int sum() {
    int sum = 0;
    for (Dice dice : dices) {
      sum += dice.getValue();
    }
    return sum;
  }

  /**
   * Return the sum of all dices which has a value matching number. Given one as number it will
   * return the sum of all the ones.
   *
   * @param number The dice value to be summed.
   *
   * @return The sum of all dices which has a value matching number.
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
   * Returns the sum of the highest pair.
   *
   * @return the sum of the highest pair or zero if no pair is found.
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
   * Checks if there is a second pair of dices seperate from the highest pair. If so it returns the
   * sum of the two pairs otherwise it returns zero.
   *
   * @return the sum of two pair or zero if there aren't two pairs.
   */
  public int twoPair() {
    int highestPair = onePair();
    int sum;
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
   * Returns the score recieved for a number of a kind, where number is the amount of equal dices
   * needed to revieve a score. Given four it will check for four of a kind and return four
   * multiplied by the value of a dice that has four or more of a kind. If there aren't four four a
   * kind it returns zero.
   *
   * @param number The number of equal dices required for scoring.
   *
   * @return The score that can be recieved with the current dices.
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
   * Checks for a fullhouse.
   * 
   * @return The sum of all dices if it's a fullhouse otherwise zero.
   */
  public int fullHouse() {
    Set set = new HashSet();
    for (Dice dice : dices) {
      set.add(dice.getValue());
    }
    if (set.size() == 2) {
      int value = dices[0].getValue();
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
