package edu.skidmore.cs326.spring2022.skribbage.common.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.Suit;

/**
 * Test class for Suit java bean.
 * 
 * @author Declan Morris
 */
public class SuitTest {
    
    /**
     * Attribute to house the test instance to run tests on.
     */
    private Suit testInstance;
    
    /**
     * Instantiate the test instance.
     */
    @Before
    public void setup() {
        testInstance = Suit.DIAMONDS;
    }
    
    /**
     * Test the getName method.
     */
    @Test
    public void testGetName() {
        assertEquals(testInstance.getName(), "Diamonds");
    }

}
