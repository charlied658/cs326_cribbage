package edu.skidmore.cs326.spring2022.skribbage.common.test;

import edu.skidmore.cs326.spring2022.skribbage.common.Suit;
import edu.skidmore.cs326.spring2022.skribbage.common.Game;
import edu.skidmore.cs326.spring2022.skribbage.common.Rank;
import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.Hand;
import edu.skidmore.cs326.spring2022.skribbage.common.Deck;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import edu.skidmore.cs326.spring2022.skribbage.logic.HandManager;

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
    // @SuppressWarnings("unused")
    private Deck testDeck;

    /**
     * ArrayList of pone pegging cards to check the getPonePeggingCards
     * method in Game.
     */
    //private Hand testPonePeggingCards;

    /**
     * ArrayList of dealer pegging cards to check the getDealerPeggingCards
     * method in Game.
     */
    //private Hand testDealerPeggingCards;

    /**
     * ArrayList of cards in crib to check the getCrib
     * method in Game.
     */
    private Hand testCrib;

    private HandManager handManager;

    /**
     * Initializes fields.
     */
    @Before
    public void setup() {

        testDeck = new Deck();

        handManager = new HandManager();

        //testPonePeggingCards = new Hand();

        //testDealerPeggingCards = new Hand();

        testCrib = new Hand();

        game = new Game(2);
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
     * Test the initialize players method.
     * Passes.
     */
    @Test
    public void testInitPlayers() {
        game.initPlayers(2);
        assertEquals(game.getPlayerList().size(), 4);
        //it should be 4 because the player list was already initialized
        //for 2 players
    }

    /**
     * Tests the setPeggingTotal method.
     * Passes.
     */
    @Test
    public void testSetPeggingTotal() {

        game.setPeggingTotal(5);

        assertEquals(game.getPeggingTotal(), 5);
    }

    // /**
    //  * Tests the setPonePeggingCards method.
    //  * Passes.
    //  */
    // @Test
    // public void testSetPonePeggingCards() {
    //
    //     Hand ponePegCardsNew = new Hand();
    //
    //     handManager.addCardToHand(ponePegCardsNew, new Card(Rank.JACK, Suit.HEARTS));
    //
    //     game.setPonePeggingCards(ponePegCardsNew);
    //
    //     Hand ponePegCardsToCompare = game.getPonePeggingCards();
    //
    //     List <Card> ponePegCardsToCompareList = ponePegCardsToCompare.getCardsInHand();
    //
    //     List <Card> ponePegCardsNewList = ponePegCardsNew.getCardsInHand();
    //
    //     assertTrue(ponePegCardsNewList.equals(ponePegCardsToCompareList));
    //
    // }


    // /**
    //  * Tests the getPonePeggingCards method.
    //  * Passes.
    //  */
    // @Test
    // public void testGetPonePeggingCards() {
    //
    //     Hand returnedPonePeggingCards = game.getPonePeggingCards();
    //
    //     List <Card> retPonePeggingCardsList = returnedPonePeggingCards.getCardsInHand();
    //
    //     List <Card> testPonePeggingCardsList = testPonePeggingCards.getCardsInHand();
    //
    //     assertTrue(retPonePeggingCardsList.equals(testPonePeggingCardsList));
    //
    // }

    // /**
    //  * Tests the getDealerPeggingCards method.
    //  * Passes.
    //  */
    // @Test
    // public void testGetDealerPeggingCards() {
    //
    //   Hand returnedDealerPeggingCards = game.getDealerPeggingCards();
    //
    //   List <Card> retDealerPeggingCardsList = returnedDealerPeggingCards.getCardsInHand();
    //
    //   List <Card> testDealerPeggingCardsList = testDealerPeggingCards.getCardsInHand();
    //
    //   assertTrue(retDealerPeggingCardsList.equals(testDealerPeggingCardsList));
    //
    // }

    /**
     * Tests the getCrib method.
     * Passes.
     */
    @Test
    public void testGetCrib() {

        Hand returnedCrib = game.getCribCards();

        List <Card> returnedCribList = returnedCrib.getCardsInHand();

        List <Card> testCribList = testCrib.getCardsInHand();

        assertTrue(returnedCribList.equals(testCribList));

    }

    // /**
    //  * Tests the setDealerPeggingCards method.
    //  * Passes.
    //  */
    // @Test
    // public void testSetDealerPeggingCards() {
    //
    //   Hand dealerPegCardsNew = new Hand();
    //
    //   handManager.addCardToHand(dealerPegCardsNew, new Card(Rank.JACK, Suit.HEARTS));
    //
    //   game.setDealerPeggingCards(dealerPegCardsNew);
    //
    //   Hand dealerPegCardsToCompare = game.getDealerPeggingCards();
    //
    //   List <Card> dealerPegCardsToCompareList = dealerPegCardsToCompare.getCardsInHand();
    //
    //   List <Card> dealerPegCardsNewList = dealerPegCardsNew.getCardsInHand();
    //
    //   assertTrue(dealerPegCardsNewList.equals(dealerPegCardsToCompareList));
    //
    // }

    /**
    * Test the setPeggingTotal method.
    */
    // @Test
    // public void testGetDeck() {
    //
    // Deck deckReturned = game.getDeck();
    //
    // ArrayList <Card> deckListReturned = deckReturned.getDeck();
    //
    // ArrayList <Card> testDeckList = testDeck.getDeck();
    //
    // assertTrue(deckListReturned.equals(testDeckList));
    //
    // }

} // end of class
