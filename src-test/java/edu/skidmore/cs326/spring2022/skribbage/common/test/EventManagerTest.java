package edu.skidmore.cs326.spring2022.skribbage.common.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventManager;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserLoginEvent;

/**
 * Testing for Event manager API testing.
 * 
 * @author Sten Leinasaar
 *         Last edited: March 30, 2022
 *         Last edited by: Sten Leinasaar
 */
public class EventManagerTest {
    /**
     * Logger to keep track of the order of events happening in this test class.
     * Includes static block to initialize a Logger.
     */
    private static final Logger LOG;
    static {
        LOG = Logger.getLogger(EventManagerTest.class);
    }

    /**
     * EventManager testInstance.
     */
    private EventManager testInstance;

    /**
     * UserLoginEvent testInstance.
     */
    private UserLoginEvent loginEventInstance;

    /**
     * User testInstance.
     */
    private User userInstance;

    /**
     * LogInListener Mock class instance.
     */
    private LogInListenerMOCK listenerInstance;

    /**
     * Instance of this test class to send out an change in state.
     */
    private EventManagerTest source;

    /**
     * @throws Exception 
     * @BEFORE
     *         TO set up necessary objects and variables that will be used
     *         during
     *         testing. Runs before each test method is run.
     */
    @Before
    public void setUp() throws Exception {
        testInstance = EventManager.getInstance();
        userInstance =
            new User("sleinasa@skidmore.edu", "sleinasa", "passwd", true);
        source = new EventManagerTest();
        loginEventInstance = (UserLoginEvent) EventFactory.getInstance()
            .createEvent(EventType.USER_LOGIN, source, userInstance);

        // I need to set up a listener object as well.
        listenerInstance = new LogInListenerMOCK();

        LOG.info("SetUp method completed for EventManagerTest");
    }

    /**
     * This method tests getInstance method from EventManager class.
     * The test ensures the correct implementation of a singleton pattern.
     */
    @Test
    public void testGetInstance() {
        LOG.info("Beginning the testGetInstance");
        assertEquals(testInstance, EventManager.getInstance());
        LOG.info("testGetInstance completed");
    }

    /**
     * Test case to test addPropertChangeListener method from EventManager.
     * This test ensures that PropertyChangeListener
     * is added to the list of propertyChangeListeners.
     * It is verified by checking if an update is received by the listener.
     */
    @Test
    public void testAddPropertyChangeListener() {
        LOG.info("Beginning to test addPropertyChangeListener");
        testInstance.addPropertyChangeListener(listenerInstance,
            EventType.USER_LOGIN);
        assertNull(listenerInstance.getUserLoginEvent());
        testInstance.notify(loginEventInstance);
        assertNotNull(listenerInstance.getUserLoginEvent());
        LOG.info("AddPropertyChangeListener test finished.");

    }

    /**
     * Test case to test if PropertyChangeListener was removed correctly.
     * @throws Exception 
     * 
     * @ToDo Make an UML to understand exactly how EventManager is connected
     *       and then write more comprehensive testing.
     */
    @Test
    public void testRemovePropertyChangeListener() throws Exception {
        LOG.info("Beginning to test removePropertyChangeListener");
        // add the listener to the list to listen to the loginEvent.
        testInstance.addPropertyChangeListener(listenerInstance,
            EventType.USER_LOGIN);
        testInstance.notify(loginEventInstance);
        // now change the userInstance and the logInEvent instance.
        userInstance =
            new User("sleinasa@skidmore.edu", "username", "password", true);
        loginEventInstance = (UserLoginEvent) EventFactory.getInstance()
            .createEvent(EventType.USER_LOGIN, source, userInstance);

        testInstance.removePropertyChangeListener(listenerInstance);
        testInstance.notify(loginEventInstance);
        assertNotEquals(listenerInstance.getUserLoginEvent(),
            listenerInstance.getUserLoginEvent());
        // assert that some value change got to the listener. Maybe assert that
        // assertEquals(listenerInstance, userInstance);
        // The object sent to listenerInstance should be the same as
        // userInstance
        // assertTrue(listenerInstance.equals(userInstance));

        // assertFalse(listenerInstance.equals(userInstance));

    }

    /**
     * Test case to notify all the added PropertyChangeListeners.
     */
    @Test
    public void testNotify() {
        LOG.info("Began testing notify method");
        // test the same way as tested addPropertyListener. Exactly the same
        // way.
    }

    /**
     * @AFTER method that runs after each test case.
     */
    @After
    public void tearDown() {
        System.out.println("Running: tearDown");
        testInstance = null;
        userInstance = null;
        loginEventInstance = null;

        assertNull(testInstance);
        assertNull(userInstance);
        assertNull(loginEventInstance);

    }

}
