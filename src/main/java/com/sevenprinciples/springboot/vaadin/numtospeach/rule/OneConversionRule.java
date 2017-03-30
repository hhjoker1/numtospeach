package com.sevenprinciples.springboot.vaadin.numtospeach.rule;

import com.sevenprinciples.springboot.vaadin.numtospeach.conversion.GroupNumberException;
import com.sevenprinciples.springboot.vaadin.numtospeach.conversion.SpokenNumber;

/**
 * Builds the spoken word for the 'one' position of the group number.
 * Created by joachim.kaesser on 15.01.2017.
 */
public class OneConversionRule extends GroupConversionBaseRule {

    @Override
    public String apply(String groupNumber) throws GroupNumberException {


        StringBuilder result = new StringBuilder();
        result.append(super.apply(groupNumber));

        Integer groupNum = parseGroupNumber(groupNumber);

        if (groupNum.equals(0)) {
            result.append(SpokenNumber.getSpokenOf(0));
        } else {
            if (groupNum.equals(11) || groupNum.equals(12)) {
                return ""; // will be transformed by TenConversionRule
            }
            Integer one = groupNum > 9 ? groupNum % 10 : groupNum;
            String spokenOfOne = SpokenNumber.getSpokenOf(one);
            
            if (groupNum <= 9) {
                spokenOfOne = capitalize(spokenOfOne);
            }
            result.append(spokenOfOne);

            Boolean tenIsZero = Integer.toString(groupNum / 10).endsWith("0");
            if (tenIsZero && one.equals(1)) {
                result.append("s");
            }
            
        }

        return result.toString();
    }

    private String capitalize(String spokenOfOne) {
        return ""
                + spokenOfOne.substring(0,1).toUpperCase()
                + spokenOfOne.substring(1, spokenOfOne.length());
    }
    
}
