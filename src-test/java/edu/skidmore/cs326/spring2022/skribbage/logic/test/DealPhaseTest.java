//package edu.skidmore.cs326.spring2022.skribbage.logic.test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNotNull;
//
//import edu.skidmore.cs326.spring2022.skribbage.logic.Card;
//import edu.skidmore.cs326.spring2022.skribbage.logic.DealPhase;
//import edu.skidmore.cs326.spring2022.skribbage.logic.Game;
//import edu.skidmore.cs326.spring2022.skribbage.logic.Player;
//import edu.skidmore.cs326.spring2022.skribbage.logic.Suit;
//import org.junit.Before;
//import org.junit.Test;
//
///**
// * Unit Tests for DealPhase Class.
// *
// * @author Dorjee
// */
//public class DealPhaseTest {
//
//  /**
//   * Attribute to house the DealPhase instance.
//   * 
//   */
//  private DealPhase testInstance;
//
//  /**
//   * Creating testInstance of DealPhase.
//   */
//  @Before
//  public void setUp() {
//
//    testInstance = new DealPhase();
//
//  }
//
//  /**
//   * Tests the method to discard cards to the crib.
//   */
//  @Test
//  public void testDiscardtoCrib() {
//    Card cardP1 = new Card('A', Suit.HEARTS);
//    Card cardP2 = new Card('K', Suit.DIAMONDS);
//    Card[] toDiscardP1 = { cardP1 };
//    Card[] toDiscardP2 = { cardP2 };
//    testInstance.discardToCrib(toDiscardP1, toDiscardP2);
//    assertEquals(Game.getCrib().size(), 2);
//
//  }
//
//  /**
//   * Tests the method to remove a card from the players hand.
//   */
//  @Test
//  public void testRemoveCardFromHand() {
//    testInstance.dealCards();
//    Player player1 = Game.getPlayerList().get(0);
//    int beforeHandSize = player1.getHand().size();
//    testInstance.removeCardFromHand(player1.getHand().get(0), player1);
//    assertNotEquals(player1.getHand().size(), beforeHandSize);
//
//  }
//
//  /**
//   * Tests the method to deal the cards.
//   */
//  @Test
//  public void testDealCards() {
//    testInstance.dealCards();
//    for (int i = 0; i < Game.getPlayerList().size(); i++) {
//      assertEquals(Game.getPlayerList().get(i).getHand().size(), 6);
//    }
//
//  }
//
//  /**
//   * Tests the methods to determine the dealer.
//   */
//  @Test
//  public void testDetermineDealer() {
//    testInstance.determineDealer(12, 15);
//    int idxOfDealer = Game.getDealerIdx();
//    assertNotNull(Game.getPlayerList().get(idxOfDealer));
//  }
//
//}
