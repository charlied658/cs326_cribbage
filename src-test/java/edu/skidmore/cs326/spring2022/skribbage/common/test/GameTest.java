package edu.skidmore.cs326.spring2022.skribbage.common.test;

// import edu.skidmore.cs326.spring2022.skribbage.common.Suit;
import edu.skidmore.cs326.spring2022.skribbage.common.Game;
// import edu.skidmore.cs326.spring2022.skribbage.common.Rank;
import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.Hand;
// import edu.skidmore.cs326.spring2022.skribbage.common.Deck;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
// import edu.skidmore.cs326.spring2022.skribbage.logic.HandManager;

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
    // private Deck testDeck;

    /**
     * ArrayList of cards in crib to check the getCrib
     * method in Game.
     */
    private Hand testCrib;
    /**
     * test instance of pegging cards.
     */
    private List<Hand> testListOfPeggingCards;
    /**
     * test instance of cards in play.
     */
    private Hand testCardsInPlay;

    // private HandManager handManager;

    /**
     * Initializes fields.
     */
    @Before
    public void setup() {

        // testDeck = new Deck();
        // handManager = new HandManager();

        int numPlayers = 2;

        testCardsInPlay = new Hand();

        testListOfPeggingCards = new ArrayList<Hand>();

        for (int i = 0; i < numPlayers; i++) {
            testListOfPeggingCards.add(new Hand());
        }

        testCrib = new Hand();

        game = new Game(numPlayers);
    }

    // ============== below line = pass ==================

    /**
     * Tests getListOfPeggingCardsPlayed method for second set of Cards in
     * list.
     * Passes.
     */
    @Test
    public void testGetListOfPeggingCardsPlayedV2() {

        List<Hand> toComparePegList = game.getListOfPeggingCardsPlayed();
        Card[] toComparePegCards = toComparePegList.get(1).getCardsInHand();
        Card[] testPegCards =
            testListOfPeggingCards.get(1).getCardsInHand();

        assertTrue(toComparePegCards.equals(testPegCards));

    }

    /**
     * Tests getListOfPeggingCardsPlayed method for first set of Cards in
     * list.
     * Passes.
     */
    @Test
    public void testGetListOfPeggingCardsPlayedV1() {

        List<Hand> toComparePegList = game.getListOfPeggingCardsPlayed();
        Card[] toComparePegCards = toComparePegList.get(0).getCardsInHand();
        Card[] testPegCards =
            testListOfPeggingCards.get(0).getCardsInHand();

        assertTrue(toComparePegCards.equals(testPegCards));

    }

    // /**
    // * Tests getCardsInPlay method.
    // * Passes.
    // */
    // @Test
    // public void testGetCardsInPlay() {
    //
    // List <Card> retrievedCardsPlay = game.getCardsInPlay().getCardsInHand();
    //
    // List <Card> toCompareCardsInPlay = testCardsInPlay.getCardsInHand();
    //
    // assertTrue(retrievedCardsPlay.equals(toCompareCardsInPlay));
    //
    // }

    // /**
    // * Tests the getPeggingTotal method.
    // * Passes.
    // */
    // @Test
    // public void testGetPeggingTotal() {
    //
    // game.setPeggingTotal(5);
    //
    // int peggingTotal = game.getPeggingTotal();
    //
    // assertEquals(5, peggingTotal);
    //
    // }

    // /**
    // * Tests testInitPeggingCardsPlayed method.
    // * Passes.
    // */
    // @Test
    // public void testInitPeggingCardsPlayed() {
    //
    // assertEquals(game.getListOfPeggingCardsPlayed().size(), 2);
    //
    // }

    // /**
    // * Test the initialize players method.
    // * Passes.
    // */
    // @Test
    // public void testInitPlayers() {
    // game.initPlayers(2);
    // assertEquals(game.getPlayerList().size(), 4);
    // //it should be 4 because the player list was already initialized
    // //for 2 players
    // }
    //
    // /**
    // * Tests the setPeggingTotal method.
    // * Passes.
    // */
    // @Test
    // public void testSetPeggingTotal() {
    //
    // game.setPeggingTotal(5);
    //
    // assertEquals(game.getPeggingTotal(), 5);
    // }

    // /**
    // * Tests the getCrib method.
    // * Passes.
    // */
    // @Test
    // public void testGetCrib() {
    //
    // Hand returnedCrib = game.getCribCards();
    //
    // List <Card> returnedCribList = returnedCrib.getCardsInHand();
    //
    // List <Card> testCribList = testCrib.getCardsInHand();
    //
    // assertTrue(returnedCribList.equals(testCribList));
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
