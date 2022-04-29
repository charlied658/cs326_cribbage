package edu.skidmore.cs326.spring2022.skribbage.common.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.LoginAuthenticator;
import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserCreateAccountEvent;

/**
 * @author Sten Leinasaar
 *         Last Edited: April 19, 2022, by Sten Leinasaar
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
     * Password object instane for the user.
     */
    private Password password;

    /**
     * Source object that fired the event change.
     */
    private Object source;

    /**
     * Instane of the login authenticator to hash a password.
     */
    private LoginAuthenticator testHash;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;
    static {
        LOG = Logger.getLogger(EventFactoryTest.class);
    }

    /**
     * Sets up the default testing setting before every test method.
     */
    @Before
    public void setUp() {
        LOG.trace("Started the setup method");
        source = new Object();
        userInstance = new User("sleinasa@skidmore.edu",
            "sleinasa", UserRole.UNAUTHORIZED);
        testInstance = EventFactory.getInstance();
        testHash = LoginAuthenticator.getInstance();
        password = testHash.hashNewPassword("password");
        LOG.info("SetUp method completed");
    }

    /**
     * Test that the instance is created and functions as singleton.
     */
    @Test
    public void testGetInstance() {
        LOG.trace("Testing the getInstance method");
        assertEquals(testInstance, EventFactory.getInstance());
        LOG.trace("Get Instance test completed");

    }

    /**
     * Method to test factory create Event method.
     * 
     * @throws Exception
     */
    @Test
    public void testCreateEvent() throws Exception {
        LOG.info("Beginning test for CreateEvent method");
        assertNull(createInstance);
        createInstance = (UserCreateAccountEvent) testInstance
            .createEvent(EventType.USER_CREATE_ACCOUNT, source, userInstance,
                password);
        assertNotNull(createInstance);
        assertEquals(createInstance.getEventType(),
            EventType.USER_CREATE_ACCOUNT);
        LOG.info("Create event test finished");
    }

    /**
     * Method to check if eventFactory returns null when event is not handled in
     * any of the factories.
     */
    @Test
    public void testCreateEventNull() {
        LOG.info("Testing event  Factory returning null.");
        createInstance = (UserCreateAccountEvent) testInstance.createEvent(
            EventType.TEST_EVENT_NOT_HANDLED, source, userInstance);
        LOG.info("Test finished");
    }

    /**
     * Method to test eventFactory expection being thrown.
     * Exception occurs when event creation parameters don't match the ones in
     * enum.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testCreateEventFailure() {
        LOG.info("Testing exception when parameters don't match");
        createInstance = (UserCreateAccountEvent) testInstance
            .createEvent(EventType.USER_CREATE_ACCOUNT, source, userInstance);
    }
    
}
