package edu.skidmore.cs326.spring2022.skribbage.frontend.events.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Before;

import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.Lobby;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.LobbyStartGameEvent;

/**
 * @author Sten Leinasaar
 */
public class LobbyStartGameEventTest {
    /**
     * Test Instance for LobbyEvent testing.
     */
    private LobbyStartGameEvent testInstance;

    /**
     * Test Lobby.
     */
    private Lobby lob;

    /**
     * User test instance.
     */
    private User userInstance;

    /**
     * UserID number.
     */
    private int identity;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;
    static {
        LOG = Logger.getLogger(LobbyStartGameEventTest.class);
    }

    /**
     * Sets up the default testing setting before every test method.
     */
    @Before
    public void setUp() {
        LOG.trace("Started the setup method");
        userInstance = new User("sleinasa@skidmore.edu", "sleinasa",
            UserRole.UNAUTHORIZED);
        identity = 5;
        lob = new Lobby(userInstance, identity);
        testInstance = new LobbyStartGameEvent(this, lob);
        LOG.info("SetUp method completed");
    }

    /**
     * Test that the instance is created by asserting that the testInstance is
     * not null.
     */
    @Test
    public void testLobbyCreateEvent() {
        LOG.trace("Testing the constructor of LobbyEvent");
        assertNotNull(testInstance);
        LOG.trace("LobbyEvent constructor test completed");

    }

    /**
     * Tests if the event name passed to the constructor will be returned
     * correctly.
     */
    @Test
    public void testGetEventType() {
        LOG.trace("Testing getEventName");
        assertEquals(testInstance.getEventType(), EventType.LOBBY_START_GAME);
        LOG.trace("Completed testing the getEventName method");
    }

}