package edu.skidmore.cs326.spring2022.skribbage.frontend.events.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserLoginEvent;

/**
 * @author Sten Leinasaar
 *         Last Edited March 24, 2022 by Sten Leinasaar
 */
public class UserLoginEventTest {
    /**
     * User instance for testing.
     */
    private User userInstance;

    /**
     * Test instance.
     */
    private UserLoginEvent testInstance;

    /**
     * Source instance to be passed with methods.
     */
    private Object source;

    /**
     * Logger Instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(UserLoginEventTest.class);
    }

    /**
     * Setup Method to initialize testing conditions.
     */
    @Before
    public void setUp() {
        LOG.trace("SetUp method started");
        source = new Object();
        userInstance =
            new User("sleinasa@skidmore.edu", "sleinasa", "password", true);
        testInstance = new UserLoginEvent(source, userInstance);
        LOG.trace("SetUp method finished");
    }

    /**
     * Testing the constructor of UserLoginEvent.
     */
    @Test
    public void testUserLoginEvent() {
        LOG.trace("Testing the constructor");
        assertNotNull(testInstance);
        assertTrue(testInstance.getUser().isAuthorized());
        assertEquals(testInstance.getUser(), userInstance);
        LOG.trace("Constructor testing completed");
    }

    /**
     * Tests that the user assigned to the event is the one passed to the
     * constructor.
     */
    @Test
    public void testGetUser() {
        LOG.trace("Testing getUser method");
        assertEquals(testInstance.getUser(), userInstance);
        assertEquals(testInstance.getUser().getUserName(),
            userInstance.getUserName());
        assertTrue(userInstance.isAuthorized());
        assertTrue(testInstance.getUser().isAuthorized());
        LOG.trace("Getuser method testing finished");

    }

    /**
     * Tests if the event name passed to the constructor will be returned
     * correctly.
     */
    @Test
    public void testGetEventName() {
        LOG.trace("Testing getEventName");
        assertEquals(testInstance.getEventName(), "User Create Account Event");
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
