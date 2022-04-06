package edu.skidmore.cs326.spring2022.skribbage.frontend.events.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.frontend.events.LobbyEvent;

/**
 * @author Sten Leinasaar
 *         Last Edited: By Sten, March 23, 2022
 */
public class LobbyEventTest {
    /**
     * Test Instance for LobbyEvent testing.
     */
    private LobbyEvent testInstance;

    /**
     * Source object that fired the event change.
     */
    private Object source;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;
    static {
        LOG = Logger.getLogger(LobbyEventTest.class);
    }

    /**
     * Sets up the default testing setting before every test method.
     */
    @Before
    public void setUp() {
        LOG.trace("Started the setup method");
        source = new Object();
        //TODO: CHange this to a concrete impl
//        testInstance = new LobbyEvent(source);
        LOG.info("SetUp method completed");
    }

    /**
     * Test that the instance is created by asserting that the testInstance is
     * not null.
     */
    @Test
    public void testLobbyEvent() {
        LOG.trace("Testing the constructor of LobbyEvent");
        assertNotNull(testInstance);
        assertEquals(testInstance.getSource(), source);
        LOG.trace("LobbyEvent constructor test completed");

    }

    /**
     * Tests if the event name passed to the constructor will be returned
     * correctly.
     */
    @Test
    public void testGetEventName() {
        LOG.trace("Testing getEventName");
        assertEquals(testInstance.getEventType(), "Lobby Event");
        LOG.trace("Completed testing the getEventName method");
    }
    /**
     * Sets all initialized variables to null.
     */
    @After
    public void tearDown() {
        LOG.trace("Starting the teardown");
        testInstance = null;
        source = null;

        LOG.trace("Assert that teardown was succesful");
        assertNull(testInstance);
        assertNull(source);

        LOG.trace("Teardown completed");

    }

}
