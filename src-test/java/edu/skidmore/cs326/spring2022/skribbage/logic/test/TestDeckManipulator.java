package edu.skidmore.cs326.spring2022.skribbage.logic.test;

import edu.skidmore.cs326.spring2022.skribbage.common.Deck;
import edu.skidmore.cs326.spring2022.skribbage.logic.DeckManipulator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for Deck Class.
 */
public class TestDeckManipulator {
    /**
     * Deck instance to use in tests.
     */
    private Deck testInstance;

    /**
     * Ordered Deck instance to use in tests.
     */
    private Deck testInstanceOrdered;

    /**
     * Ordered Deck instance to use in tests.
     */
    private DeckManipulator manipulatorInstance;

    /**
     * Setup for the tests.
     */
    @Before
    public void setup() {
        testInstance = new Deck();
        testInstanceOrdered = new Deck();
        manipulatorInstance = new DeckManipulator();

    } // end setup

    /**
     * Test if cards are shuffled.
     */
    @Test
    public void testShuffle() {
        // test shuffle method
        // see if cards are in random order
        manipulatorInstance.shuffle(testInstance);
        assertNotEquals(testInstance, testInstanceOrdered);

    } // end testShuffle

    /**
     * Test if cut returns the right card.
     */
    @Test
    public void testCut() {
        // test cut method
        // make sure the returned card is the card of choice
        assertEquals(manipulatorInstance.cut(testInstance, 20),
            testInstance.getDeck().get(20));

    } // end testCut

    /**
     * Test to see if remove properly removes a card.
     */
    @Test
    public void testRemove() {
        // test remove top card method
        // compare a deck without the top card to a deck with the top card
        manipulatorInstance.removeTopCard(testInstance);
        assertNotEquals(testInstance, testInstanceOrdered);
    } // end testRemove

    /**
     * Test to make sure card is moved to top.
     */
    @Test
    public void testMove() {
        // test move to top method
        // make sure the chosen card is in the correct place
        manipulatorInstance.moveToTop(testInstance, 20);
        assertEquals(testInstance, testInstance.getDeck().get(0));

    } // end testMove

} // end class TestDeck
