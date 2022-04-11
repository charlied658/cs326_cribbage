package edu.skidmore.cs326.spring2022.skribbage.common.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.Suit;
import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.Rank;

/**
 * Test class for Card java bean.
 * 
 * @author Declan Morris
 *
 */
public class CardTest {
    /**
     * Attribute to house the test instance.
     */
    private Card testInstance;

    /**
     * Test scaffold set up. Creates the test instance.
     */
    @Before
    public void setup() {
        testInstance = new Card(Rank.ACE, Suit.HEARTS);
    }

    /**
     * Test that the setSuit method worked as expected during the constructor
     * call.
     */
    @Test
    public void testSetSuit() {
        assertEquals(Suit.HEARTS, testInstance.getSuit());
    }
    
    /**
     * Test that the setRank method worked as expected in the instructor.
     */
    @Test
    public void testSetRank() {
        assertEquals(Rank.ACE, testInstance.getRank());
    }
}
