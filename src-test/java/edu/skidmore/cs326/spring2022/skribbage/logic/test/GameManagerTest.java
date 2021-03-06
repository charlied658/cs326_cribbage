package edu.skidmore.cs326.spring2022.skribbage.logic.test;

import edu.skidmore.cs326.spring2022.skribbage.logic.GameManager;
import edu.skidmore.cs326.spring2022.skribbage.common.Game;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * GameManagerTest tests the methods in GameManager.
 *
 * @author Michael Shriner.
 */
public class GameManagerTest {

    /** Object used to manipulate the Game data. */
    private GameManager gameManager;

    /** Game object to access game data. */
    private Game game;

    /**
     * Initializes Game and GameManager objects.
     */
    @Before
    public void setup() {
        // initialize the game
        game = new Game(2);
        // initialize the GameManager
        gameManager = new GameManager(game);
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
     * Test getDealerIdx method.
     * Passes.
     */
    @Test
    public void testGetDealerIdx() {

        // set the dealer
        List<Player> playerList = game.getPlayerList();
        playerList.get(0).setDealer(true);
        playerList.get(1).setDealer(false);

        // get the index of the dealer
        int idxOfDealer = gameManager.getDealerIdx(game.getPlayerList());

        assertEquals(idxOfDealer, 0);
    }





}
