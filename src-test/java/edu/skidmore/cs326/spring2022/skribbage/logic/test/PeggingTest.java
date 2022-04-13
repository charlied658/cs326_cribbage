// package edu.skidmore.cs326.spring2022.skribbage.logic.test;
//
// import edu.skidmore.cs326.spring2022.skribbage.logic.PeggingPlay;
// import edu.skidmore.cs326.spring2022.skribbage.logic.Player;
// import edu.skidmore.cs326.spring2022.skribbage.logic.Hand;
// import edu.skidmore.cs326.spring2022.skribbage.common.Suit;
// import edu.skidmore.cs326.spring2022.skribbage.logic.Card;
// import edu.skidmore.cs326.spring2022.skribbage.logic.Game;
// //import static org.junit.Assert.assertTrue;
// import static org.junit.Assert.assertEquals;
// import org.junit.Before;
// import org.junit.Test;
// import java.util.ArrayList;
//
// /**
// PeggingTest tests the methods in PeggingPlay.
// It is incomplete.
// @author Michael Shriner
// */
// public class PeggingTest {
//
//     /** A pegging play object used for testing the PeggingPlay class. */
//     private PeggingPlay pPlay;
//
//     //private Card c;
//
//     /** Represents the pone in the game during the pegging phase. */
//     private Player pone;
//
//     /** Represents the dealer in the game during the pegging phase.  */
//     private Player dealer;
//
//     //private Hand h;
//
//     /** Object used to represent the game state. */
//     private Game game;
//
//     /**
//      * Initializes the variables and sets up each player as dealer or pone.
//      * Note, this method runs before each test case.
//      */
//     @Before
//     public void setup() {
//         // initialize the game
//         game = new Game(2);
//
//         //note, when the game is initialized, the players and
//         //pegging total are initialized
//
//         // initialize the pegging play
//         pPlay = new PeggingPlay(game);
//
//         // get the players for this game
//         ArrayList<Player> listOfPlayers = game.getPlayerList();
//         // set a player to be the pone
//         pone = listOfPlayers.get(0);
//         pone.setDealer(false);
//         // set a player to be the dealer
//         dealer = listOfPlayers.get(1);
//         dealer.setDealer(true);
//     }
//
//     /**
//      * Test the method to add a card to the pegging total.
//      */
//     @Test
//     public void testAddCardToPeggingTotalCase1() {
//
//         // cases to check
//         // 1) the player is the pone and the card can be added
//         // 2) the player is the dealer and the card can be added
//         // 3) the card cannot be added
//         // 4) the card is added and removed from the player's hand
//         // 5) the card is not added and not removed from the player's hand
//
//         // the player is the pone and the card can be added
//         Card poneCard = new Card('A', Suit.HEARTS);
//         Hand poneHand = pone.getHand();
//         poneHand.addCardToHand(poneCard);
//         pPlay.addCardToPeggingTotal(poneCard, pone);
//         assertEquals(poneCard.getPointValue(), game.getPeggingTotal());
//         // assertTrue(0 == game.getPeggingTotal());
//
//         // pPlay.addCardToPeggingTotal(c, p);
//         // //now, you have to add the card back to the player's hand
//         // //after you assert that the card was removed
//         // assertTrue(p.getHand().getHand().size() == 0);
//         // h.addCardToHand(c);
//         // //check the pegging total
//         // assertTrue(c.getPointValue() == game.getPeggingTotal());
//         //
//         // //p is the dealer
//         // p.isDealer = true;
//         // game.setPeggingTotal(0);
//         // pPlay.addCardToPeggingTotal(c, p);
//         // //now, you have to add the card back to the player's hand
//         // //after you assert that the card was removed
//         // assertTrue(p.getHand().getHand().size() == 0);
//         // h.addCardToHand(c);
//         // //check the pegging total
//         // assertTrue(c.getPointValue() == game.getPeggingTotal());
//         //
//         // //the card cannot be added
//         // game.setPeggingTotal(31);
//         // pPlay.addCardToPeggingTotal(c, p);
//         // //check that the card was not removed from the player's hand
//         // assertTrue(p.getHand().getHand().size() == 1);
//         // assertTrue((c.getPointValue() + 31) != game.getPeggingTotal());
//
//     }
//
//     //
//     // /**
//     // * Test the method check15.
//     // * If the player passed as a parameter placed a card
//     // * during the pegging
//     // phase that
//     // * brought the pegging total to 15, the player is awarded 2 points.
//     // Otherwise, the
//     // * player is awarded no points.
//     // */
//     // @Test
//     // public void testCheck15() {
//     //
//     // //cases
//     // //the player is a dealer and placed a card that
//     // // brought the pegging total
//     // to 15
//     // //the player is a pone and placed a card that brought
//     // //the pegging total
//     // to 15
//     // //the player did not place a card to bring the pegging total to 15
//     //
//     // //the player is a dealer and placed a card that brought
//     // //the pegging total
//     // to 15
//     // p.isDealer = true;
//     // game.setPeggingTotal(14);
//     // pPlay.addCardToPeggingTotal(c, p);
//     // assertTrue(p.getPoints() == 2);
//     //
//     // //reset player's hand
//     // h.addCardToHand(c);
//     //
//     // //reset peggingCards for dealer and pone
//     // game.setPonePeggingCards(new ArrayList<Card>());
//     // game.setDealerPeggingCards(new ArrayList<Card>());
//     //
//     // //the player is a pone and placed a card that brought
//     // //the pegging total
//     // to 15
//     // //!!!!!!!!! reset player points to 0 again !!!!!!!!!
//     // p.intializePoints();
//     // p.isDealer = false;
//     // game.setPeggingTotal(14);
//     // pPlay.addCardToPeggingTotal(c, p);
//     // assertTrue(p.getPoints() == 2);
//     //
//     // //reset player's hand
//     // h.addCardToHand(c);
//     //
//     // //reset peggingCards for dealer and pone
//     // game.setPonePeggingCards(new ArrayList<Card>());
//     // game.setDealerPeggingCards(new ArrayList<Card>());
//     //
//     // //the player did not place a card to bring the pegging
//     // //total to 15
//     // //!!!!!!!!! reset player points to 0 again !!!!!!!!!
//     // p.intializePoints();
//     // game.setPeggingTotal(0);
//     // pPlay.addCardToPeggingTotal(c, p);
//     // assertTrue(p.getPoints() != 2);
//     // }
//     //
//     // /**
//     // * Test the method check31.
//     // * If the player passed as a parameter placed a card
//     // * during the pegging
//     // phase that
//     // * brought the pegging total to 31, the player is awarded 2 points.
//     // Otherwise, the
//     // * player is awarded no points.
//     // */
//     // @Test
//     // public void testCheck31() {
//     //
//     // //cases
//     // //the player is a dealer and placed a card that brought
//     // //the pegging total
//     // to 31
//     // //the player is a pone and placed a card that
//     // //brought the pegging total
//     // to 31
//     // //the player did not place a card to bring the pegging total to 31
//     //
//     // //the player is a dealer and placed a card that brought
//     // //the pegging total
//     // to 31
//     // p.isDealer = true;
//     // game.setPeggingTotal(30);
//     // pPlay.addCardToPeggingTotal(c, p);
//     // assertTrue(p.getPoints() == 2);
//     //
//     // //reset player's hand
//     // h.addCardToHand(c);
//     //
//     // //reset peggingCards for dealer and pone
//     // game.setPonePeggingCards(new ArrayList<Card>());
//     // game.setDealerPeggingCards(new ArrayList<Card>());
//     //
//     //
//     // //the player is a pone and placed a card that brought
//     // //the pegging total
//     // to 31
//     // //!!!!!!!!! reset player points to 0 again !!!!!!!!!
//     // p.intializePoints();
//     // p.isDealer = false;
//     // game.setPeggingTotal(30);
//     // pPlay.addCardToPeggingTotal(c, p);
//     // assertTrue(p.getPoints() == 2);
//     //
//     // //reset player's hand
//     // h.addCardToHand(c);
//     //
//     // //reset peggingCards for dealer and pone
//     // game.setPonePeggingCards(new ArrayList<Card>());
//     // game.setDealerPeggingCards(new ArrayList<Card>());
//     //
//     // //the player did not place a card to bring the pegging total to 31
//     // //!!!!!!!!! reset player points to 0 again !!!!!!!!!
//     // p.intializePoints();
//     // game.setPeggingTotal(0);
//     // pPlay.addCardToPeggingTotal(c, p);
//     // assertTrue(p.getPoints() != 2);
//     // }
//     //
//     // @Test
//     // public void testIsPair (){
//     // //cases
//     // //the method returns true if the cards in the list have the same
//     // identifier
//     // //the method returns false if the cards in the list
//     // //don't have the same
//     // identifier
//     // ArrayList <Card> cardList = new ArrayList <Card> ();
//     // Card c1 = new Card ('A', Suit.HEARTS);
//     // Card c2 = new Card ('A', Suit.DIAMONDS);
//     // Card c3 = new Card ('A', Suit.CLUBS);
//     // Card c4 = new Card ('Q', Suit.HEARTS);
//     //
//     // //case: no cards in list
//     // assertTrue(pPlay.isPair(cardList) == false);
//     //
//     // //case: 1 card in list
//     // cardList.add(c1);
//     // assertTrue(pPlay.isPair(cardList) == false);
//     //
//     // //case: 2 cards in list that have same identifier
//     // cardList.add(c2);
//     // assertTrue(pPlay.isPair(cardList));
//     //
//     // //case: 3 cards in list that have same identifier
//     // cardList.add(c3);
//     // assertTrue(pPlay.isPair(cardList));
//     //
//     // //case: 4 cards in list where one does not have same identifier
//     // cardList.add(c4);
//     // assertTrue(pPlay.isPair(cardList) == false);
//     //
//     // //case: 2 cards in list where one does not have same identifier
//     // cardList.clear();
//     // cardList.add(c1);
//     // cardList.add(c4);
//     // assertTrue(pPlay.isPair(cardList) == false);
//     //
//     // }
//     //
//     // @Test
//     // public void checkPair(){
//     // //case
//     // //player has a pair and gets 2 points
//     // //player does not have a pair and does not get 2 points
//     // Player p2 = new Player ();
//     // Card c2 = new Card('A', Suit.HEARTS);
//     // Hand h2 = p2.getHand();
//     // h2.addCardToHand(c2);
//     // p.isDealer = true;
//     // p2.isDealer = false;
//     //
//     // pPlay.addCardToPeggingTotal(c, p);
//     // pPlay.addCardToPeggingTotal(c2, p2);
//     //
//     // pPlay.checkPair(p);
//     // assertTrue(p.getPoints() == 2);
//     //
//     // pPlay.checkPair(p2);
//     // assertTrue(p2.getPoints() == 2);
//     //
//     // Card c3 = new Card('2', Suit.DIAMONDS);
//     // h2.addCardToHand(c3);
//     // pPlay.addCardToPeggingTotal(c3, p2);
//     //
//     // pPlay.checkPair(p2);
//     // assertTrue(p2.getPoints() == 2);
//     //
//     // pPlay.checkPair(p);
//     // assertTrue(p.getPoints() == 2);
//     //
//     // }
//
//     // @Test
//     // public void check3Pair(){
//     //
//     // //cases
//     // //1) person making the claim is the dealer
//     // //3 pair and 6 points or not 3 pair
//     // //2) person making the claim is not the dealer
//     // //3 pair and 6 points or not 3 pair
//     //
//     // Player p2 = new Player ();
//     // Card c2 = new Card('A', Suit.HEARTS);
//     // Hand h2 = p2.getHand();
//     // h2.addCardToHand(c2);
//     //
//     // Card c3 = new Card ('A', Suit.DIAMONDS);
//     // h.addCardToHand(c3);
//     // p.isDealer = true;
//     //
//     // //1) person making the claim is the dealer
//     // //3 pair and 6 points or not 3 pair
//     //
//     // pPlay.check
//     //
//     // }
//
// } // end of class
