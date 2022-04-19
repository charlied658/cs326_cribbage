package edu.skidmore.cs326.spring2022.skribbage.common.test;

import edu.skidmore.cs326.spring2022.skribbage.common.EventFactory;
import edu.skidmore.cs326.spring2022.skribbage.common.EventManager;
import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.common.EventType;
import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserCreateAccountEvent;
import edu.skidmore.cs326.spring2022.skribbage.frontend.events.UserLoginEvent;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Full test of event functionality. Mocks an interaction between
 * a user logging in on the front end, and being authenticated and
 * returned by the back end.
 * 
 * @author Alex Carney
 */
public class AccountEventLoopTest {

    /**
     * Borrow an instance of event factory for testing.
     */
    private EventFactory testFactoryInstance;

    /**
     * Borrow an instance of event manager for testing.
     */
    private EventManager eventManagerInstance;

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
    private User testUser;

    /**
     * Mock email for mock user.
     */
    private static final String TEST_EMAIL = "acarney@skidmore.edu";

    /**
     * Mock username for mock user.
     */
    private static final String TEST_USERNAME = "acarney";

    /**
     * Mock password raw string value for mock user.
     */
    private static final String TEST_PASSWORD = "password";

    /**
     * Mock Password object for mock user.
     */
    private Password testPassword;

    /**
     * Mock login event.
     */
    private UserLoginEvent testEventInstance;

    /**
     * Mock create account event.
     */
    private UserCreateAccountEvent testFalseEventInstance;

    /**
     * Logger.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(AccountEventLoopTest.class);
    }

    /**
     * Sets up testing environment.
     */
    @Before
    public void setUp() {
        testFactoryInstance = EventFactory.getInstance();
        LOG.trace("test factory instance obtained");
        eventManagerInstance = EventManager.getInstance();
        LOG.trace("test manager instance obtained");
        accountControllerMOCK = new AccountControllerMOCK();
        LOG.trace("test controller mock instance Created");
        accountResponseControllerMOCK = new AccountResponseControllerMOCK();
        LOG.trace("test response controller mock instance Created");
        assertNotNull(accountControllerMOCK);
        assertNotNull(accountResponseControllerMOCK);

        LOG.trace("added account controller mock to listeners");
        eventManagerInstance.addPropertyChangeListener(
            accountControllerMOCK,
            EventType.USER_LOGIN);
        LOG.trace("added account response controller mock to listeners");
        eventManagerInstance.addPropertyChangeListener(
            accountResponseControllerMOCK,
            EventType.USER_LOGIN_RESPONSE);

        testPassword = new Password(TEST_PASSWORD);
        testUser = new User(TEST_EMAIL, TEST_USERNAME,
            UserRole.UNAUTHORIZED);

        // Actually fire the event
        testEventInstance = (UserLoginEvent) testFactoryInstance
            .createEvent(EventType.USER_LOGIN, this, testUser,
                testPassword);
        assertNotNull(testEventInstance);
        LOG.trace("created event " + testEventInstance);
        testFactoryInstance.fireEvent(testEventInstance);
        LOG.trace("fired said event");

        // Fire an event that should be ignored
        testFalseEventInstance = ((UserCreateAccountEvent) testFactoryInstance
            .createEvent(EventType.USER_CREATE_ACCOUNT, this, testUser,
                testPassword));
        assertNotNull(testFalseEventInstance);
        LOG.trace("Created false event " + testEventInstance);
        testFactoryInstance.fireEvent(testFalseEventInstance);
        LOG.trace("fired said false event");
    }

    /**
     * Determines whether the mock controller received the mock event.
     * Additionally, ensures User object is the same
     */
    @Test
    public void testListenerCaughtCorrectUser() {
        User caughtUser = accountControllerMOCK.getReceivedUserFromLogin();
        assertNotNull(caughtUser);
        assertEquals(caughtUser, testUser);
    }

    /**
     * Determines whether the mock controller ignored an event
     * not subscribed to. There should be no User object since
     * the event was ignored.
     */
    @Test
    public void testListenerIgnoresIncorrectEvent() {
        User nullUser =
            accountControllerMOCK.getReceivedUserFromCreateAccount();
        assertNull(nullUser);
    }

    /**
     * Determines if the response controller obtained the User from
     * the logic end. Additionally, ensures that permissions were
     * updated accordingly.
     */
    @Test
    public void testresponseControllerCaughtCorrectUserAndIsAuthorized() {
        User caughtUserResponse =
            accountResponseControllerMOCK.getReceivedUserFromLogin();
        LOG.trace(caughtUserResponse);
        assertEquals(caughtUserResponse, testUser);
        assertEquals(caughtUserResponse.getUserRole(), UserRole.AUTHORIZED);
    }

}
