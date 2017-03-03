package com.sevenprinciples.springboot.vaadin.numtospeach.conversion;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by joachim.kaesser on 15.01.2017.
 */
@RunWith(Parameterized.class)
public class GroupToSpeechTest {

    /**
     * Junit {@link Rule} to be used
     * if the test case involves an expected exception.
     */
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     * The number to convert into spoken text as a {@link Integer} test parameter.
     */
    private Integer numberToConvert;

    /**
     * The expected result number as a {@link String} test parameter.
     */
    private String expectedResult;

    /**
     * The class of the expected exception as test parameter.
     */
    private Class<Exception> expectedExceptionClazz;

    /**
     * Class under test.
     */
    private GroupToSpeech groupToSpeech;

    /**
     * Constructor taking a group number as an {@link Integer},
     * an expected result as a {@link String}
     * and the class of the exception, if expected.
     *
     * @param numberToConvert the group number represented as an {@link Integer}
     * @param expectedResult the excpected result or null, if an {@link Exception} is expected
     * @param expectedExceptionClazz the excpected {@link Exception} class or null, if not expected
     */
    public GroupToSpeechTest(Integer numberToConvert, String expectedResult, Class<Exception> expectedExceptionClazz) {
        this.numberToConvert = numberToConvert;
        this.expectedResult = expectedResult;
        this.expectedExceptionClazz = expectedExceptionClazz;
    }

    /**
     * Method providing the test data as two-dimensional array.
     * @return the test data matrix
     */
    @Parameterized.Parameters(name= "{index}: number: {0} spoken: {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        // regular cases
                        {0, "Null", null},
                        {1, "Eins", null},
                        {2, "Zwei", null},
                        {3, "Drei", null},
                        {4, "Vier", null},
                        {5, "Fünf", null},
                        {6, "Sechs", null},
                        {7, "Sieben", null},
                        {8, "Acht", null},
                        {9, "Neun", null},
                        {10, "Zehn", null},
                        {11, "Elf", null},
                        {12, "Zwölf", null},
                        {13, "Dreizehn", null},
                        {14, "Vierzehn", null},
                        {15, "Fünfzehn", null},
                        {16, "Sechzehn", null},
                        {17, "Siebzehn", null},
                        {18, "Achtzehn", null},
                        {19, "Neunzehn", null},
                        {20, "Zwanzig", null},
                        {21, "Einundzwanzig", null},
                        {22, "Zweiundzwanzig", null},
                        {23, "Dreiundzwanzig", null},
                        {30, "Dreißig", null},
                        {40, "Vierzig", null},
                        {50, "Fünfzig", null},
                        {60, "Sechzig", null},
                        {70, "Siebzig", null},
                        {80, "Achtzig", null},
                        {90, "Neunzig", null},
                        {99, "Neunundneunzig", null},
                        {100, "Einhundert", null},
                        {101, "Einhunderteins", null},
                        {111, "Einhudertelf", null},
                        {112, "Einhuderzwölf", null},
                        {113, "Einhudertdreizehn", null},
                        {990, "Neunhundertneunzig", null},
                        {998, "Neunhundertachtundneunzig", null},
                        {999, "Neunhudertneunundneunzig", null},

                        // exceptional cases
                        {-1, null, GroupNumberException.class},
                        {-23, null, GroupNumberException.class},
                        {-999, null, GroupNumberException.class},
                        {1000, null, GroupNumberException.class},
                        {Integer.MIN_VALUE, null, GroupNumberException.class},
                        {Integer.MIN_VALUE +1, null, GroupNumberException.class},
                        {Integer.MAX_VALUE -1, null, GroupNumberException.class},
                        {null, null, GroupNumberException.class},
                }
        );
    }

    /**
     * Setup for the test case.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        groupToSpeech = new GroupToSpeech();
    }

    /**
     * Tears down the test case.
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        groupToSpeech = null;
    }

    /**
     * Performs the test case.
     * @throws Exception
     */
    @Test
    public void toSpeech() throws Exception {
        if (expectedExceptionClazz != null) {
            expectedException.expect(expectedExceptionClazz);
        }

        String result = groupToSpeech.toSpeech(numberToConvert);
        assertThat("Unexpected conversion result.", result, is(expectedResult));
    }

}