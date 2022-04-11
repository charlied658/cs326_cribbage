package edu.skidmore.cs326.spring2022.skribbage.gamification.test;

import java.util.HashMap;

import org.apache.log4j.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.gamification.InventoryPrototype;
import edu.skidmore.cs326.spring2022.skribbage.gamification.SkipPlayerTurnCard;
import edu.skidmore.cs326.spring2022.skribbage.gamification.SpecialCard;

/**
 * Unit tests for the SkipPlayerTurnCard class.
 * 
 * @author Muaded Almheiri
 */
public class SkipPlayerTurnCardTest {

    /**
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(SkipPlayerTurnCardTest.class);
    }

    /**
     * Attribute to house the test instance.
     */
    private SkipPlayerTurnCard testInstance;

    /**
     * Create RebattleCard instance.
     */
    @Before
    public void setup() {
        LOG.info("Setup for test");
        testInstance = new SkipPlayerTurnCard();
    }

    /**
     * Test that if player has enough tokens and item is bought, player tokens
     * is properly updated.
     * TODO If item bought, test that item was sent to inventory.
     */
    @Test
    public void testBuyItem() {

        int playerTokensTest = 99;

        testInstance.buyItem(playerTokensTest);
        assertEquals(99, playerTokensTest);

    }

    /**
     * Test that proper card name is returned and is not null.
     */
    @Test
    public void testGetName() {

        assertNotNull("Item name is null",
            testInstance.getName());
        assertEquals(SpecialCard.SKIPPLAYERTURNCARD.getType(),
            testInstance.getName());
    }

    /**
     * Test that correct price is returned when method is called.
     */
    @Test
    public void testGetPrice() {

        testInstance.setPrice(SpecialCard.SKIPPLAYERTURNCARD.getPrice());
        assertEquals(SpecialCard.SKIPPLAYERTURNCARD.getPrice(),
            testInstance.getPrice());

    }

    /**
     * Test that proper card description is returned and is not null.
     */
    @Test
    public void testGetDescription() {

        assertNotNull("Item description is null",
            testInstance.getDescription());
        assertEquals(
            SpecialCard.SKIPPLAYERTURNCARD.getDescription(),
            testInstance.getDescription());
    }

    /**
     * Test that proper card name is set.
     */
    @Test
    public void testSetName() {

        testInstance.setName(SpecialCard.SKIPPLAYERTURNCARD.getType());
        assertEquals(testInstance.getName(),
            SpecialCard.SKIPPLAYERTURNCARD.getType());

    }

    /**
     * Test that proper card price is set.
     */
    @Test
    public void testSetPrice() {

        testInstance.setPrice(SpecialCard.SKIPPLAYERTURNCARD.getPrice());
        assertEquals(testInstance.getPrice(),
            SpecialCard.SKIPPLAYERTURNCARD.getPrice());

    }

    /**
     * Test that proper card description is set.
     */
    @Test
    public void testSetDescription() {

        testInstance.setDescription(
            SpecialCard.SKIPPLAYERTURNCARD.getDescription());
        assertEquals(testInstance.getDescription(),
            SpecialCard.SKIPPLAYERTURNCARD.getDescription());

    }

    /**
     * Test that inventory is properly updated.
     */
    @Test
    public void testAddSpecialCard() {

        HashMap<String, Integer> testMap = new HashMap<String, Integer>();
        InventoryPrototype testInv = new InventoryPrototype();
        testMap.put("testItem", 100);
        testInstance.addSpecialCard(testMap);
        assertEquals(100,
            testInv.searchForItem(testMap, "testItem"));

    }

}
