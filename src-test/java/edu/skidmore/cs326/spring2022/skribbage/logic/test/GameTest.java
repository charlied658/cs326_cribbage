package edu.skidmore.cs326.spring2022.skribbage.logic.test;
import edu.skidmore.cs326.spring2022.skribbage.logic.Game;
import edu.skidmore.cs326.spring2022.skribbage.logic.Player;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
//import static org.junit.Assert.assertTrue;
//import edu.skidmore.cs326.spring2022.skribbage.logic.PeggingPlay;
// import edu.skidmore.cs326.spring2022.skribbage.logic.Card;
//import edu.skidmore.cs326.spring2022.skribbage.logic.Hand;
//import edu.skidmore.cs326.spring2022.skribbage.logic.Suit;
import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertNotSame;
// import static org.junit.Assert.assertSame;

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
        assertEquals(game.getPlayerList().size(), 0);
        game.addPlayer(new Player());
        assertEquals(game.getPlayerList().size(), 1);

    }

    /**
     * Test the initialize players method.
     */
    @Test
    public void testInitPlayers() {

        ArrayList <Player> playersEmpty = game.getPlayerList();
        assertEquals(playersEmpty.size(), 0);

        game.initPlayers(2);
        ArrayList <Player> playersTwo = game.getPlayerList();
        assertEquals(playersTwo.size(), 2);
    }

    /**
     * Test the setPeggingTotal method.
     */
    @Test
    public void testSetPeggingTotal() {

        assertEquals(game.getPeggingTotal(), 0);

        game.setPeggingTotal(5);

        assertEquals(game.getPeggingTotal(), 5);
    }

    /**
     * Test the initialize pegging total method.
     */
    @Test
    public void testInitPeggingTotal() {

        game.setPeggingTotal(5);
        assertEquals(game.getPeggingTotal(), 5);

        game.initPeggingTotal();
        assertEquals(game.getPeggingTotal(), 0);
    }

    // /**
    //  * Test the initialize pegging total method.
    //  */
    // @Test
    // public void testInitPeggingTotal() {
    //
    //     game.setPeggingTotal(5);
    //     assertEquals(game.getPeggingTotal(), 5);
    //
    //     game.initPeggingTotal();
    //     assertEquals(game.getPeggingTotal(), 0);
    // }

    // /**
    //  * Test the set pone pegging cards method.
    //  */
    // @Test
    // public void testSetPonePeggingCards() {
    //
    //   ArrayList<Card> ponePegCardsNew = new ArrayList <Card>();
    //   ponePegCardsNew.add(new Card ('J', Suit.HEARTS));
    //
    //   ArrayList <Card> ponePegCardsOld = game.getPonePeggingCards();
    //
    //
    //   assertNotSame(ponePegCardsNew, ponePegCardsOld);
    //
    //   game.setPonePeggingCards(ponePegCardsNew);
    //
    //   assertSame(ponePegCardsNew, ponePegCardsOld);
    //
    // }




} // end of class
