package edu.skidmore.cs326.spring2022.skribbage.common.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import edu.skidmore.cs326.spring2022.skribbage.common.EventManager;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.LoginAuthenticator;
import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.PasswordHasher;
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
     * Mockup version of AccountController for testing.
     */
    private AccountControllerMOCK accountControllerMOCK;

    /**
     * Mockup version of AccountResponseController for testing.
     */
    private AccountResponseControllerMOCK accountResponseControllerMOCK;

    /**
     * Mock user.
     */
    private User userInstance;

    /**
     * Mock email for mock user.
     */
    private static final String TEST_EMAIL = "acarney@skidmore.edu";

    /**
     * Mock username for mock user.
     */
    private static final String TEST_USERNAME = "acarney";


    /**
     * Mock Password object for mock user.
     */
    private Password testPassword;
    /**
     * Password hasher class instance.
     */
    private LoginAuthenticator hasher;

    /**
     * Mock login event.
     */
    private UserLoginEvent testEventInstance;

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
        LOG.info("SetUp Method for EventManager");
        testEventFactory = EventFactory.getInstance();
        testInstance = EventManager.getInstance();
        hasher = LoginAuthenticator.getInstance();
        accountControllerMOCK = new AccountControllerMOCK();
        accountResponseControllerMOCK = new AccountResponseControllerMOCK();
        testPassword = hasher.hashNewPassword("password");
        userInstance = new User(TEST_EMAIL, TEST_USERNAME,
            UserRole.UNAUTHORIZED);

        testEventInstance = (UserLoginEvent) testEventFactory
            .createEvent(EventType.USER_LOGIN, this, userInstance,
                testPassword);
        
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
        testInstance.addPropertyChangeListener(
            accountControllerMOCK, EventType.USER_LOGIN);
        
        
        LOG.trace("added account response controller mock to listeners");
        testInstance.addPropertyChangeListener(
            accountResponseControllerMOCK,
            EventType.USER_LOGIN_RESPONSE);
        
        
        
        testInstance.notify(testEventInstance);
        
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
        // add the listener to the list to listen to the loginEvent.
        testInstance.addPropertyChangeListener(accountControllerMOCK,
            EventType.USER_LOGIN);
        testInstance.notify(testEventInstance);

        // Actually fire the event
        
        assertNotNull(testEventInstance);
        LOG.trace("created event " + testEventInstance);
        testEventFactory.fireEvent(testEventInstance);
        LOG.trace("fired said event");
        
        
        // Fire an event that should be ignored
        
        assertNotNull(testFalseEventInstance);
        LOG.trace("Created false event " + testEventInstance);
        testEventFactory.fireEvent(testFalseEventInstance);
        LOG.trace("fired said false event");
        
        testInstance.removePropertyChangeListener(accountControllerMOCK);
        testInstance.notify(testEventInstance);
        
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
        LOG.trace("Running: tearDown");
        testInstance = null;
        userInstance = null;
        testEventInstance = null;

        assertNull(testInstance);
        assertNull(userInstance);

    }

}

// /**
// * Determines whether the mock controller received the mock event.
// * Additionally, ensures User object is the same
// */
// @Test
// public void testListenerCaughtCorrectUser() {
// User caughtUser = accountControllerMOCK.getReceivedUserFromLogin();
// assertNotNull(caughtUser);
// assertEquals(caughtUser, testUser);
// }
//
// /**
// * Determines whether the mock controller ignored an event
// * not subscribed to. There should be no User object since
// * the event was ignored.
// */
// @Test
// public void testListenerIgnoresIncorrectEvent() {
// User nullUser =
// accountControllerMOCK.getReceivedUserFromCreateAccount();
// assertNull(nullUser);
// }
//
// /**
// * Determines if the response controller obtained the User from
// * the logic end. Additionally, ensures that permissions were
// * updated accordingly.
// */
// @Test
// public void testresponseControllerCaughtCorrectUserAndIsAuthorized() {
// User caughtUserResponse =
// accountResponseControllerMOCK.getReceivedUserFromLogin();
// LOG.trace(caughtUserResponse);
// assertEquals(caughtUserResponse, testUser);
// assertEquals(caughtUserResponse.getUserRole(), UserRole.AUTHORIZED);
// }
//
// }
//
// }
