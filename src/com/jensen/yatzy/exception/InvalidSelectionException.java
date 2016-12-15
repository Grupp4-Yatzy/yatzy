
package com.jensen.yatzy.exception;

/**
 *
 * @author RobertoBlanco
 */
public class InvalidSelectionException extends Exception {

    /**
     * Creates a new instance of <code>InvalidSelection</code> without detail
     * message.
     */
    public InvalidSelectionException() {
    }

    /**
     * Constructs an instance of <code>InvalidSelection</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidSelectionException(String msg) {
        super(msg);
    }
}
