package edu.skidmore.cs326.spring2022.skribbage.gamification.test;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.gamification.AvatarManager;

/**
 * Unit tests for the AvatarManager class.
 * @author Charlie Davidson
 */
public class AvatarManagerTest {

    /**
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(AvatarManagerTest.class);
    }

    /**
     * Attribute to house the test instance.
     */
    private AvatarManager testInstance;

    /**
     * Test scaffold set up. Creates the test instance.
     */
    @Before
    public void setup() {
        LOG.info("Setup for test");
        testInstance = new AvatarManager();
    }

    /**
     * Test that the map initializes correctly.
     */
    @Test
    public void testMapInitialization() {
        testInstance.initializeAvatarMap();
        assertTrue("Avatar map not initialized properly",
            testInstance.isMapEmpty());
    }

    /**
     * Test that player and avatar are created correctly.
     */
    @Test
    public void testPlayerCreation() {
        testInstance.initializeAvatarMap();
        testInstance.createPlayer("jsmith");
        testInstance.createAvatar("cat.jpg");
        assertTrue("Player not created successfully",
            testInstance.playerExists("jsmith"));
        assertTrue("Avatar not created successfully",
            testInstance.avatarExists("cat.jpg"));
    }

    /**
     * Test that the map can assign an avatar to a player.
     */
    @Test
    public void testAvatarAssignment() {
        testInstance.initializeAvatarMap();
        testInstance.createPlayer("jsmith");
        testInstance.createAvatar("cat.jpg");
        testInstance.assignPlayerAvatar("jsmith", "cat.jpg");
        assertTrue("Avatar not assigned to player properly",
            testInstance.getAvatarFromMap("jsmith")
            .equals("cat.jpg"));
    }

    /**
     * Test that a player-avatar pair can be removed from the map.
     */
    @Test
    public void testAvatarRemoval() {
        testInstance.initializeAvatarMap();
        testInstance.createPlayer("jsmith");
        testInstance.createAvatar("cat.jpg");
        testInstance.assignPlayerAvatar("jsmith", "cat.jpg");
        testInstance.removePlayerAvatar("jsmith");
        assertTrue("Avatar not removed properly",
            testInstance.getAvatarFromMap("jsmith") == null);
        assertTrue("Avatar map is not empty",
            testInstance.isMapEmpty());
    }

}
