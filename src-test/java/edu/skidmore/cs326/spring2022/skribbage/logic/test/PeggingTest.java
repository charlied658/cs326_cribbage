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


    // haven't udpated below tests ============

    //
    // /**
    // * Test the method check31.
    // * If the player passed as a parameter placed a card
    // * during the pegging
    // phase that
    // * brought the pegging total to 31, the player is awarded 2 points.
    // Otherwise, the
    // * player is awarded no points.
    // */
    // @Test
    // public void testCheck31() {
    //
    // //cases
    // //the player is a dealer and placed a card that brought
    // //the pegging total
    // to 31
    // //the player is a pone and placed a card that
    // //brought the pegging total
    // to 31
    // //the player did not place a card to bring the pegging total to 31
    //
    // //the player is a dealer and placed a card that brought
    // //the pegging total
    // to 31
    // p.isDealer = true;
    // game.setPeggingTotal(30);
    // pPlay.addCardToPeggingTotal(c, p);
    // assertTrue(p.getPoints() == 2);
    //
    // //reset player's hand
    // h.addCardToHand(c);
    //
    // //reset peggingCards for dealer and pone
    // game.setPonePeggingCards(new ArrayList<Card>());
    // game.setDealerPeggingCards(new ArrayList<Card>());
    //
    //
    // //the player is a pone and placed a card that brought
    // //the pegging total
    // to 31
    // //!!!!!!!!! reset player points to 0 again !!!!!!!!!
    // p.intializePoints();
    // p.isDealer = false;
    // game.setPeggingTotal(30);
    // pPlay.addCardToPeggingTotal(c, p);
    // assertTrue(p.getPoints() == 2);
    //
    // //reset player's hand
    // h.addCardToHand(c);
    //
    // //reset peggingCards for dealer and pone
    // game.setPonePeggingCards(new ArrayList<Card>());
    // game.setDealerPeggingCards(new ArrayList<Card>());
    //
    // //the player did not place a card to bring the pegging total to 31
    // //!!!!!!!!! reset player points to 0 again !!!!!!!!!
    // p.intializePoints();
    // game.setPeggingTotal(0);
    // pPlay.addCardToPeggingTotal(c, p);
    // assertTrue(p.getPoints() != 2);
    // }
    //
    // @Test
    // public void testIsPair (){
    // //cases
    // //the method returns true if the cards in the list have the same
    // identifier
    // //the method returns false if the cards in the list
    // //don't have the same
    // identifier
    // ArrayList <Card> cardList = new ArrayList <Card> ();
    // Card c1 = new Card ('A', Suit.HEARTS);
    // Card c2 = new Card ('A', Suit.DIAMONDS);
    // Card c3 = new Card ('A', Suit.CLUBS);
    // Card c4 = new Card ('Q', Suit.HEARTS);
    //
    // //case: no cards in list
    // assertTrue(pPlay.isPair(cardList) == false);
    //
    // //case: 1 card in list
    // cardList.add(c1);
    // assertTrue(pPlay.isPair(cardList) == false);
    //
    // //case: 2 cards in list that have same identifier
    // cardList.add(c2);
    // assertTrue(pPlay.isPair(cardList));
    //
    // //case: 3 cards in list that have same identifier
    // cardList.add(c3);
    // assertTrue(pPlay.isPair(cardList));
    //
    // //case: 4 cards in list where one does not have same identifier
    // cardList.add(c4);
    // assertTrue(pPlay.isPair(cardList) == false);
    //
    // //case: 2 cards in list where one does not have same identifier
    // cardList.clear();
    // cardList.add(c1);
    // cardList.add(c4);
    // assertTrue(pPlay.isPair(cardList) == false);
    //
    // }
    //
    // @Test
    // public void checkPair(){
    // //case
    // //player has a pair and gets 2 points
    // //player does not have a pair and does not get 2 points
    // Player p2 = new Player ();
    // Card c2 = new Card('A', Suit.HEARTS);
    // Hand h2 = p2.getHand();
    // h2.addCardToHand(c2);
    // p.isDealer = true;
    // p2.isDealer = false;
    //
    // pPlay.addCardToPeggingTotal(c, p);
    // pPlay.addCardToPeggingTotal(c2, p2);
    //
    // pPlay.checkPair(p);
    // assertTrue(p.getPoints() == 2);
    //
    // pPlay.checkPair(p2);
    // assertTrue(p2.getPoints() == 2);
    //
    // Card c3 = new Card('2', Suit.DIAMONDS);
    // h2.addCardToHand(c3);
    // pPlay.addCardToPeggingTotal(c3, p2);
    //
    // pPlay.checkPair(p2);
    // assertTrue(p2.getPoints() == 2);
    //
    // pPlay.checkPair(p);
    // assertTrue(p.getPoints() == 2);
    //
    // }

    // @Test
    // public void check3Pair(){
    //
    // //cases
    // //1) person making the claim is the dealer
    // //3 pair and 6 points or not 3 pair
    // //2) person making the claim is not the dealer
    // //3 pair and 6 points or not 3 pair
    //
    // Player p2 = new Player ();
    // Card c2 = new Card('A', Suit.HEARTS);
    // Hand h2 = p2.getHand();
    // h2.addCardToHand(c2);
    //
    // Card c3 = new Card ('A', Suit.DIAMONDS);
    // h.addCardToHand(c3);
    // p.isDealer = true;
    //
    // //1) person making the claim is the dealer
    // //3 pair and 6 points or not 3 pair
    //
    // pPlay.check
    //
    // }


} // end of class
