package com.sevenprinciples.springboot.vaadin.numtospeach.conversion;

/**
 * Created by joachim.kaesser on 14.01.2017.
 */
public class GroupToSpeech {

    /**
     * Converts a groupNumber of one to three digits into german speech.
     *
     * @param groupNumber the part of a number with length of 1 to 3 to be converted to speech
     * @return the given number groupNumber as a string in speech
     * @throws GroupNumberException if the groupNumber string lenght is illegal
     */
    public String toSpeech(Integer groupNumber) throws GroupNumberException {
        return null;
    }
}
