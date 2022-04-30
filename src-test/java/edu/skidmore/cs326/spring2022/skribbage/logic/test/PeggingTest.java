package edu.skidmore.cs326.spring2022.skribbage.logic.test;

import edu.skidmore.cs326.spring2022.skribbage.logic.PeggingPlay;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.Claim;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import edu.skidmore.cs326.spring2022.skribbage.common.Hand;
import edu.skidmore.cs326.spring2022.skribbage.common.Suit;
import edu.skidmore.cs326.spring2022.skribbage.common.Card;
import edu.skidmore.cs326.spring2022.skribbage.common.Rank;
import edu.skidmore.cs326.spring2022.skribbage.common.Game;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

/**
* PeggingTest tests the methods in PeggingPlay.
*
* @author Michael Shriner.
*/
public class PeggingTest {

    /** A PeggingPlay object used for testing the PeggingPlay class. */
    private PeggingPlay pPlay;

    /** Object used to represent the game state. */
    private Game game;

    /**
    * Initializes fields.
    */
    @Before
    public void setup() {

        game = new Game(2);

        pPlay = new PeggingPlay(game);
    }

    /**
    * Test addCardToPeggingTotal method.
    * Case 1: card added successfully and added to
    * pegging cards played so far for the corresponding player.
    * Passes.
    */
    @Test
    public void testAddCardToPeggingTotalCase1() {

        List <Player> playerList = new ArrayList <Player>();

        playerList.add(new Player(new User("johnFreeWill@gmail.com",
            "jFreeWill", UserRole.AUTHORIZED)));

        playerList.add(new Player(new User("hegel@gmail.com", "phenSpirit",
            UserRole.AUTHORIZED)));

        playerList.get(0).getUser().setUserId(12);

        playerList.get(1).getUser().setUserId(13);

        game.setPlayerList(playerList);

        Card cardToAdd = new Card(Rank.ACE, Suit.HEARTS);

        Player player = game.getPlayerList().get(0);

        boolean wasAdded = pPlay.addCardToPeggingTotal(cardToAdd, player);

        //check that the card was added to the player's corresponding
        //hand of pegging cards

        Hand pegCardsPlayed = game.getPeggingCards(0);

        assertTrue(pegCardsPlayed.getCardsInHand().length == 1);

    }

    /**
    * Test addCardToPeggingTotal method.
    * Case 2: card added unsuccessfully.
    * Passes.
    */
    @Test
    public void testAddCardToPeggingTotalCase2() {

        List <Player> playerList = new ArrayList <Player>();

        playerList.add(new Player(new User("johnFreeWill@gmail.com",
            "jFreeWill", UserRole.AUTHORIZED)));

        playerList.add(new Player(new User("hegel@gmail.com", "phenSpirit",
            UserRole.AUTHORIZED)));

        playerList.get(0).getUser().setUserId(12);

        playerList.get(1).getUser().setUserId(13);

        game.setPlayerList(playerList);

        Card cardToAdd = new Card(Rank.ACE, Suit.HEARTS);

        Player player = game.getPlayerList().get(0);

        game.setPeggingTotal(31);

        boolean wasAdded = pPlay.addCardToPeggingTotal(cardToAdd, player);

        //check that the card was not added to the player's corresponding
        //hand of pegging cards

        Hand pegCardsPlayed = game.getPeggingCards(0);

        assertTrue(pegCardsPlayed.getCardsInHand().length == 0);

    }

    /**
    * Test the method check15.
    * Case 1: player had a valid claim and received points.
    * Passes.
    */
    @Test
    public void testCheck15Case1() {

        game.setPeggingTotal(15);
        Player player = game.getPlayerList().get(0);

        pPlay.check15(player);

        int pts = player.getPoints();

        assertTrue(pts == 2);

    }

    /**
    * Test the method check15.
    * Case 1: player did not have a valid claim and did not get points.
    * Passes.
    */
    @Test
    public void testCheck15Case2() {

        game.setPeggingTotal(1);
        Player player = game.getPlayerList().get(0);

        pPlay.check15(player);

        int pts = player.getPoints();

        assertTrue(pts == 0);

    }

    /**
    * Test checkClaim method.
    * Case 1: player claims fifteen successfully and checkClaim returns true.
    * Passes.
    */
    @Test
    public void testCheckClaimCase1() {

        game.setPeggingTotal(15);
        Player player = game.getPlayerList().get(0);

        boolean wasValid = pPlay.checkClaim(Claim.FIFTEEN, player);

        assertTrue(wasValid);

    }

    /**
    * Test checkClaim method.
    * Case 2: player claims fifteen unsuccessfully and checkClaim returns
    * false.
    * Passes.
    */
    @Test
    public void testCheckClaimCase2() {

        game.setPeggingTotal(1);
        Player player = game.getPlayerList().get(0);

        boolean wasValid = pPlay.checkClaim(Claim.FIFTEEN, player);

        assertTrue(!wasValid);

    }

    /**
    * Test the method check31.
    * Case 1: player had a valid claim and received points.
    * Passes.
    */
    @Test
    public void testCheck31Case1() {

        game.setPeggingTotal(31);
        Player player = game.getPlayerList().get(0);

        pPlay.check31(player);

        int pts = player.getPoints();

        assertTrue(pts == 2);

    }

    /**
    * Test the method check31.
    * Case 2: player did not have a valid claim and did not get points.
    * Passes.
    */
    @Test
    public void testCheck31Case2() {

        game.setPeggingTotal(1);
        Player player = game.getPlayerList().get(0);

        pPlay.check31(player);

        int pts = player.getPoints();

        assertTrue(pts == 0);

    }

    /**
    * Test checkClaim method.
    * Case 3: player claims thirtyone successfully and checkClaim
    * returns true.
    * Passes.
    */
    @Test
    public void testCheckClaimCase3() {

        game.setPeggingTotal(31);
        Player player = game.getPlayerList().get(0);

        boolean wasValid = pPlay.checkClaim(Claim.THIRTYONE, player);

        assertTrue(wasValid);

    }

    /**
    * Test checkClaim method.
    * Case 4: player claims thirtyone unsuccesfully and checkClaim returns
    * false.
    * Passes.
    */
    @Test
    public void testCheckClaimCase4() {

        game.setPeggingTotal(1);
        Player player = game.getPlayerList().get(0);

        boolean wasValid = pPlay.checkClaim(Claim.THIRTYONE, player);

        assertTrue(!wasValid);

    }


} // end of class
