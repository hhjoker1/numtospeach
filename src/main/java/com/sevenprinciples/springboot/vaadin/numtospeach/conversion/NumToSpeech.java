package com.sevenprinciples.springboot.vaadin.numtospeach.conversion;

/**
 * Created by joachim.kaesser on 14.01.2017.
 */
public class NumToSpeech {

    /**
     * Converts a String of arbitrary length to german speech.
     * The String must contain only the digits 0 to 9.
     * The delimiter character '.' will be filtered out.
     * All other characters will cause a {@link NumberFormatException}
     *
     * @param strNumber the Number as a String to be converted to speech
     * @return the String in spoken german words (the speech)
     * @throws NumberFormatException thrown if the number contains illegal characters
     */
    public String toSpeech(String strNumber) throws NumberFormatException {
        return null;
    }

}
