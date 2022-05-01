package edu.skidmore.cs326.spring2022.skribbage.frontend.events.game.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Before;

import org.junit.Test;


import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.Player;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.game.PlayerSendCardsToCribEvent;

/**
 * @author Sten Leinasaar
 */
public class PlayerSendCardsToCribEventTest {
    /**
     * Test Instance for LobbyEvent testing.
     */
    private PlayerSendCardsToCribEvent testInstance;

    /**
     * User test instance.
     */
    private User userInstance;

    /**
     * Player instance to test with.
     */
    private Player player;
    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;
    static {
        LOG = Logger.getLogger(PlayerSendCardsToCribEventTest.class);
    }

    /**
     * Sets up the default testing setting before every test method.
     */
    @Before
    public void setUp() {
        LOG.trace("Started the setup method");
        userInstance = new User("sleinasa@skidmore.edu", "sleinasa",
            UserRole.UNAUTHORIZED);
        player = new Player(userInstance);
        testInstance = new PlayerSendCardsToCribEvent(this, player);
        LOG.info("SetUp method completed");
    }

    /**
     * Test that the instance is created by asserting that the testInstance is
     * not null.
     */
    @Test
    public void testPlayerClickDeckEvent() {
        LOG.trace("Testing the constructor");
        assertNotNull(testInstance);
        LOG.trace("constructor test completed");

    }

    /**
     * Tests if the event name passed to the constructor will be returned
     * correctly.
     */
    @Test
    public void testGetEventType() {
        LOG.trace("Testing getEventName");
        assertEquals(testInstance.getEventType(),
            EventType.PLAYER_SEND_CARD_TO_CRIB);
        LOG.trace("Completed testing the getEventName method");
    }

}
