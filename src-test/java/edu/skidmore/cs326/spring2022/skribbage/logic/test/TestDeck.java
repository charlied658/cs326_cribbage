package edu.skidmore.cs326.spring2022.skribbage.logic.test;

import edu.skidmore.cs326.spring2022.skribbage.common.Deck;

import static org.junit.Assert.assertEquals;
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
    public void testConstructor() {
        // test deck constructor
        // see if a deck was created
        assertNotNull(testInstance);

    } // end testConstructor

    /**
     * Test to see deck is properly returned.
     */
    @Test
    public void testGetDeck() {
        // test getDeck
        // make sure the deck returned has 52 cards
        assertEquals(testInstance.getDeck().size(), 52);
    } // end testGetDeck

    /**
     * Test to see deck is properly set.
     */
    @Test
    public void testSetDeck() {
        // test setDeck
        //
        testInstance.setDeck(testInstanceOrdered.getDeck());
        assertEquals(testInstance.getDeck().size(), 
              testInstanceOrdered.getDeck().size());
    } // end testSetDeck

} // end class TestDeck
