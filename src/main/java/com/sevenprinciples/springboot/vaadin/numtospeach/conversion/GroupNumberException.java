package com.sevenprinciples.springboot.vaadin.numtospeach.conversion;

/**
 * Checked Exception to be thrown, if the Group Number
 * to be converted is negative or is larger than 999.
 *
 * Created by joachim.kaesser on 14.01.2017.
 */
public class GroupNumberException extends Exception {

    /**
     * Default constructor
     */
    public GroupNumberException() {
        super();
    }

    /**
     * Constructor taking a text message.
     * @param message the message describing the cause of the exception
     */
    public GroupNumberException(String message) {
        super(message);
    }

    /**
     * Constructor taking a message and a cause.
     * @param message the message describing the cause of the exception
     * @param cause the cause as a {@link Throwable}
     */
    public GroupNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
