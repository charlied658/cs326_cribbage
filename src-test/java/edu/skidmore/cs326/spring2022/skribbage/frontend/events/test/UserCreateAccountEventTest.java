package edu.skidmore.cs326.spring2022.skribbage.frontend.events.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserCreateAccountEvent;

/**
 * @author Sten Leinasaar
 *         Last Edited: March 24, 2022 by Sten Leinasaar
 */
public class UserCreateAccountEventTest {
    /**
     * Test Instance for LobbyEvent testing.
     */
    private UserCreateAccountEvent testInstance;

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
        LOG = Logger.getLogger(UserCreateAccountEventTest.class);
    }

    /**
     * Sets up the default testing setting before every test method.
     * 
     */
    @Before
    public void setUp() {
        LOG.trace("Started the setup method");
        source = new Object();
        userInstance =
            // Email, username, password, isauthorized?
            new User("sleinasa@skidmore.edu", "sleinasa", "passwd", true);
        testInstance = new UserCreateAccountEvent(source, userInstance);
        
        LOG.info("SetUp method completed");
    }

    /**
     * Test that the instance is created by asserting that the testInstance is
     * not null.
     */
    @Test
    public void testUserCreateAccountEvent() {
        LOG.trace("Testing the constructor of UserCreateAccountEvent");
        
        assertNotNull(testInstance);
        assertEquals(testInstance.getSource(), source);
        assertEquals(testInstance.getUser(), userInstance);
        LOG.trace("Constructor test completed");

    }

    /**
     * Tests that the user assigned to the event is the one passed to the
     * constructor.
     */
    @Test
    public void testGetUser() {
        
        assertEquals(testInstance.getUser(), userInstance);
        assertEquals(testInstance.getUser().getUserName(),
            userInstance.getUserName());

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
