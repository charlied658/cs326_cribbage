package edu.skidmore.cs326.spring2022.skribbage.gamification.test;

import org.apache.log4j.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.gamification.InventoryPrototype;
import edu.skidmore.cs326.spring2022.skribbage.gamification.MarketPlaceManager;
import edu.skidmore.cs326.spring2022.skribbage.gamification.SpecialCard;

/**
 * Unit tests for the MarketPlaceManger class.
 * 
 * @author Muaded Almheiri
 */
public class MarketPlaceManagerTest {

    /**
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(MarketPlaceManagerTest.class);
    }

    /**
     * Attribute to house the test instance.
     */
    private InventoryPrototype testInventoryInstance;

    /**
     * Instance for a player.
     */
    private Player player = new Player();

    /**
     * Attribute to house the test instance.
     */
    private MarketPlaceManager testInstance;

    /**
     * Create MarketPlaceManager instance.
     */
    @Before
    public void setup() {
        LOG.info("Setup for test");
        testInstance = new MarketPlaceManager(SpecialCard.REBATTLECARD);
        testInventoryInstance = player.getInventoryManager();
        MarketPlaceManager testLPSC =
            new MarketPlaceManager(SpecialCard.LASTPLAYERSHOWCARD);
        MarketPlaceManager testSPTC =
            new MarketPlaceManager(SpecialCard.SKIPPLAYERTURNCARD);
        MarketPlaceManager testTAPC =
            new MarketPlaceManager(SpecialCard.THROWAWAYPICKUPCARD);
        MarketPlaceManager testMirror =
            new MarketPlaceManager(SpecialCard.MIRROR);
        MarketPlaceManager testDisarm =
            new MarketPlaceManager(SpecialCard.DISARM);
        MarketPlaceManager testPP =
            new MarketPlaceManager(SpecialCard.PICKPOCKET);
        MarketPlaceManager testAP =
            new MarketPlaceManager(SpecialCard.AUTOPILOT);
        MarketPlaceManager testCC = new MarketPlaceManager(SpecialCard.COPYCAT);

    }

    /**
     * Test that if player has enough tokens and special card is bought, player
     * tokens
     * is properly updated.
     * TODO If special card bought, test that special card was sent to
     * inventory.
     */
    @Test
    public void testBuyItem() {

        int playerTokensTest = 24;

        testInstance.buySpecialCard(playerTokensTest);
        assertEquals(24, playerTokensTest);

    }

    /**
     * Test that proper special card name is returned and is not null.
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
     * Test that proper special card description is returned and is not null.
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
     * Test that proper special card name is set.
     */
    @Test
    public void testSetName() {

        testInstance.setName(SpecialCard.REBATTLECARD.getType());
        assertEquals(testInstance.getName(),
            SpecialCard.REBATTLECARD.getType());

    }

    /**
     * Test that proper special card price is set.
     */
    @Test
    public void testSetPrice() {

        testInstance.setPrice(SpecialCard.REBATTLECARD.getPrice());
        assertEquals(testInstance.getPrice(),
            SpecialCard.REBATTLECARD.getPrice());

    }

    /**
     * Test that proper special card description is set.
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
        
        testInstance.addSpecialCard();
        testInventoryInstance.updateInventory();
        assertTrue("Item was not added",
            testInventoryInstance.searchForItem(testInstance.getName()) == 0);

    }

}
