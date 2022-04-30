package edu.skidmore.cs326.spring2022.skribbage.frontend.events.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
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
     * User test instance to be passed.
     */
    private User userInstance;

    /**
     * String password.
     */
    private String password;

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
        // Email, username, password, isauthorized?
        userInstance = new User("sleinasa@skidmore.edu", "sleinasa",
            UserRole.UNAUTHORIZED);
        password = "password";
        testInstance =
            new UserDeleteAccountEvent(this, userInstance, password);

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
        assertNotNull(testInstance);
        LOG.trace("Constructor test completed");

    }

    /**
     * Tests that the user assigned to the event is the one passed to the
     * constructor.
     */
    @Test
    public void testGetPassword() {
        LOG.trace("Testing getUser method.");
        assertEquals(testInstance.getPassword(), password);
        LOG.trace("Testing getUser finished.");

    }

    /**
     * Tests if the event name passed to the constructor will be returned
     * correctly.
     */
    @Test
    public void testGetEventType() {
        LOG.trace("Testing getEventName");
        assertEquals(testInstance.getEventType(),
            EventType.USER_DELETE_ACCOUNT);
        LOG.trace("Completed testing the getEventName method");
    }

}
