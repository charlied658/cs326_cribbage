package edu.skidmore.cs326.spring2022.skribbage.common.test;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.beans.PropertyChangeListener;
import edu.skidmore.cs326.spring2022.skribbage.common.EventManager;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.accountevents.UserLoginEvent;

/**
 * @author Sten Leinasaar
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

    private EventManager testInstance;

    private UserLoginEvent loginEventInstance;

    private User userInstance;
    private PropertyChangeListener listenerInstance;

    /**
     * @BEFORE
     *         TO set up necessary objects and variables that will be used
     *         during
     *         testing. Runs before each test method is run.
     */
    @Before
    public void setUp() {
        testInstance = EventManager.getInstance();
        userInstance =
            new User("sleinasa@skidmore.edu", "sleinasa", "passwd", true);
        // loginEventInstance = new UserLoginEvent(Object source, userInstance);
        listenerInstance = new PropertyChangeListener();
        // I need to set up a listener object as well.
        LOG.info("SetUp method completed for EventManagerTest");
    }

    /**
     * Test method to test the eager singelton instance.
     */
    @Test
    public void testGetInstance() {
        LOG.info("Beginning the testGetInstance");
        assertEquals(testInstance, EventManager.getInstance());
        LOG.info("testGetInstance completed");
    }

    /**
     * Test case to test addPropertChangeListener method. This test ensures that
     * PropertyChangeListener is added to the list of propertyChangeListeners.
     * It is
     * verified by checking if notify fires an update.
     */
    @Test
    public void testAddPropertyChangeListener() {
        LOG.info("Beginning to test addPropertyChangeListener");
        // add the listener to the list to listen to the loginEvent.
        // send out a change in login event

        // assert that some value change got to the listener. Maybe assert that
        // password sent was same as I set in setup.
    }

    /**
     * Test case to test if PropertyChangeListener was removed correctly.
     */
    @Test
    public void testRemovePropertyChangeListener() {
        LOG.info("Beginning to test removePropertyChangeListener");
        // set the listener and repeat the addproperty.
        // Then remove the listener and assert that this time it doesn't reach
        // them. asserNull for example
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
     *        Currently created just in case some tearDown is needed
     */
    @After
    public void tearDown() {

    }

}
