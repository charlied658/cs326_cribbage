package edu.skidmore.cs326.spring2022.skribbage.logic.test;

import edu.skidmore.cs326.spring2022.skribbage.logic.Deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for Deck Class.
 */
public class TestDeck {
    /**
     * Deck instance to use in tests.
     */
    private Deck testInstance;

    /**
     * Ordered Deck instance to use in tests.
     */
    private Deck testInstanceOrdered;

    /**
     * Setup for the tests.
     */
    @Before
    public void setup() {
        testInstance = new Deck();
        testInstanceOrdered = new Deck();
    } // end setup

    /**
     * Test whether or not deck is created with 52 cards.
     */
    @Test
    public void testOne() {
        // test 1 deck constructor
        // see if there's 52 cards
        assertNotNull(testInstance);
        assertEquals(testInstance.getDeck().size(), 52);

    } // end testOne

    /**
     * Test if cards are shuffled.
     */
    @Test
    public void testTwo() {
        // test 2 shuffle
        // see if cards are in random order
        testInstance.shuffle();
        assertNotEquals(testInstance, testInstanceOrdered);

    } // end testTwo

    /**
     * Test if cut returns the right card.
     */
    @Test
    public void testThree() {
        // test 3 cut
        // make sure the returned card is the card of choice
        assertEquals(testInstance.cut(20), testInstance.getDeck().get(20));

    } // end testThree

    /**
     * Test if cards are in correct order.
     */
    @Test
    public void testFour() {
        // test 4 getDeck
        // print the order of both decks and make sure they're the same

    } // end testFour

    /**
     * Test to see if remove properly removes a card.
     */
    @Test
    public void testFive() {
        // test 5 remove top card
        // print the size and order, make sure the top card is BANISHED

    } // end testFive

    /**
     * Test to make sure card is moved to top.
     */
    @Test
    public void testSix() {
        // test 6 move to top
        // make sure the chosen card is in the correct place
        testInstance.moveToTop(20);
        assertEquals(testInstance, testInstance.getDeck().get(0));

    } // end testSix

} // end class TestDeck
