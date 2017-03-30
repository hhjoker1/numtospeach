package com.sevenprinciples.springboot.vaadin.numtospeach.rule;

import com.sevenprinciples.springboot.vaadin.numtospeach.conversion.GroupNumberException;

/**
 * Rule Interface to be implemented by all conversion rules.
 *
 * Created by joachim.kaesser on 15.01.2017.
 */
public interface GroupConversionRule {
    /**
     * Applies the rule.
     * @param groupNumber the {@link String} number to apply the rule on
     * @return the resulting {@link String} value
     * @throws GroupNumberException if groupNumber doesn't follow conventions for group conversion
     */
    String apply(String groupNumber) throws GroupNumberException;

}
