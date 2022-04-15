package edu.skidmore.cs326.spring2022.skribbage.logic.test;

import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.logic.Player;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import edu.skidmore.cs326.spring2022.skribbage.logic.Card;
import edu.skidmore.cs326.spring2022.skribbage.logic.Hand;

/**
 * Test class for player.
 * 
 * @author lappiaha
 */
public class TestPlayer {
    /**
     * Tests instance for the player class.
     */
    private Player testInstance;

    /**
     * Card instance to refer to methods in the card class.
     */
    private Card c;

    /**
     * Hand instance to refer to methods in the hand class.
     */
    private Hand h;

    /**
     * Setup for the Player testing.
     */
    @Before
    public void setup() {
        /**
         * test instance for set name.
         */
        testInstance.setName("abby");
        /**
         * card instance to test.
         */
        c = new Card('J', Suit.HEARTS);
        /**
         * add card to hand for player hand.
         */
        h.addCardToHand(c);
        /**
         * set the player hand.
         */
        testInstance.setHand(h);
        /**
         * test instance to get point. 
         */
        testInstance.getPoints(2);
    }

    /**
     * Test getName method.
     */
    @Test
    public void testGetName() {
        assertEquals("abby", testInstance.getName());
    }

    /**
     * Test setHand method.
     */
    @Test
    public void testSetHand() {
        assertEquals(h, testInstance.setHand());
    }
    /**
     * Test getPoints method.
     */
    @Test
    public void testGetPoints() {
        assertEquals(2, testInstance.getPoints());
    }

}