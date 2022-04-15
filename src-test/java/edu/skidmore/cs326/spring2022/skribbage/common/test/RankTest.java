package edu.skidmore.cs326.spring2022.skribbage.common.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.Rank;

/**
 * Test class for Rank java bean.
 * 
 * @author Declan Morris
 */
public class RankTest {
    /**
     * Attribute to house the test instance to run tests on.
     */
    private Rank testInstance;

    /**
     * Instantiate the test instance.
     */
    @Before
    public void setup() {
        testInstance = Rank.JACK;
    }

    /**
     * Test the getName method.
     */
    @Test
    public void testGetName() {
        assertEquals(testInstance.getName(), "Jack");
    }

    /**
     * Test the getSymbol method.
     */
    @Test
    public void testGetSymbol() {
        assertEquals(testInstance.getSymbol(), "J");
    }

    /**
     * Test the getPointValue method.
     */
    @Test
    public void testGetPointValue() {
        assertEquals(testInstance.getPointValue(), 10);
    }
}
