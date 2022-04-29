package edu.skidmore.cs326.spring2022.skribbage.common.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import edu.skidmore.cs326.spring2022.skribbage.common.EventManager;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.LoginAuthenticator;
import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserCreateAccountEvent;
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
     * Borrow an instance of event factory for testing.
     */
    private EventFactory testEventFactory;

    /**
     * Borrow an instance of event manager for testing.
     */
    private EventManager testInstance;

    /**
     * Mockup version of AccountResponseController for testing.
     */
    private AccountResponseControllerMOCK accountResponseControllerMOCK;

    /**
     * Private MOCK Controller instance.
     */
    private AccountControllerMOCK controller;

    /**
     * Mock user.
     */
    private User userInstance;

    /**
     * Mock user two to check removing works.
     */
    private User userInstanceTwo;

    /**
     * Mock Password object for mock user.
     */
    private Password testPassword;

    /**
     * Login password type.
     */
    private String password;

    /**
     * Password hasher class instance.
     */
    private LoginAuthenticator hasher;

    /**
     * Mock login event.
     */
    private UserLoginEvent testEventInstance;

    /**
     * Mock login event to check removal of listener.
     */
    private UserLoginEvent testEventInstanceTwo;

    /**
     * Mock create account event.
     */
    private UserCreateAccountEvent testFalseEventInstance;

    /**
     * @throws Exception
     * @BEFORE
     *         TO set up necessary objects and variables that will be used
     *         during
     *         testing. Runs before each test method is run.
     */
    @Before
    public void setUp() {
        LOG.info("Setup method reached.");
        testEventFactory = EventFactory.getInstance();
        testInstance = EventManager.getInstance();
        hasher = LoginAuthenticator.getInstance();
        accountResponseControllerMOCK = new AccountResponseControllerMOCK();
        controller = new AccountControllerMOCK();
        testPassword = hasher.hashNewPassword("password");
        password = "password";
        userInstance =
            new User("acarney@skidmore.edu", "acarney", UserRole.UNAUTHORIZED);
        userInstanceTwo =
            new User("sleinasa@skidmore.edu", "user", UserRole.UNAUTHORIZED);

        testInstance.addPropertyChangeListener(controller,
            EventType.USER_LOGIN);
        LOG.trace("added account response controller mock to listeners");
        testInstance.addPropertyChangeListener(
            accountResponseControllerMOCK,
            EventType.USER_LOGIN_RESPONSE);

        testEventInstance = (UserLoginEvent) testEventFactory
            .createEvent(EventType.USER_LOGIN, this, userInstance, password);
        testEventInstanceTwo =
            (UserLoginEvent) testEventFactory.createEvent(EventType.USER_LOGIN,
                this, userInstanceTwo, password);

        testFalseEventInstance = ((UserCreateAccountEvent) testEventFactory
            .createEvent(EventType.USER_CREATE_ACCOUNT, this, userInstance,
                testPassword));

    }

    /**
     * This method tests getInstance method from EventManager class.
     * The test ensures the correct implementation of a singleton pattern.
     */
    @Test
    public void testGetInstance() {
        LOG.info("Testing get instance.");
        assertEquals(testInstance, EventManager.getInstance());
        LOG.info("Get instance testing completed.");
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
        LOG.debug(
            "Firing an event:" + testEventInstance.getEventType().getName());
        testEventFactory.fireEvent(testEventInstance);

        assertEquals(userInstance,
            accountResponseControllerMOCK.getUser());

        LOG.info("AddPropertyChangeListener test finished.");

    }

    /**
     * Test case to test if PropertyChangeListener was removed correctly.
     * 
     * @throws Exception
     * @ToDo Make an UML to understand exactly how EventManager is connected
     *       and then write more comprehensive testing.
     */
    @Test
    public void testRemovePropertyChangeListener() throws Exception {
        LOG.info("Beginning to test removePropertyChangeListener");
        // Show that is still listens.
        testEventFactory.fireEvent(testEventInstance);
        assertEquals(accountResponseControllerMOCK.getUser(),
            userInstance);
        // Now removing. Show it doesn't listen anymore.
        LOG.trace("Removing property changeListener.");
        testInstance
            .removePropertyChangeListener(accountResponseControllerMOCK);
        LOG.trace(
            "Firing event that should not be listened for."
                + testEventInstanceTwo.getEventType().getName());
        testEventFactory.fireEvent(testEventInstanceTwo);
        assertNotEquals(
            accountResponseControllerMOCK.getUser(),
            userInstanceTwo);

    }

    /**
     * Test case to notify all the added PropertyChangeListeners.
     */
    @Test
    public void testNotify() {
        LOG.info("Began testing notify method.");
        testInstance.addPropertyChangeListener(accountResponseControllerMOCK,
            EventType.USER_LOGIN_RESPONSE);
        testEventFactory.fireEvent(testEventInstance);
        assertEquals(accountResponseControllerMOCK.getUser(),
            userInstance);
        LOG.info("Notify method testing completed.");
    }


}
