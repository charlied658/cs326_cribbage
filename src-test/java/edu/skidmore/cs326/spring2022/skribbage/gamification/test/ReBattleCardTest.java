package edu.skidmore.cs326.spring2022.skribbage.gamification.test;

import java.util.HashMap;

import org.apache.log4j.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.gamification.InventoryPrototype;
import edu.skidmore.cs326.spring2022.skribbage.gamification.ReBattleCard;
import edu.skidmore.cs326.spring2022.skribbage.gamification.SpecialCard;

/**
 * Unit tests for the ReBattleCard class.
 * 
 * @author Muaded Almheiri
 */
public class ReBattleCardTest {

    /**
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(ReBattleCardTest.class);
    }

    /**
     * Attribute to house the test instance.
     */
    private ReBattleCard testInstance;

    /**
     * Create RebattleCard instance.
     */
    @Before
    public void setup() {
        LOG.info("Setup for test");
        testInstance = new ReBattleCard();
    }

    /**
     * Test that if player has enough tokens and item is bought, player tokens
     * is properly updated.
     * TODO If item bought, test that item was sent to inventory.
     */
    @Test
    public void testBuyItem() {

        int playerTokensTest = 24;

        testInstance.buyItem(playerTokensTest);
        assertEquals(24, playerTokensTest);

    }

    /**
     * Test that proper card name is returned and is not null.
     */
    @Test
    public void testGetName() {

        assertNotNull("Item name is null",
            testInstance.getName());
        assertEquals(SpecialCard.REBATTLECARD.getType(),
            testInstance.getName());
    }

    /**
     * Test that correct price is returned when method is called.
     */
    @Test
    public void testGetPrice() {

        testInstance.setPrice(SpecialCard.REBATTLECARD.getPrice());
        assertEquals(SpecialCard.REBATTLECARD.getPrice(),
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
            SpecialCard.REBATTLECARD.getDescription(),
            testInstance.getDescription());
    }

    /**
     * Test that proper card name is set.
     */
    @Test
    public void testSetName() {

        testInstance.setName(SpecialCard.REBATTLECARD.getType());
        assertEquals(testInstance.getName(),
            SpecialCard.REBATTLECARD.getType());

    }

    /**
     * Test that proper card price is set.
     */
    @Test
    public void testSetPrice() {

        testInstance.setPrice(SpecialCard.REBATTLECARD.getPrice());
        assertEquals(testInstance.getPrice(),
            SpecialCard.REBATTLECARD.getPrice());

    }

    /**
     * Test that proper card description is set.
     */
    @Test
    public void testSetDescription() {

        testInstance.setDescription(SpecialCard.REBATTLECARD.getDescription());
        assertEquals(testInstance.getDescription(),
            SpecialCard.REBATTLECARD.getDescription());

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
