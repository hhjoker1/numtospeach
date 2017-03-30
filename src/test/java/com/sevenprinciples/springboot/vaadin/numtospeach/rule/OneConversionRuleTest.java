package com.sevenprinciples.springboot.vaadin.numtospeach.rule;

import com.sevenprinciples.springboot.vaadin.numtospeach.conversion.GroupNumberException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Parameterized test for the 'one conversion rule'.
 * @author jka
 * Created by joachim.kaesser on 15.01.2017.
 */
@RunWith(Parameterized.class)
public class OneConversionRuleTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     * The group number parameter.
     */
    private String groupNumber;

    /**
     * The expected result parameter.
     */
    private String expectedResult;

    /**
     * The class of the expected exception.
     */
    private Class<Exception> expectedExceptionClazz;

    /**
     * Constructor
     * @param groupNumber the group number
     * @param expectedResult the excpected result
     * @param expectedExceptionClazz the excpected exception
     */
    public OneConversionRuleTest(String groupNumber, String expectedResult, Class<Exception> expectedExceptionClazz) {
        this.groupNumber = groupNumber;
        this.expectedResult = expectedResult;
        this.expectedExceptionClazz = expectedExceptionClazz;
    }

    /**
     * Method providing the test data as two-dimensional array.
     * @return the test data matrix
     */
    @Parameterized.Parameters(name= "{index}: number: {0} spoken: {1} exception: {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        // regular cases
                        {"0", "Null", null},
                        {"1", "Eins", null},
                        {"11", "", null}, // 'elf' will be provided by the 'TenConversionRule' instance
                        {"12", "", null}, // 'zwölf' will be provided by the 'TenConversionRule' instance
                        {"101", "eins", null},
                        {"21", "ein", null},
                        {"2", "Zwei", null},
                        {"3", "Drei", null},
                        {"4", "Vier", null},
                        {"5", "Fünf", null},
                        {"6", "Sechs", null},
                        {"7", "Sieben", null},
                        {"8", "Acht", null},
                        {"9", "Neun", null},

                        // exceptional cases
                        {"", null, GroupNumberException.class},
                        {"a", null, GroupNumberException.class},
                        {"ab", null, GroupNumberException.class},
                        {"abc", null, GroupNumberException.class},
                        {"1a", null, GroupNumberException.class},
                        {"b2", null, GroupNumberException.class},
                        {"-1", null, GroupNumberException.class},
                        {null, null, GroupNumberException.class},
                        {"1000", null, GroupNumberException.class},
                }
        );
    }

    /**
     * Class under test.
     */
    private OneConversionRule conversionRule;

    @Before
    public void setUp() throws Exception {
        conversionRule = new OneConversionRule();
    }

    @After
    public void tearDown() throws Exception {
        conversionRule = null;
    }

    @Test
    public void apply() throws Exception {
        if (expectedExceptionClazz != null) {
            expectedException.expect(expectedExceptionClazz);
        }

        String result = conversionRule.apply(groupNumber);
        assertThat("Unexpected conversion result.", result, is(expectedResult));
    }

}