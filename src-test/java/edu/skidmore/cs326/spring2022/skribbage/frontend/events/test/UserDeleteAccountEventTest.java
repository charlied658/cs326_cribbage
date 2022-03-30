package edu.skidmore.cs326.spring2022.skribbage.frontend.events.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserCreateAccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserDeleteAccountEvent;

/**
 * @author Sten Leinasaar
 *         Last Edited 24 March, 2022, by Sten Leinasaar
 */
public class UserDeleteAccountEventTest {
    /**
     * Test Instance for LobbyEvent testing.
     */
    private UserDeleteAccountEvent testInstance;

    /**
     * Creata Account event instance to authorize a user.
     */
    private UserCreateAccountEvent createAccountInstance;

    /**
     * User test instance to be passed.
     */
    private User userInstance;

    /**
     * Source object that fired the event change.
     */
    private Object source;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;
    static {
        LOG = Logger.getLogger(UserDeleteAccountEventTest.class);
    }

    /**
     * Sets up the default testing setting before every test method.
     */
    @Before
    public void setUp() {
        LOG.trace("Started the setup method");
        source = new Object();
        // Email, username, password, isauthorized?
        userInstance =
            new User("sleinasa@skidmore.edu", "sleinasa", "passwd", true);
        createAccountInstance =
            new UserCreateAccountEvent(source, userInstance);

        LOG.info("SetUp method completed");
    }

    /**
     * Test that the instance is created by asserting that the testInstance is
     * not null.
     * 
     * @TODO Fails because DeleteAccount event isn't yet actually deleting an
     *       event.
     */
    @Test
    public void testUserDeleteAccountEvent() {
        LOG.trace("Testing the constructor of UserDeleteAccountEvent");

        assertNotNull(createAccountInstance);
        assertTrue(userInstance.isAuthorized());

        testInstance = new UserDeleteAccountEvent(source, userInstance);
        // now the user should not be authorized anymore
        assertFalse(userInstance.isAuthorized());

        LOG.trace("Constructor test completed");

    }

    /**
     * Tests that the user assigned to the event is the one passed to the
     * constructor.
     */
    @Test
    public void testGetUser() {
        LOG.trace("Testing getUser method.");
        testInstance = new UserDeleteAccountEvent(source, userInstance);
        assertEquals(testInstance.getUser(), userInstance);
        LOG.trace("Testing getUser finished.");

    }

    /**
     * Tests if the event name passed to the constructor will be returned
     * correctly.
     */
    @Test
    public void testGetEventName() {
        LOG.trace("Testing getEventName");
        testInstance = new UserDeleteAccountEvent(source, userInstance);
        assertEquals(testInstance.getEventName(), "User Delete Account Event");
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
        userInstance = null;

        LOG.trace("Assert that teardown was succesful");
        assertNull(testInstance);
        assertNull(source);
        assertNull(userInstance);

        LOG.trace("Teardown completed");

    }
}
