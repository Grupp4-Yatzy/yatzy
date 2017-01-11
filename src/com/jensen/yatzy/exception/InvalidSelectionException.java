package com.jensen.yatzy.exception;

/**
 * Exception that is thrown when a user has made an invalid selection.
 *
 * @author Benjamin Rosman, Roberto Blanco, Kami Hazzansadeh, Robin Nilsson
 */
public class InvalidSelectionException extends Exception {

  /**
   * Constructs an instance of <code>InvalidSelection</code> with the specified detail message.
   *
   * @param msg the detail message.
   */
  public InvalidSelectionException(String msg) {
    super(msg);
  }
}
