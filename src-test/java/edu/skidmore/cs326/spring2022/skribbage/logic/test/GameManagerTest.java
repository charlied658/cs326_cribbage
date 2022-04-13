package edu.skidmore.cs326.spring2022.skribbage.logic.test;

import edu.skidmore.cs326.spring2022.skribbage.logic.GameManager;
import edu.skidmore.cs326.spring2022.skribbage.logic.Game;
import edu.skidmore.cs326.spring2022.skribbage.logic.Player;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import edu.skidmore.cs326.spring2022.skribbage.logic.Card;
import static org.junit.Assert.assertTrue;
import edu.skidmore.cs326.spring2022.skribbage.common.Suit;
import static org.junit.Assert.assertEquals;

/**
GameManagerTest tests the methods in GameManager.
@author Michael Shriner
*/
public class GameManagerTest {

    /** Object used to manipulate the Game data. */
    private GameManager gameManager;

    /** Game object to access game data. */
    private Game game;

    /**
     * Initializes Game object.
     * Passes.
     */
    @Before
    public void setup() {
        // initialize the game
        game = new Game();
        //initialize the GameManager
        gameManager = new GameManager(game);
    }

    /**
     * Test the add player method.
     * Passes.
     */
    @Test
    public void testAddPlayer() {

        gameManager.addPlayer(new Player(), game.getPlayerList());
        assertEquals(game.getPlayerList().size(), 1);
    }

    /**
     * Test the initialize players method.
     * Passes.
     */
    @Test
    public void testInitPlayers() {
        gameManager.initPlayers(2, game.getPlayerList());
        assertEquals(game.getPlayerList().size(), 2);
    }

    /**
     * Test addToPeggingTotal method.
     * Checks the case where the amount should be added.
     * Passes.
     */
    @Test
    public void testAddToPeggingTotalV1() {
        int amountToAdd = 5;
        gameManager.addToPeggingTotal(amountToAdd);
        assertEquals(game.getPeggingTotal(), amountToAdd);
    }

    /**
     * Test addToPeggingTotal method.
     * Checks the case where the amount should not be added.
     * Passes.
     */
    @Test
    public void testAddToPeggingTotalV2() {
        gameManager.addToPeggingTotal(31);
        int amountToAdd = 1;
        gameManager.addToPeggingTotal(amountToAdd);
        assertEquals(game.getPeggingTotal(), 31);
    }

    /**
     * Test addPonePeggingCard method.
     * Passes.
     */
    @Test
    public void testAddPonePeggingCard() {

        Card c = new Card('J', Suit.HEARTS);

        gameManager.addPonePeggingCard(c);

        assertTrue(game.getPonePeggingCards().get(0).equals(c));
    }

    /**
     * Test addDealerPeggingCard method.
     * Passes.
     */
    @Test
    public void testAddDealerPeggingCard() {

        Card c = new Card('J', Suit.HEARTS);

        gameManager.addDealerPeggingCard(c);

        assertTrue(game.getDealerPeggingCards().get(0).equals(c));
    }

    /**
     * Test the initialize pegging total method.
     * Passes.
     */
    @Test
    public void testInitPeggingTotal() {
        game.setPeggingTotal(5);

        gameManager.initPeggingTotal();

        assertEquals(game.getPeggingTotal(), 0);
    }

    /**
     * Test the initialize pegging total method.
     * Passes.
     */
    @Test
    public void testGetDealerIdx() {
        //initialize player list
        gameManager.initPlayers(2, game.getPlayerList());

        //set the dealer
        ArrayList <Player> playerList = game.getPlayerList();
        playerList.get(0).setDealer(true);
        playerList.get(1).setDealer(false);

        //get the index of the dealer
        int idxOfDealer = gameManager.getDealerIdx(game.getPlayerList());

        assertEquals(idxOfDealer, 0);
    }


} // end of class
