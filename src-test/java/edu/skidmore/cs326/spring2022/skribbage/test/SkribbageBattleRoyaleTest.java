package edu.skidmore.cs326.spring2022.skribbage.test;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.SkribbageBattleRoyale;

/**
 * Unit tests for the SkribbageBattleRoyale class.
 */
public class SkribbageBattleRoyaleTest {
  /**
   * Logger for the class.
   */
  private static final Logger LOG;

  /**
   * Create static resources.
   */
  static {
    LOG = Logger.getLogger(SkribbageBattleRoyaleTest.class);
  }

  /**
   * Attribute to house the test instance.
   */
  private SkribbageBattleRoyale testInstance;

  /**
   * Test scaffold set up. Creates the test instance.
   */
  @Before
  public void setup() {
    LOG.info("Setup for test");
    testInstance = new SkribbageBattleRoyale();
  }

  /**
   * Test that the welcome message begins with the name of the game.
   */
  @Test
  public void testGetWelcomeMessage() {
    assertNotNull("Welcome message is null",
        testInstance.getWelcomeMessage());
    assertTrue("Welcome message does not start with the name of game",
        testInstance.getWelcomeMessage()
            .startsWith("Skribbage Battle Royale"));
  }
}
