package com.sevenprinciples.springboot.vaadin.numtospeach.rule;

import com.sevenprinciples.springboot.vaadin.numtospeach.conversion.GroupNumberException;

import java.security.acl.Group;

/**
 * Created by joachim.kaesser on 15.01.2017.
 */
public class GroupConversionBaseRule implements GroupConversionRule {

    public static final int MAX_GROUP_NUMBER = 999;

    @Override
    public String apply(Integer groupNumber) throws GroupNumberException {

        if (Integer.signum(groupNumber) < 0) {
            throw new GroupNumberException("No negative group numbers allowed.");
        }

        if (groupNumber.compareTo(MAX_GROUP_NUMBER) > 0) {
            throw new GroupNumberException("Value exceeds maximum group number of " + MAX_GROUP_NUMBER);
        }

        return "";
    }
}
