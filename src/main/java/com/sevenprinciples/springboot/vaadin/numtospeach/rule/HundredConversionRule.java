package com.sevenprinciples.springboot.vaadin.numtospeach.rule;

import com.sevenprinciples.springboot.vaadin.numtospeach.conversion.GroupNumberException;
import com.sevenprinciples.springboot.vaadin.numtospeach.conversion.SpokenNumber;

/**
 * Builds the spoken word for the 'hundred' position of the group number.
 *
 * Created by joachim.kaesser on 15.01.2017.
 */
public class HundredConversionRule extends GroupConversionBaseRule {
    @Override
    public String apply(String groupNumber) throws GroupNumberException {
        StringBuilder result = new StringBuilder();
        result.append(super.apply(groupNumber));

        Integer groupNum;
        try {
            groupNum = Integer.parseInt(groupNumber);
        } catch (NumberFormatException e) {
            throw new GroupNumberException("", e);
        }

        if (groupNum > 99) {
            final int hundred = groupNum / 100;
            result.append(SpokenNumber.getSpokenOf(hundred));
            result.append(SpokenNumber.getSpokenOf(100));
        }

        return result.toString();
    }
}
