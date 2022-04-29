package edu.skidmore.cs326.spring2022.skribbage.logic.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.Hand;
import edu.skidmore.cs326.spring2022.skribbage.common.Rank;
import edu.skidmore.cs326.spring2022.skribbage.common.Suit;
import edu.skidmore.cs326.spring2022.skribbage.logic.HandManager;

/**
 * Test add and remove card methods in Hand Manager.
 * 
 * @author Dorjee W.
 */
public class TestHandManager {

    /**
     * Hand object that will be accessed to test HandManager methods.
     */
    private Hand hand;

    /**
     * Manipulate Hand data.
     */
    private HandManager handManager;

    /**
     * Initialize Hand and HandManger.
     */
    @Before
    public void setup() {
        // initialize the hand and HandManager
        hand = new Hand();
        handManager = new HandManager();

    }

    /**
     * Tests method to add a card to hand.
     */
    @Test
    public void testAddCardToHand() {
        Card c = new Card(Rank.JACK, Suit.HEARTS);
        handManager.addCardToHand(hand, c);
        assertEquals(hand.getCardsInHand().length, 1);

    }
    /**
     * Tests method to remove a Card from hand. 
     */
    @Test
    public void testRemoveCardFromHand() {
        Card c = new Card(Rank.JACK, Suit.HEARTS);
        handManager.addCardToHand(hand, c);
        Card cardRemoved = handManager.removeCardFromHand(hand, c);
        assertEquals(c, cardRemoved);


    }
}
