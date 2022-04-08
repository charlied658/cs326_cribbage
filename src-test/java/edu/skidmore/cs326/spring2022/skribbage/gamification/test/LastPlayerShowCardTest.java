package edu.skidmore.cs326.spring2022.skribbage.gamification.test;

import java.util.HashMap;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.gamification.LastPlayerShowCard;

/**
 * Unit tests for the LastPlayerShowCard class.
 * 
 * @author Muaded Almheiri
 */
public class LastPlayerShowCardTest {

  /**
   * Logger for the class.
   */
  private static final Logger LOG;

  /**
   * Create static resources.
   */
  static {
    LOG = Logger.getLogger(LastPlayerShowCardTest.class);
  }

  /**
   * Attribute to house the test instance.
   */
  private LastPlayerShowCard testInstance;

  /**
   * Create RebattleCard instance.
   */
  @Before
  public void setup() {
    LOG.info("Setup for test");
    testInstance = new LastPlayerShowCard();
  }

  /**
   * Test that if player has enough tokens and item is bought, player tokens
   * is properly updated.
   * TODO If item bought, test that item was sent to inventory.
   */
  @Test
  public void testBuyItem() {

    int playerTokensTest = 100;

    testInstance.buyItem(playerTokensTest);
    assertEquals(100 - testInstance.getPrice(), playerTokensTest);

    playerTokensTest = 20;

    testInstance.buyItem(playerTokensTest);
    assertEquals(20, playerTokensTest);

  }

  /**
   * Test that proper card name is returned and is not null.
   */
  @Test
  public void testGetName() {

    assertNotNull("Item name is null",
        testInstance.getName());
    assertEquals("Last-Player-Show Card",
        testInstance.getName());
  }

  /**
   * Test that correct price is returned when method is called.
   */
  @Test
  public void testGetPrice() {

    assertEquals("25", testInstance.getPrice());
  }

  /**
   * Test that proper card description is returned and is not null.
   */
  @Test
  public void testGetDescription() {

    assertNotNull("Item description is null",
        testInstance.getDescription());
    assertEquals(
        "Use this card to affect the order of the show."
            + " Choose an opponent whose show will be moved to following"
            + "the last show player. May only be used once during a show "
            + "phase",
        testInstance.getDescription());
  }

  /**
   * Test that proper card name is set.
   */
  @Test
  public void testSetName() {

    String testString = "Last-Player-Show Card";
    testInstance.setName(testString);
    assertEquals(testInstance.getName(), testString);

  }

  /**
   * Test that proper card price is set.
   */
  @Test
  public void testSetPrice() {

    int cardPrice = 50;
    testInstance.setPrice(cardPrice);
    assertEquals(testInstance.getPrice(), cardPrice);

  }

  /**
   * Test that proper card description is set.
   */
  @Test
  public void testSetDescription() {

    String description = "Use this card to affect the order of the show."
        + " Choose an opponent whose show will be moved to following"
        + "the last show player. May only be used once during a show "
        + "phase";
    testInstance.setDescription(description);
    assertEquals(testInstance.getDescription(), description);

  }

  /**
   * Test that inventory is properly updated.
   */
//  @Test
//  public void testUpdateInventory() {
//    
//    HashMap<String, Integer> testMap = new HashMap<String, Integer>();
//
//    testMap.put("testItem", 100);
//    testInstance.addItemToInventory(testMap);
//
//    for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
//
//      if (entry.getKey().equals("testItem")) {      
//        assertTrue("Inventory not properly updated.",
//            entry.getKey().equals("testItem"));
//      }
//    }
//
//  }

}
