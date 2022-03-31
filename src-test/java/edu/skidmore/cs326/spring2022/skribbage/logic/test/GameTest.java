package edu.skidmore.cs326.spring2022.skribbage.logic.test;
import edu.skidmore.cs326.spring2022.skribbage.logic.Game;
import edu.skidmore.cs326.spring2022.skribbage.logic.Player;
import org.junit.Before;
import org.junit.Test;
//import java.util.ArrayList;
//import static org.junit.Assert.assertTrue;
//import edu.skidmore.cs326.spring2022.skribbage.logic.PeggingPlay;
//import edu.skidmore.cs326.spring2022.skribbage.logic.Card;
//import edu.skidmore.cs326.spring2022.skribbage.logic.Hand;
//import edu.skidmore.cs326.spring2022.skribbage.logic.Suit;
//import static org.junit.Assert.assertEquals;

/**
GameTest tests the methods in Game.
It is incomplete.
@author Michael Shriner
*/
public class GameTest {

    /** Object used to represent the game state. */
    private Game game;

    /**
     * Initializes Game object.
     */
    @Before
    public void setup() {
        // initialize the game
        game = new Game();
    }

    /**
     * Test the add player method.
     */
    @Test
    public void testAddPlayer() {
        //Player p1 = new Player();
        //Player p2 = new Player();
        //note: there is an issue with creating a player object.
        game.addPlayer(new Player());
    }

    // /**
    //  * Test the initialize players method.
    //  */
    // @Test
    // public void testInitPlayers() {
    //
    //     ArrayList <Player> playersEmpty = game.getPlayerList();
    //     assertTrue(playersEmpty.size() == 0);
    //
    //     game.initPlayers(2);
    //     // ArrayList <Player> playersTwo = game.getPlayerList();
    //     // assertTrue(playersTwo.size() == 2);
    // }


} // end of class
