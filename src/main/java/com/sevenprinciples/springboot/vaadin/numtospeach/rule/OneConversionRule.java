package com.sevenprinciples.springboot.vaadin.numtospeach.rule;

import com.sevenprinciples.springboot.vaadin.numtospeach.conversion.GroupNumberException;
import com.sevenprinciples.springboot.vaadin.numtospeach.conversion.SpokenNumber;

/**
 * Builds the spoken word for the 'one' position of the group number.
 * Created by joachim.kaesser on 15.01.2017.
 */
public class OneConversionRule extends GroupConversionBaseRule {

    @Override
    public String apply(Integer groupNumber) throws GroupNumberException {
        if (groupNumber == null) {
            throw new GroupNumberException("GroupNumber must not be null!");
        }

        StringBuilder result = new StringBuilder();
        result.append(super.apply(groupNumber));

        if (groupNumber.equals(0)) {
            result.append(SpokenNumber.getSpokenOf(0));
        } else {
            if (groupNumber.equals(11) || groupNumber.equals(12)) {
                return ""; // will be transformed by TenConversionRule
            }
            Integer one = groupNumber > 9 ? groupNumber % 10 : groupNumber;
            String spokenOfOne = SpokenNumber.getSpokenOf(one);
            
            if (groupNumber <= 9) {
                spokenOfOne = capitalize(spokenOfOne);
            }
            result.append(spokenOfOne);

            Boolean tenIsZero = Integer.toString(groupNumber / 10).endsWith("0");
            if (tenIsZero && one.equals(1)) {
                result.append("s");
            }
            
        }

        return result.toString();
    }

    private String capitalize(String spokenOfOne) {
        StringBuffer capitalized = new StringBuffer();
        capitalized.append(spokenOfOne.substring(0,1).toUpperCase()).append(spokenOfOne.substring(1, spokenOfOne.length()));
        return capitalized.toString();
    }
    
}
