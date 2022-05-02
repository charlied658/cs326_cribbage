package edu.skidmore.cs326.spring2022.skribbage.frontend.events.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserLoginEvent;

/**
 * @author Sten Leinasaar
 *         Last Edited March 29, 2022 by Sten Leinasaar
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
     * Passwor object for logging in.
     */
    private String password;

    /**
     * Logger Instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(UserLoginEventTest.class);
    }

    /**
     * Setup Method to initialize testing conditions.
     * 
     * @throws Exception
     *             when event can not be found.
     */
    @Before
    public void setUp() throws Exception {
        LOG.trace("SetUp method started");
        userInstance = new User("sleinasa@skidmore.edu", "sleinasa",
            UserRole.UNAUTHORIZED);
        password = "password";
        testInstance = new UserLoginEvent(this, userInstance, password);
        LOG.trace("SetUp method finished");
    } 

    /**
     * Testing the constructor of UserLoginEvent.
     */
    @Test
    public void testUserLoginEvent() {
        LOG.trace("Testing the constructor");
        assertNotNull(testInstance);
        LOG.trace("Constructor testing completed");
    }

    /**
     * Tests that the user assigned to the event is the one passed to the
     * constructor.
     */
    @Test
    public void testGetPassword() {
        LOG.trace("Testing getUser method");
        assertEquals(testInstance.getPassword(), password);
        LOG.trace("Getuser method testing finished");

    }

    /**
     * Tests if the event name passed to the constructor will be returned
     * correctly.
     */
    @Test
    public void testGetEventType() {
        LOG.trace("Testing getEventName");
        assertEquals(testInstance.getEventType(), EventType.USER_LOGIN);
        LOG.trace("Completed testing the getEventType method");
    }

}
