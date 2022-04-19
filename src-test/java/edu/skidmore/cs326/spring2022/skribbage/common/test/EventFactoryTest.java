package edu.skidmore.cs326.spring2022.skribbage.common.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
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
     * Source object that fired the event change.
     */
    private Object source;

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
        userInstance = new User("sleinasa");
        testInstance = EventFactory.getInstance();
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
        LOG.trace("Beginning test for CreateEvent method");
        assertNull(createInstance);
        createInstance = (UserCreateAccountEvent) testInstance
            .createEvent(EventType.USER_CREATE_ACCOUNT, source, userInstance);
        assertNotNull(createInstance);
        assertEquals(createInstance.getEventType(),
            EventType.USER_CREATE_ACCOUNT);
        LOG.trace("Create event test finished");
    }
    
   

   
}
