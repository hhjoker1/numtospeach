package com.sevenprinciples.springboot.vaadin.numtospeach.rule;

import com.sevenprinciples.springboot.vaadin.numtospeach.conversion.GroupNumberException;

/**
 * Base rule for group conversion.
 * @author jka
 * Created by joachim.kaesser on 15.01.2017.
 */
public class GroupConversionBaseRule implements GroupConversionRule {

    private static final int MAX_GROUP_NUMBER = 999;

    @Override
    public String apply(String groupNumber) throws GroupNumberException {
        if (groupNumber == null) {
            throw new GroupNumberException("GroupNumber must not be null.");
        }

        Integer groupNum = parseGroupNumber(groupNumber);

        if (Integer.signum(groupNum) < 0) {
            throw new GroupNumberException("No negative group numbers allowed.");
        }

        if (groupNum.compareTo(MAX_GROUP_NUMBER) > 0) {
            throw new GroupNumberException("Value exceeds maximum group number of " + MAX_GROUP_NUMBER);
        }

        return "";
    }

    Integer parseGroupNumber(String groupNumber) throws GroupNumberException {
        Integer groupNum;
        try {
            groupNum = Integer.parseInt(groupNumber);
        } catch (NumberFormatException e) {
            throw new GroupNumberException("GroupNumber can not be parsed to a number.", e);
        }
        return groupNum;
    }
}
