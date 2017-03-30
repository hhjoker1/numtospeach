package com.sevenprinciples.springboot.vaadin.numtospeach.conversion;

/**
 * Postfix to be appended to a group number in german language.
 *
 * This application uses the 'long ladder' system as usual in most european countries,
 * hence the enumeration constants all have german names.
 *
 * Created by joachim.kaesser on 14.01.2017.
 */
public enum GroupPostFix {
    TAUSEND (1, "tausend", ""),
    MILLION (2, "million", "en"),
    MILLIARDE (3, "milliarde", "n"),
    BILLION (4, "billion", "en"),
    BILLIARDE (5, "billiarde", "n"),
    TRILLION (6, "trillion", "en"),
    TRILLIARDE (7, "trilliarde", "n"),
    QUADRILLION (8, "quadrillion", "en"),
    QUADRILLIARDE (9, "quadrilliarde", "en"),
    QUINTILLION (10, "quintillion", "en"),
    QUINTILLIARDE (11, "quintilliarde", "n"),
    SEXTILLION (12, "sextillion", "en"),
    SEXTILLIARDE (13, "sextillarde", "n"),
    SEPTILLION (14, "septillion", "en"),
    SEPTILLIARDE (15, "septilliarde", "n"),
    OKTILLION (16, "oktillion", "en"),
    OKTILLIARDE (17, "oktilliarde", "n"),
    NONILLION (18, "nonillion", "en"),
    NONILLIARDE (19, "nonilliarde", "n"),
    DEZILLION (20, "dezillion", "en"),
    DEZILLIARDE (21, "dezilliarde", "n");

    /**
     * The group index to determine the position of the group postfix inside the spoken number.
     */
    private final int groupIndex;

    /**
     * The spoken word of the group postifx in german language.
     */
    private final String spoken;

    /**
     * An additional postfix, if we must use the plural case.
     */
    private final String pluralPostfix;

    /**
     * Constructor taking the groupIndex, spoken text an an additional plural extension.
     * @param groupIndex the group index
     * @param spoken the string in spoken language
     * @param pluralPostfix the plural postfix
     */
    GroupPostFix(int groupIndex, String spoken, String pluralPostfix) {
        this.groupIndex = groupIndex;
        this.spoken = spoken;
        this.pluralPostfix = pluralPostfix;
    }

    /**
     * Gets the index of the group.
     * @return the groupIndex
     */
    public int getGroupIndex() {
        return groupIndex;
    }

    /**
     * Gets the spoken word in german language
     * @return the spoken
     */
    public String getSpoken() {
        return spoken;
    }

    /**
     * Gets the postfix to be used in the plural case.
     * @return the pluralPostfix
     */
    public String getPluralPostfix() {
        return pluralPostfix;
    }
}
