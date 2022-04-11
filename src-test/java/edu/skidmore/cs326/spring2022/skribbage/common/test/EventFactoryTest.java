package edu.skidmore.cs326.spring2022.skribbage.common.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserCreateAccountEvent;

import edu.skidmore.cs326.spring2022.skribbage.frontend.events.test.UserDeleteAccountEventTest;

/**
 * @author Sten Leinasaar
 *         Last Edited: March 24, 2022, by Sten Leinasaar
 */
public class EventFactoryTest {
    /**
     * Test Instance for LobbyEvent testing.
     */
    private EventFactory testInstance;

    /**
     * Create Account instance.
     */
    private UserCreateAccountEvent createInstance;

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
//        userInstance =
//            new User("sleinasa@skidmore.edu", "sleinasa", "passwd", true);
        testInstance = EventFactory.getInstance();
        LOG.info("SetUp method completed");
    }

    /**
     * Test that the instance is created by asserting that the testInstance is
     * not null.
     */
    @Test
    public void testGetInstance() {
        LOG.trace("Testing the getInstance method");
        assertEquals(testInstance, EventFactory.getInstance());
        LOG.trace("Get Instance test completed");

    }

    /**
     * Method to test factory create Event method.
     * @throws Exception 
     */
    @Test
    public void testCreateEvent() throws Exception {
        LOG.trace("Beginning test for CreateEvent method");
        assertNull(createInstance);
        createInstance = (UserCreateAccountEvent) testInstance
            .createEvent(EventType.USER_CREATE_ACCOUNT, source, userInstance);
        assertNotNull(createInstance);
        LOG.trace("Create event test finished");
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
