package edu.skidmore.cs326.spring2022.skribbage.logic.test;

import edu.skidmore.cs326.spring2022.skribbage.logic.Hand;

import edu.skidmore.cs326.spring2022.skribbage.test.Before;
import edu.skidmore.cs326.spring2022.skribbage.test.Logger;
import edu.skidmore.cs326.spring2022.skribbage.test.SkribbageBattleRoyaleTest;
import edu.skidmore.cs326.spring2022.skribbage.test.Test;

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
    testInstance.addCardToHand(card);
    assertEquals(testInstance[0], card);
  }

  /**
   * Test the method to add a card to hand.
   */
  @Test
  public void testRemoveCardFromHand() {
    testInstance.addCardToHand(card1);
    testInstance.removeCardFromHand(card1);
    assertEquals(testInstance.size(), 1);
 
  }
}
