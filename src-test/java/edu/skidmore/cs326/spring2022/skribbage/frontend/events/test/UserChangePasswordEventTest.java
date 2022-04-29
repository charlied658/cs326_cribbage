package edu.skidmore.cs326.spring2022.skribbage.frontend.events.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.LoginAuthenticator;
import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserChangePasswordEvent;

/**
 * @author Sten Leinasaar
 *         Last Edited: By Sten, March 23, 2022
 */
public class UserChangePasswordEventTest {
    /**
     * Test Instance for LobbyEvent testing.
     */
    private UserChangePasswordEvent testInstance;

    /**
     * User test instance to be passed.
     */
    private User userInstance;

    /**
     * Password of the user.
     */
    private Password password;

    /**
     * Source object that fired the event change.
     */
    private Object source;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;
    static {
        LOG = Logger.getLogger(UserChangePasswordEventTest.class);
    }

    /**
     * Sets up the default testing setting before every test method.
     */
    @Before
    public void setUp() {
        LOG.trace("Started the setup method");
        source = new Object();
        userInstance = new User("sleinasa@skidmore.edu", "sleinasa",
            UserRole.UNAUTHORIZED);
        password = LoginAuthenticator.getInstance().hashNewPassword("password");

        testInstance =
            new UserChangePasswordEvent(source, userInstance, password);

        LOG.info("SetUp method completed");
    }

    /**
     * Test that the instance is created by asserting that the testInstance is
     * not null.
     */
    @Test
    public void testUserChangePasswordEvent() {
        LOG.trace("Testing the constructor of UserChangePasswordEvent");
        assertNotNull(testInstance);
        assertEquals(testInstance.getSource(), source);
        LOG.trace("Constructor test completed");

    }

    /**
     * Tests that the user assigned to the event is the one passed to the
     * constructor.
     */
    @Test
    public void testGetUser() {
        LOG.trace("Testing getUser method.");
        assertEquals(testInstance.getUser(), userInstance);
        LOG.trace("GetUser test finished.");

    }

    /**
     * Tests if the event name passed to the constructor will be returned
     * correctly.
     */
    @Test
    public void testGetEventName() {
        LOG.trace("Testing getEventName");
        assertEquals(testInstance.getEventType().getName(),
            "User Change Password Event");
        LOG.trace("Completed testing the getEventName method");
    }
    
    /**
     * Test to check if new Password is returned properly.
     */
    @Test
    public void testGetNewPassword() {
        LOG.trace("Testing getNewPassword method");
        assertEquals(testInstance.getNewPassword(), password);
        LOG.trace("Test getNewPassword completed.");
    }

}
