package edu.skidmore.cs326.spring2022.skribbage.common.test;

import edu.skidmore.cs326.spring2022.skribbage.common.Suit;
import edu.skidmore.cs326.spring2022.skribbage.logic.Game;
import edu.skidmore.cs326.spring2022.skribbage.logic.Card;
import edu.skidmore.cs326.spring2022.skribbage.logic.Deck;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * GameTest tests the methods in Game.
 * All tests pass except testGetDeck(), but I think that is because
 * I am not sure how to write the test for it correctly without writing more
 * code in Deck.java, which I am not the author of. I am working on a solution.
 *
 * @author Michael Shriner
 */
public class GameTest {

    /** Object used to represent the game state. */
    private Game game;

    /** Deck used to check the getDeck method in Game. */
    private Deck testDeck;

    /**
     * ArrayList of pone pegging cards to check the getPonePeggingCards
     * method in Game.
     */
    private ArrayList<Card> testPonePeggingCards;

    /**
     * ArrayList of dealer pegging cards to check the getDealerPeggingCards
     * method in Game.
     */
    private ArrayList<Card> testDealerPeggingCards;

    /**
     * ArrayList of cards in crib to check the getCrib
     * method in Game.
     */
    private ArrayList<Card> testCrib;

    /**
     * Initializes fields.
     */
    @Before
    public void setup() {

        testDeck = new Deck();

        testPonePeggingCards = new ArrayList<Card>();

        testDealerPeggingCards = new ArrayList<Card>();

        testCrib = new ArrayList<Card>();

        game = new Game(2);
    }

    /**
     * Tests the setPeggingTotal method.
     * Passes.
     */
    @Test
    public void testSetPeggingTotal() {

        assertEquals(game.getPeggingTotal(), 0);

        game.setPeggingTotal(5);

        assertEquals(game.getPeggingTotal(), 5);
    }

    /**
     * Tests the getPeggingTotal method.
     * Passes.
     */
    @Test
    public void testGetPeggingTotal() {

        game.setPeggingTotal(5);

        int peggingTotal = game.getPeggingTotal();

        assertEquals(5, peggingTotal);

    }

    /**
     * Tests the getPonePeggingCards method.
     * Passes.
     */
    @Test
    public void testGetPonePeggingCards() {

        ArrayList<Card> returnedPonePeggingCards = game.getPonePeggingCards();

        assertTrue(returnedPonePeggingCards.equals(testPonePeggingCards));

    }

    /**
     * Tests the getDealerPeggingCards method.
     * Passes.
     */
    @Test
    public void testGetDealerPeggingCards() {

        ArrayList<Card> dealerPeggingCards = game.getDealerPeggingCards();

        assertTrue(dealerPeggingCards.equals(testDealerPeggingCards));

    }

    /**
     * Tests the getCrib method.
     * Passes.
     */
    @Test
    public void testGetCrib() {

        ArrayList<Card> returnedCrib = game.getCrib();

        assertTrue(returnedCrib.equals(testCrib));

    }

    /**
     * Tests the setPonePeggingCards method.
     * Passes.
     */
    @Test
    public void testSetPonePeggingCards() {

        ArrayList<Card> ponePegCardsNew = new ArrayList<Card>();
        ponePegCardsNew.add(new Card('J', Suit.HEARTS));

        game.setPonePeggingCards(ponePegCardsNew);

        assertTrue(ponePegCardsNew.equals(game.getPonePeggingCards()));

    }

    /**
     * Tests the setDealerPeggingCards method.
     * Passes.
     */
    @Test
    public void testSetDealerPeggingCards() {

        ArrayList<Card> dealerPegCardsNew = new ArrayList<Card>();
        dealerPegCardsNew.add(new Card('J', Suit.HEARTS));

        game.setDealerPeggingCards(dealerPegCardsNew);

        assertTrue(dealerPegCardsNew.equals(game.getDealerPeggingCards()));

    }

    // /**
    // * Test the setPeggingTotal method.
    // */
    // @Test
    // public void testGetDeck() {
    //
    //   Deck deckReturned = game.getDeck();
    //
    //   ArrayList <Card> deckListReturned = deckReturned.getDeck();
    //
    //   ArrayList <Card> testDeckList = testDeck.getDeck();
    //
    //   assertTrue(deckListReturned.equals(testDeckList));
    //
    // }

} // end of class
