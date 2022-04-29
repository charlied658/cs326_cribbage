package edu.skidmore.cs326.spring2022.skribbage.common.test;

import static org.junit.Assert.assertEquals;

import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.Hand;
import edu.skidmore.cs326.spring2022.skribbage.common.Rank;
import edu.skidmore.cs326.spring2022.skribbage.common.Suit;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit Tests for Hand Class.
 * 
 * @author Dorjee
 */
public class HandTest {
    /**
     * Attribute to house the test instance.
     */
    private Hand testInstance;

    /**
     * Test scaffold set up. Creates the test instance.
     */
    @Before
    public void setup() {
        testInstance = new Hand();
    }

    /**
     * Test the method to add a card to hand.
     */
    @Test
    public void testAddCard() {
        Card card = new Card(Rank.NINE, Suit.HEARTS);
        testInstance.addCard(card);
        Card[] testHand = testInstance.getCardsInHand();
        assertEquals(testHand.length, 1);
    }

    /**
     * Test the method to add a card to hand.
     */
    @Test
    public void testRemoveCard() {
        Card card = new Card(Rank.KING, Suit.HEARTS);
        Card card1 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        testInstance.addCard(card);
        testInstance.addCard(card1);
        assertEquals(card1, testInstance.removeCard(card1));

    }
}
