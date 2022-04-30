package edu.skidmore.cs326.spring2022.skribbage.common.test;

import edu.skidmore.cs326.spring2022.skribbage.common.Game;
import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.Hand;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * GameTest tests the methods in Game.
 *
 * @author Michael Shriner.
 */
public class GameTest {

    /** Object used to represent the game state. */
    private Game game;

    /**
     * ArrayList of cards in crib to check the getCrib
     * method in Game.
     */
    private Hand testCrib;

    /**
     * Test instance of the list of pegging cards played during the
     * pegging phase.
     */
    private List<Hand> testListOfPeggingCards;

    /**
     * Test instance of the cards in play.
     */
    private Hand testCardsInPlay;

    /**
     * Initializes fields.
     */
    @Before
    public void setup() {

        int numPlayers = 2;

        testCardsInPlay = new Hand();

        testListOfPeggingCards = new ArrayList<Hand>();

        for (int i = 0; i < numPlayers; i++) {
            testListOfPeggingCards.add(new Hand());
        }

        testCrib = new Hand();

        game = new Game(numPlayers);
    }

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

        assertTrue(Arrays.equals(toComparePegCards, testPegCards));

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
        Card[] testPegCards = testListOfPeggingCards.get(0).getCardsInHand();

        assertTrue(Arrays.equals(toComparePegCards, testPegCards));

    }

    /**
    * Tests getCardsInPlay method.
    * Passes.
    */
    @Test
    public void testGetCardsInPlay() {

        Card [] retrievedCardsPlay = game.getCardsInPlay().getCardsInHand();
        Card [] toCompareCardsInPlay = testCardsInPlay.getCardsInHand();

        assertTrue(Arrays.equals(retrievedCardsPlay, toCompareCardsInPlay));

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
    * Tests testInitPeggingCardsPlayed method.
    * Passes.
    */
    @Test
    public void testInitPeggingCardsPlayed() {

        assertEquals(game.getListOfPeggingCardsPlayed().size(), 2);

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

    /**
    * Tests the getCrib method.
    * Passes.
    */
    @Test
    public void testGetCrib() {

        Hand returnedCrib = game.getCribCards();

        //List <Card> returnedCribList = returnedCrib.getCardsInHand();
        Card [] returnedCribList = returnedCrib.getCardsInHand();

        Card [] testCribList = testCrib.getCardsInHand();

        //assertTrue(returnedCribList.equals(testCribList));
        assertTrue(Arrays.equals(returnedCribList, testCribList));

    }

    /**
    * Tests the getIdxPlayerPegCards method.
    * Passes.
    */
    @Test
    public void testGetIdxPlayerPegCards() {

        List <Player> playerList = new ArrayList <Player>();

        playerList.add(new Player(new User("johnFreeWill@gmail.com",
            "jFreeWill", UserRole.AUTHORIZED)));

        playerList.add(new Player(new User("hegel@gmail.com", "phenSpirit",
            UserRole.AUTHORIZED)));

        playerList.get(0).getUser().setUserId(12);

        playerList.get(1).getUser().setUserId(13);

        game.setPlayerList(playerList);

        assertTrue(game.getIdxPlayerPegCards(playerList.get(0)) == 0);

    }


} // end of class
