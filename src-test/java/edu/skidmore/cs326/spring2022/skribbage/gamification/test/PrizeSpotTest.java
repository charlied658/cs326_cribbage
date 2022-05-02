package edu.skidmore.cs326.spring2022.skribbage.gamification.test;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.Location;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.gamification.PrizeSpot;

/**
 * test.
 * 
 * @author
 *         Henry Wilson
 */
public class PrizeSpotTest {

    /**
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(JumpSpotTest.class);
    }

    /**
     * Attribute to house the test instance.
     */
    private PrizeSpot testInstance;

    /**
     * location of test instance of prize spot.
     */
    private Location testLocation;

    /**
     * Player being jumped.
     */
    private Player testPlayer;

    /**
     * Test scaffold set up. Creates the test instance.
     */
    @Before
    public void setup() {
        LOG.info("Setup for test");
        testLocation = new Location(1, 1);
        testInstance = new PrizeSpot(testLocation);
        testPlayer = new Player();
    }

    /**
     * Tests reward player method.
     */
    @Test
    public void testRewardPlayer() {
        
        testPlayer.getInventoryManager().updateInventory();
        for (int i = 0; i < 100; i++) {
            testInstance.rewardPlayer(testPlayer);
        }
        assertTrue(
            testPlayer.getInventoryManager().searchForItem("Mirror") != 1);
        assertTrue(testPlayer.getInventoryManager()
            .searchForItem("Re-Battle Card") != 0);
        assertTrue(testPlayer.getInventoryManager()
            .searchForItem("Last-Player-Show Card") != 0);
        assertTrue(
            testPlayer.getInventoryManager().searchForItem("Auto Pilot") != 0);
        assertTrue(
            testPlayer.getInventoryManager().searchForItem("Copycat") != 0);
        assertTrue(
            testPlayer.getInventoryManager().searchForItem("Pick Pocket") != 0);
        assertTrue(
            testPlayer.getInventoryManager().searchForItem("Disarm") != 0);
        assertTrue(testPlayer.getInventoryManager()
            .searchForItem("Throw-Away-Pickup Card") != 0);
        assertTrue(testPlayer.getInventoryManager()
            .searchForItem("Skip-Player-Turn Card") != 0);

    }

}
