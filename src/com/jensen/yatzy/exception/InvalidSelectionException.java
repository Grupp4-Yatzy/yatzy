package com.jensen.yatzy.exception;

/**
 * This class inherits from the super class Exception and is created to take care of user input that
 * is not valid.
 *
 * @author Benjamin Rosman, Roberto Blanco, Kami Hazzansadeh, Robin Nilsson
 */
public class InvalidSelectionException extends Exception {

  /**
   * Creates a new instance of <code>InvalidSelection</code> without detail message.
   */
  public InvalidSelectionException() {
  }

  /**
   * Constructs an instance of <code>InvalidSelection</code> with the specified detail message.
   *
   * @param msg the detail message.
   */
  public InvalidSelectionException(String msg) {
    super(msg);
  }
}
