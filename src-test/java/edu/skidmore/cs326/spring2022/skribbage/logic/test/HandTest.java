package edu.skidmore.cs326.spring2022.skribbage.logic.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import edu.skidmore.cs326.spring2022.skribbage.logic.Card;
import edu.skidmore.cs326.spring2022.skribbage.logic.Hand;
import edu.skidmore.cs326.spring2022.skribbage.logic.Suit;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit Tests for Hand Class.
 * 
 * @author Dorjee
 */
public class HandTest {
  
  /**
   * Attribute to house the test instance.
   */
  private Hand testInstance;

  /**
   * Test scaffold set up. Creates the test instance.
   */
  @Before
  public void setup() {
    testInstance = new Hand();
  }    

  /**
   * Test the method to add a card to hand.
   */
  @Test
  public void testAddCardToHand() {
    Card card = new Card('A', Suit.HEARTS);
    testInstance.addCardToHand(card);
    assertTrue(testInstance.getHand().get(0).equals(card));
  }

  /**
   * Test the method to add a card to hand.
   */
  @Test
  public void testRemoveCardFromHand() {
    Card card = new Card('A', Suit.HEARTS);
    Card card1 = new Card('3', Suit.DIAMONDS);
    testInstance.addCardToHand(card);
    testInstance.addCardToHand(card1);
    testInstance.removeCardFromHand(card1);
    assertEquals(testInstance.getHand().size(), 1);

  }
}
