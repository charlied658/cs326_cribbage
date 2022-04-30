package edu.skidmore.cs326.spring2022.skribbage.frontend.events.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.LoginAuthenticator;
import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
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
     * Password instance.
     */
    private Password password;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;
    static {
        LOG = Logger.getLogger(UserCreateAccountEventTest.class);
    }

    /**
     * Sets up the default testing setting before every test method.
     */
    @Before
    public void setUp() {
        LOG.trace("Started the setup method");
        userInstance = new User("sleinasa@skidmore.edu", "username",
            UserRole.UNAUTHORIZED);
        password = LoginAuthenticator.getInstance().hashNewPassword("password");
        testInstance = new UserCreateAccountEvent(this, userInstance, password);

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
        assertEquals(testInstance.getUser(), userInstance);
        LOG.trace("Constructor test completed");

    }

    /**
     * Tests that the user assigned to the event is the one passed to the
     * constructor.
     */
    @Test
    public void testGetUser() {
        LOG.trace("Testing getUser method of UserCreateAccountEvent.");
        assertEquals(testInstance.getUser(), userInstance);
        LOG.trace("Testing getUser finished.");

    }
    /**
     * Tests that the password object passed back is the same as passed in. 
     */
    @Test
    public void testGetPassword() {
        LOG.info("Get password test started.");
        assertEquals(testInstance.getPassword(), password);
        LOG.info("Get Password test finished.");
    }

    /**
     * Tests if the event name passed to the constructor will be returned
     * correctly.
     */
    @Test
    public void testGetEventType() {
        LOG.trace("Testing getEventName");
        assertEquals(testInstance.getEventType(),
            EventType.USER_CREATE_ACCOUNT);
        LOG.trace("Completed testing the getEventName method");
    }

}
