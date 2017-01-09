package com.jensen.yatzy.util;

import java.util.Random;

/**
 * Utility class that can generate random integer values.
 *
 * @author Benjamin Rosman
 *
 */
public final class Randomizer {

  private Randomizer() {
  }

  /**
   * Generates a random integer from zero to max. Both are inclusive.
   *
   * @param max The maximum number to be generated.
   *
   * @return A random number from zero (inclusive) to max (inclusive).
   */
  public static int getInt(int max) {
    Random rGen = new Random();
    return rGen.nextInt(max + 1);
  }

  /**
   * Generates a random number from lowerLimit to upperLimit. Both are inclusive.
   *
   * @param lowerLimit The minimum number to be generated, is inclusive.
   * @param upperLimit The maximum number to be generated, is inclusive.
   *
   * @return A random number between lowerLimit and upperLimit.
   */
  public static int getInt(int lowerLimit, int upperLimit) {
    return lowerLimit + getInt(upperLimit - lowerLimit);
  }

}
