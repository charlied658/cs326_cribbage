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
//   * Create an instance of Game with 2 players to test DealPhase methods.
//   * 
//   */
//  private Game game = new Game(2);
//
//  /**
//   * Creating testInstance of DealPhase.
//   */
//  @Before
//  public void setUp() {
//    testInstance = new DealPhase(game);
//  }
//
//  /**
//   * Test DealPhase method.
//   */
//  @Test
//  public void testDealPhase() {
//    testInstance.dealPhase();
//
//  }
//
//  /**
//   * Tests the method to discard cards to the crib.
//   */
//  @Test
//  public void testDiscardtoCrib() {
//    Card cardP1 = new Card('A', Suit.DIAMONDS);
//    Card cardP2 = new Card('K', Suit.HEARTS);
//    Card[] toDiscardP1 = { cardP1 };
//    Card[] toDiscardP2 = { cardP2 };
//    testInstance.discardToCrib(toDiscardP1, toDiscardP2);
//    assertEquals(game.getCrib().size(), 2);
//
//  }
//
//  /**
//   * Tests the method to remove a card from the players hand.
//   */
//  @Test
//  public void testRemoveCardFromHand() {
//    testInstance.determineDealer(12, 15);
//    testInstance.dealCards();
//    Player player1 = game.getPlayerList().get(0);
//    int beforeHandSize = player1.getHand().getHand().size();
//    testInstance.removeCardFromHand(player1.getHand().getHand().get(0),
//        player1);
//    assertNotEquals(player1.getHand().getHand().size(), beforeHandSize);
//
//  }
//
//  /**
//   * Tests the method to deal the cards.
//   */
//  @Test
//  public void testDealCards() {
//    testInstance.dealCards();
//    for (int i = 0; i < game.getPlayerList().size(); i++) {
//      assertEquals(game.getPlayerList().get(i).getHand().getHand().size(), 6);
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
//    int idxOfDealer = game.getDealerIdx();
//    assertNotNull(game.getPlayerList().get(idxOfDealer));
//  }
//
//}
