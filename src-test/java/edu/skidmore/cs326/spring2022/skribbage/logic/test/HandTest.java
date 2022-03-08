package edu.skidmore.cs326.spring2022.skribbage.logic.test;

import edu.skidmore.cs326.spring2022.skribbage.logic.Hand;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import org.apache.log4j.Logger;

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
