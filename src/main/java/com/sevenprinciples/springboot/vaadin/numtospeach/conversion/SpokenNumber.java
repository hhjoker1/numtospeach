package com.sevenprinciples.springboot.vaadin.numtospeach.conversion;

import java.util.HashMap;
import java.util.Map;

/**
 * Spoken number of digits inside a group number in german language.
 * Contains only those spoken words, that can't be
 * composed through a rule.
 *
 * Created by joachim.kaesser on 14.01.2017.
 */
public enum SpokenNumber {
    NULL (0, "Null"),
    EINS (1, "ein"),
    ZWEI (2, "zwei"),
    DREI (3, "drei"),
    VIER (4, "vier"),
    FUNEF (5, "fünf"),
    SECHS (6, "sechs"),
    SIEBEN (7, "sieben"),
    ACHT (8, "acht"),
    NEUN (9, "neun"),
    ZEHN (10, "zehn"),
    ELF (11, "elf"),
    ZWOELF (12, "zwölf"),
    HUNDERT (100, "hundert");

    private static final Map<Integer, SpokenNumber> spokenCache;

    static {
        spokenCache = new HashMap<>();
        spokenCache.put(NULL.getIndex(), NULL);
        spokenCache.put(EINS.getIndex(), EINS);
        spokenCache.put(ZWEI.getIndex(), ZWEI);
        spokenCache.put(DREI.getIndex(), DREI);
        spokenCache.put(VIER.getIndex(), VIER);
        spokenCache.put(FUNEF.getIndex(), FUNEF);
        spokenCache.put(SECHS.getIndex(), SECHS);
        spokenCache.put(SIEBEN.getIndex(), SIEBEN);
        spokenCache.put(ACHT.getIndex(), ACHT);
        spokenCache.put(NEUN.getIndex(), NEUN);
        spokenCache.put(ZEHN.getIndex(), ZEHN);
        spokenCache.put(ELF.getIndex(), ELF);
        spokenCache.put(ZWOELF.getIndex(), ZWOELF);
        spokenCache.put(HUNDERT.getIndex(), HUNDERT);
    }

    /**
     * The index of the spoken word.
     */
    private final int index;

    /**
     * The spoken word in german language.
     */
    private final String spoken;

    /**
     * Constructor taking an index and a spoken word.
     * @param index the index to retrieve the matching word.
     * @param spoken the spoken word in german language
     */
    SpokenNumber(int index, String spoken) {
        this.index = index;
        this.spoken = spoken;
    }

    /**
     * Returns the spoken german word of the enumeration constant
     * with the given index, or an empty {@link String} if the
     * constant was not found.
     *
     * @param index the index to be looked for
     * @return the spoken german word or an empty {@link String}
     */
    public static String getSpokenOf(int index) {
        SpokenNumber spokenNumber = spokenCache.get(index);
        return spokenNumber != null ? spokenNumber.getSpoken() : "";
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @return the spoken word in german language
     */
    public String getSpoken() {
        return spoken;
    }

}
