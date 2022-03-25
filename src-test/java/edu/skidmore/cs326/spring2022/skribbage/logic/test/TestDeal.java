package edu.skidmore.cs326.spring2022.skribbage.test;

import static org.junit.Assert.assertTrue;


import java.util.ArrayList;

import org.apache.log4j.Logger;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.SkribbageBattleRoyale;

/**
 * Unit tests for the SkribbageBattleRoyale class.
 */
public class TestDeal {
  /**
   * Logger for the class.
   */
  private static final Logger LOG;

  /**
   * Create static resources.
   */
  static {
    LOG = Logger.getLogger(TestDeal.class);
  }

  /**
   * Attribute to house the test instance.
   */
  private Game testInstance;

  /**
   * Test scaffold set up. Creates the test instance.
   */
  @Before
  public void setup() {
    LOG.info("Setup for test");
    testInstance = new Game(2);
  }

  @Test
  public void testDealPhase(){
    //we need to affirm that
    //1) the player's each have a hand of 4 cards
    //2) the crib has 4 cards (each player gives 2)

    ArrayList <Player> playerList = testInstance.getPlayerList();
    ArrayList <Card> crib = testInstance.getCrib();

    Hand handOneBeforeDeal = playerList.get(0).getHand();
    Hand handTwoBeforeDeal = playerList.get(1).getHand();

    //assert that the hand of each player is size 0 before calling dealPhase
    assert handOneBeforeDeal.getHand().size() == 0;
    assert handTwoBeforeDeal.getHand().size() == 0;

    //assert that the size of the crib is size 0 before calling dealPhase
    assert crib.size() == 0;

    testInstance.dealPhase();

    //assert that the hand of each player is size 4 after calling dealPhase
    Hand handOneAfterDeal = playerList.get(0).getHand();
    Hand handTwoAfterDeal = playerList.get(1).getHand();

    assert handOneAfterDeal.getHand().size() == 4;
    assert handTwoAfterDeal.getHand().size() == 4;

    //assert that the crib is size 4 after calling dealPhase
    crib = testInstance.getCrib();

    assert crib.size() == 4;

  }

  // /**
  //  * Test that the welcome message begins with the name of the game.
  //  */
  // @Test
  // public void testGetWelcomeMessage() {
  //   assertNotNull("Welcome message is null",
  //       testInstance.getWelcomeMessage());
  //   assertTrue("Welcome message does not start with the name of game",
  //       testInstance.getWelcomeMessage()
  //           .startsWith("Skribbage Battle Royale"));
  // }
}
